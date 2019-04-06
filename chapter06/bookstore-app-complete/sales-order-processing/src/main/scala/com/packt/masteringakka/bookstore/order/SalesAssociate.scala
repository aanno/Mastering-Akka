package com.packt.masteringakka.bookstore.order

import akka.actor._
import slick.jdbc.GetResult

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import concurrent.duration._
import com.packt.masteringakka.bookstore.inventory.Book
import com.packt.masteringakka.bookstore.common._
import java.util.UUID

import akka.NotUsed
import com.packt.masteringakka.bookstore.credit.CreditCardInfo
import akka.stream.ActorMaterializer
import akka.stream.ActorMaterializer
import akka.persistence.query.{EventEnvelope, Offset, PersistenceQuery, Sequence, NoOffset}
import akka.persistence.cassandra.query.scaladsl.CassandraReadJournal
import akka.stream.scaladsl.{Sink, Source}

/**
 * Companion to the SalesOrderManager service
 */
object SalesAssociate{
  val Name = "sales-associate"
  def props = Props[SalesAssociate]
   
  case class CreateNewOrder(userEmail:String, lineItems:List[SalesOrder.LineItemRequest], cardInfo:CreditCardInfo)
  case class FindOrderById(id:String)
  case class StatusChange(orderId:String, status:LineItemStatus.Value, bookId:String, offset:Offset)
}

/**
 * Factory for performing actions related to sales orders
 */
class SalesAssociate extends Aggregate[SalesOrderFO, SalesOrder]{
  import SalesAssociate._
  import Book.Event._
  import SalesOrder._
  import Command._
  import PersistentEntity._
  import context.dispatcher
  
  val projection = ResumableProjection("order-status", context.system)
  implicit val mater = ActorMaterializer()
  val journal = PersistenceQuery(context.system).
    readJournalFor[CassandraReadJournal](CassandraReadJournal.Identifier)
  projection.fetchLatestOffset.foreach{o =>
    o match {
      case Some(s @ Sequence(l)) =>
        log.info("Order status projection using an offset of: {}", new java.util.Date(l))
        val allocatedSource = journal.eventsByTag("inventoryallocated", s)
        val backorderedSource = journal.eventsByTag("inventorybackordered", s)
        run(allocatedSource, backorderedSource)
      case Some(a: Offset) =>
        log.info("Order status projection using an offset of: {}", new java.util.Date(0L))
        val allocatedSource = journal.eventsByTag("inventoryallocated", a)
        val backorderedSource = journal.eventsByTag("inventorybackordered", a)
        run(allocatedSource, backorderedSource)
      case None =>
        log.info("Order status projection using an offset of: {}", new java.util.Date(0L))
        val allocatedSource = journal.eventsByTag("inventoryallocated", NoOffset)
        val backorderedSource = journal.eventsByTag("inventorybackordered", NoOffset)
        run(allocatedSource, backorderedSource)
      /*
  case Some(Sequence(l)) =>
    log.info("Order status projection using an offset of: {}", new java.util.Date(o.getOrElse(0L)))
    allocatedSource = journal.eventsByTag("inventoryallocated", o.getOrElse(0L))
    backorderedSource = journal.eventsByTag("inventorybackordered", o.getOrElse(0L))
    */
    }
  }

  private def run(allocatedSource: Source[EventEnvelope, NotUsed], backorderedSource: Source[EventEnvelope, NotUsed]): Unit = {
    allocatedSource.
      merge(backorderedSource).
      collect{
        case EventEnvelope(offset, pid, seq, event:InventoryAllocated) =>
          StatusChange(event.orderId,  LineItemStatus.Approved, event.bookId, offset)

        case EventEnvelope(offset, pid, seq, event:InventoryBackordered) =>
          StatusChange(event.orderId,  LineItemStatus.BackOrdered, event.bookId, offset)
      }.
      runForeach(self ! _)
  }
  
  
  def entityProps(id:String) = SalesOrder.props(id)
 
  def receive = {
    case FindOrderById(id) =>
      val order = lookupOrCreateChild(id)
      order.forward(GetState)           
    
    case req:CreateNewOrder =>
      val newId = UUID.randomUUID().toString
      val entity = lookupOrCreateChild(newId)
      val orderReq = SalesOrder.Command.CreateOrder(newId, req.userEmail, req.lineItems, req.cardInfo )
      entity.forward(orderReq)
      
    case StatusChange(orderId, status, bookId, offset) =>          
      forwardCommand(orderId, UpdateLineItemStatus(bookId, status))
      projection.storeLatestOffset(offset)
  }
  
}

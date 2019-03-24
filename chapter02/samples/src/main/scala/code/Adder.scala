/*
 * Copyright 2016 Packt
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package code

import akka.actor._
import akka.event.LoggingReceive

object Adder {
  sealed trait Command
  case object Add extends Command
  case object Subtract extends Command
  case object GetValue extends Command
  def props = Props[Adder]
}

class Adder extends Actor {
  import Adder._
  def receive: Receive = amount(0)

  def amount(value: Long): Receive = LoggingReceive {
    case Add      ⇒ context.become(amount(value + 1))
    case Subtract ⇒ context.become(amount(value - 1))
    case GetValue ⇒ sender() ! value
  }
}

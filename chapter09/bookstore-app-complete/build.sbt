name := "chapter9-bookstore-common"

organization := "com.packt.masteringakka"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.8"

lazy val root = project.in(file("."))
  .aggregate(common)
  .aggregate(credit)
  .aggregate(inventory)
  .aggregate(credit)
  .aggregate(sales)
  .aggregate(user)

lazy val common = project.in( file("common"))
lazy val credit = project.in( file("credit-processing"))
lazy val inventory = project.in( file("inventory-management"))
lazy val sales = project.in( file("sales-order-processing"))
lazy val user = project.in( file("user-management"))

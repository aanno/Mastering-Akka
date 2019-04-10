name := "chapter9-bookstore-common"

organization := "com.packt.masteringakka"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.8"

lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging)

libraryDependencies ++= {
  val akkaVersion = "2.5.21"
  val akkaHttpVersion = "10.1.8"
  Seq(
    // "org.vafer" % "jdep" % "1.7",
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.93",
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
    "com.typesafe.conductr" %% "akka24-conductr-bundle-lib" % "2.2.0",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.json4s" %% "json4s-ext" % "3.6.5",
    "org.json4s" %% "json4s-native" % "3.6.5",
    "com.google.protobuf" % "protobuf-java"  % "3.7.0",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
  )
}

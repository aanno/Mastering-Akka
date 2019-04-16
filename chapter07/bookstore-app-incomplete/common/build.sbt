name := "chapter7-bookstore-common-complete"

libraryDependencies ++= {
  val akkaVersion = "2.5.21"
  val akkaHttpVersion = "10.1.8"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.93",
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "ws.unfiltered" %% "unfiltered-filter-async" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-netty" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-netty-server" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-json4s" % "0.9.1",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.json4s" %% "json4s-ext" % "3.6.5",
    "org.json4s" %% "json4s-native" % "3.6.5",
    "com.google.protobuf" % "protobuf-java"  % "3.7.0",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
  )
}

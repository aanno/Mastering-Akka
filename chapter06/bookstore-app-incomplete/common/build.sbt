name := "chapter6-bookstore-common-incomplete"

 
libraryDependencies ++= {
  val akkaVersion = "2.5.21"
  val slickVersion = "3.3.0"
  val hikariCPVersion = "3.3.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.93" excludeAll(ExclusionRule("io.netty")),
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion excludeAll(ExclusionRule("io.netty")),
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe.slick" %% "slick" % slickVersion,
    "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
    "ws.unfiltered" %% "unfiltered-filter-async" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-netty" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-netty-server" % "0.9.1",
    "ws.unfiltered" %% "unfiltered-json4s" % "0.9.1",
    "org.json4s" %% "json4s-ext" % "3.6.5",
    "org.postgresql" % "postgresql" % "42.2.5",
    "net.databinder.dispatch" %% "dispatch-core" % "0.13.4",
    // "org.dispatchhttp" %% "dispatch-core" % "1.0.1",
    "com.google.protobuf" % "protobuf-java"  % "3.7.0"
  )
}

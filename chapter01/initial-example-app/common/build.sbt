name := "initial-example-common"

val akkaVersion = "2.5.21"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.slick" %% "slick" % "3.3.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.0",
  "ws.unfiltered" %% "unfiltered-filter-async" % "0.9.1",
  "ws.unfiltered" %% "unfiltered-netty" % "0.9.1",
  "ws.unfiltered" %% "unfiltered-netty-server" % "0.9.1",
  "ws.unfiltered" %% "unfiltered-json4s" % "0.9.1",
  "org.json4s" %% "json4s-ext" % "3.6.5",
  "org.postgresql" % "postgresql" % "42.2.5",
  "net.databinder.dispatch" %% "dispatch-core" % "0.13.4"
  // "org.dispatchhttp" %% "dispatch-core" % "1.0.1"
)

name := "chapter10-samples"

organization := "com.packt.masteringakka"

version := "0.1.0"

scalaVersion := "2.12.8"

libraryDependencies ++= { 
  val akkaVersion = "2.5.21"
  Seq(
	"com.typesafe.akka" %% "akka-actor" % akkaVersion,
	"com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaVersion,    
    "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion % Test,
    "org.scalatest" %% "scalatest" % "3.0.7" % Test
  )
}

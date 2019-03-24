name := "chapter2-samples"

organization := "com.packt.masteringakka"

version := "0.1.0"

scalaVersion := "2.12.8"

libraryDependencies ++= {
  val akkaVersion = "2.5.21"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "org.scalatest" %% "scalatest" % "3.0.7" % Test
  )
}

licenses += ("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(RewriteArrowSymbols, true)

// enable updating file headers //
lazy val root = (project in file(".")).settings(
  headerLicense := Some(HeaderLicense.ALv2("2016", "Packt", HeaderLicenseStyle.SpdxSyntax)),
  organizationName := "Packt",
  startYear := Some(2016),
  licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt"))
)
/*
headers := Map(
  "scala" -> Apache2_0("2016", "Packt"),
  "conf" -> Apache2_0("2016", "Packt", "#")
)
 */

enablePlugins(AutomateHeaderPlugin)

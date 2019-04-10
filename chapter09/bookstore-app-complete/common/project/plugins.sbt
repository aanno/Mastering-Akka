// Comment to get more information during initialization
logLevel := Level.Warn

libraryDependencies += "org.vafer" % "jdeb" % "1.7" artifacts (Artifact("jdeb", "jar", "jar"))
classpathTypes += "maven-plugin"

// https://github.com/typesafehub/sbt-conductr/issues/279
// disablePlugins(BundlePlugin)
// disablePlugins(com.lightbend.conductr.sbt.BundlePlugin)

// The Typesafe repository
//resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// sbt-bundle is old and more than deprecated
//addSbtPlugin("com.typesafe.sbt" % "sbt-bintray-bundle" % "1.0.2")
// addSbtPlugin("com.typesafe.sbt" % "sbt-bundle" % "1.3.2")

addSbtPlugin("com.lightbend.conductr" % "sbt-conductr" % "2.7.2")

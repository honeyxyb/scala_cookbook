name := "scala_cookbook"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")


resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/snapshots"


libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"


libraryDependencies +=
  "com.storm-enroute" %% "scalameter" % "0.7-SNAPSHOT" % "test"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")


parallelExecution in Test := false

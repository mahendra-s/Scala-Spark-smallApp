name := """smallApp"""

version := "1.0"

scalaVersion := "2.11.8"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies +=  "org.apache.spark" %% "spark-core" % "2.1.0"

libraryDependencies +=  "org.apache.spark" %% "spark-mllib" % "2.1.0"

libraryDependencies += "com.cloudera.sparkts" % "sparkts" % "0.4.0"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"


name := """smallApp"""

version := "1.1"

scalaVersion := "2.12.8"

libraryDependencies ++=
  Seq("org.scalactic" %% "scalactic" % "3.2.11",
    "org.apache.spark" %% "spark-core" % "2.4.8",
    "org.apache.spark" %% "spark-sql" % "2.4.8",
    "org.scalatest" %% "scalatest" % "3.2.11" % "test")



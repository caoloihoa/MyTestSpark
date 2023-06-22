ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "MyTestSpark"
  )
// https://mvnrepository.com/artifact/org.apache.iceberg/iceberg-spark-runtime-3.3
libraryDependencies += "org.apache.iceberg" %% "iceberg-spark-runtime-3.3" % "1.3.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.2"
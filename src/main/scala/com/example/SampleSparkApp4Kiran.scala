package com.example

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object SampleSparkApp4Kiran extends App {

  val conf = new SparkConf().setAppName("SampleSparkJob").setMaster("local[*]")
  val spark = SparkSession
    .builder()
    .config(conf)
    .getOrCreate()

  val appHome = "."
  val fileName = "response (14).json"
  val df: DataFrame = spark.read.json(s"$appHome/work/DataStore/$fileName")
  df.show()

  spark.close()
}

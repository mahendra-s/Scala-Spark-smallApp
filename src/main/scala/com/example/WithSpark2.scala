package com.example

import com.cloudera.sparkts.models.ARIMA
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

/**
  * Created by mshinde on 10-06-2018.
  */
object WithSpark2 extends App{


  val spark = SparkSession.builder.appName("Bitcoin Price prediction").getOrCreate()
  import spark.implicits._
  val jsonData =  spark.sqlContext.read.json("./work/DataStore")

  val priceTime = jsonData.select(explode($"data.prices") as "pricetime").join(jsonData.select(explode($"data.prices.time") as "time"))
  val priceTime2 = jsonData.withColumn("prices", explode($"data.prices")).select("prices.price", "prices.time")


  priceTime2.select($"time".cast("timestamp"), $"price").distinct().count
  priceTime2.select($"time".cast("timestamp"), $"price").filter($"time" > current_timestamp()-expr("INTERVAL 1 WEEK"))
  priceTime2.select($"time".cast("timestamp"), $"price").filter($"time" > current_timestamp()-expr("INTERVAL 1 MONTH"))




//  val avg = new MovingAverage(1)
//  val lst = textFile.map(_.toDouble)//.map(avg(_))
//
//  import MovingAverageFunction._
//  implicit val movingAvgPeriod: Int = 1
//  val lst = textFile.map(_.toDouble).map(movingAvg)
//
//  val ts = Vectors.dense(priceTime2.select("price").collect())
//  val arimaModel = ARIMA.fitModel(1, 1, 1, ts)
//  //  println("coefficients: " + arimaModel.coefficients.mkString(","))
//  println(ts.toArray.mkString(","))
//  val forecast = arimaModel.forecast(ts, 20)
//  println("forecast of next 20 observations: " + forecast.toArray.mkString(","))

}

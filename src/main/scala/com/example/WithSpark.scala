package com.example

import com.cloudera.sparkts.models.ARIMA
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by mshinde on 07-06-2018.
  */
object WithSpark extends App {

  val conf = new SparkConf()
  conf.setMaster("local")
  conf.setAppName("Bitcoin Price prediction")
  val sc = new SparkContext(conf)

  val textFile = sc.textFile("C:\\Users\\mshinde\\Desktop\\Exam\\price.csv")

  val avg = new MovingAverage(1)
  //  val lst = textFile.map(_.toDouble)//.map(avg(_))

  import MovingAverageFunction._
  implicit val period: Int = 1
  val lst = textFile.map(_.toDouble).map(movingAvg)

  val ts = Vectors.dense(lst.collect())
  val arimaModel = ARIMA.fitModel(1, 1, 1, ts)
//  println("coefficients: " + arimaModel.coefficients.mkString(","))
  println(ts.toArray.mkString(","))
  val forecast = arimaModel.forecast(ts, 20)
  println("forecast of next 20 observations: " + forecast.toArray.mkString(","))

  //  Thread.sleep(100000)
}

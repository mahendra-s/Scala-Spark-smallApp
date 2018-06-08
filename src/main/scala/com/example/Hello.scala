package com.example


import com.cloudera.sparkts.models.ARIMA
import org.apache.spark.mllib.linalg.Vectors

object Hello {
  def main(args: Array[String]): Unit = {

    // The dataset is sampled from an ARIMA(1, 0, 1) model generated in R.
    val lines = scala.io.Source.fromFile("C:\\Users\\mshinde\\Desktop\\Exam\\price.csv").getLines()
    val ts = Vectors.dense(lines.map(_.toDouble).toArray)
    val arimaModel = ARIMA.fitModel(1, 1, 1, ts)
    println("coefficients: " + arimaModel.coefficients.mkString(","))
    println(ts.toArray.mkString(","))
    val forecast = arimaModel.forecast(ts, 20)//.toArray.drop(ts.size)
    println("forecast of next 20 observations: " + forecast.toArray.mkString(","))
  }
}


object Interface {
  /*
 * Historic movement of price
 *  1. last week
 *  2. last month
 *  3. between dates or
 *  4. Specific date
 */
  def getLastWeek() = ???

  def getLastMonth() = ???

  def getDateRange() = ???

  def getDate() = ???


  /*
 * Price forecasting
 * 1. for next 15 days
 * 2. for n days
 */
  def getForcastedPrice(n: Int) = ???
}
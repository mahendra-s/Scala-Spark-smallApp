package com.example

import org.apache.spark.sql.DataFrame

class LoadDataService {
  def getDataFrameJsonFile(fileName: String): DataFrame = ???
  def getDataFrameCsvFile(fileName: String): DataFrame = ???
}
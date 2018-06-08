package com.example


/**
  * Created by mshinde on 07-06-2018.
  */

/*
 * Moving average 1 solution
 */
class MovingAverage(period: Int) {
  private var queue = new scala.collection.mutable.Queue[Double]()

  def apply(n: Double): Double = {
    queue.enqueue(n)
    if (queue.size > period) queue.dequeue
    queue.sum / queue.size
  }
  override def toString = queue.mkString("(", ", ", ")") + ", period " + period + ", average " + (queue.sum / queue.size)
  def clear = queue.clear
}

/*
 * Moving average solution 2
 */
object MovingAverageFunction {
  private var queue = new scala.collection.mutable.Queue[Double]()
  def movingAvg(n: Double)(implicit period: Int): Double = {
    queue.enqueue(n)
    if (queue.size > period)  queue.dequeue
    queue.sum / queue.size
  }
  override def toString = queue.mkString("(", ", ", ")")
  def clearQueue = queue.clear
}

object MovingAvg extends App {
  val mvnAvg3 = new MovingAverage(3)
  val lst = 1 to 100

  val res1 = lst.map(mvnAvg3(_))
  println(s"Moving average object $res1")


  import MovingAverageFunction._
  implicit val period: Int = 3
  val res2 = lst.map(_.toDouble).map(movingAvg)
  MovingAverageFunction.clearQueue
  println(s"Moving averate function $res2")
}

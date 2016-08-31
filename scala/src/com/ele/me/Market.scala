package com.ele.me

import java.util

import scala.collection.immutable.Map

/**
 * Created by majun on 15/11/29.
 */
class Market private(val color: String) {
  println("creating " + this)

  override def toString(): String = "making color " + color
}

object Market {
  private val markers = Map(
    "red" -> new Market("Red"),
    "blue" -> new Market("blue"),
    "green" -> new Market("Green")
  )

  def getMarket(color: String) = {
    markers.get(color)
  }
}


object test1 {
  def main(args: Array[String]): Unit = {
    println(Market getMarket ("red"))

    val list1 = new util.ArrayList[Int]
    list1 add 1
    list1 add 2
    for (index <- 0 until list1.size()) {
      println(list1.get(index))
    }
  }
}




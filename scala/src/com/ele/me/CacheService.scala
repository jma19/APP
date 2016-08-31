package com.ele.me

import scala.collection.mutable.{Map, Set}

/**
 * Created by majun on 15/11/27.
 */
class CacheService {
  val resMap = Map[Int, String]()
  val movieSet = Set("Hitcha", "Poltergeist")

  val romanNumeral = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
  resMap += (1 -> "Go to land")
  resMap += (2 -> "Find you love")
  resMap += (3 -> "Dig.")
  println(resMap(2))

  private val array = Array(1, 2, 4)
  val oneTwoThree = List(1, 2, 3)

  def put(key: Int, vlaue: String): Unit = {
    resMap += (key -> vlaue);
  }

  def remove(key: Int): Unit = {
    resMap.remove(key)
  }

  val times = 1

  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }

}

object test {
  def main(args: Array[String]) {
    val service: CacheService = new CacheService()
  }

  def calcType() ={

  }
}

case class Calculator(brand: String, model: String)



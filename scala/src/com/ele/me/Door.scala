package com.ele.me

/**
 * Created by majun on 15/11/27.
 */
class Door(val index: Int) {

  private var isOpen = false

  def reverse() = {
    isOpen = !isOpen
  }

  def getIndex = index

  def getStatus = isOpen

  override def toString = "door with index = " + index
}

object Controller {
  //  //100 doors in a row are all initially closed. You make
  //  100 passes by the doors. The first time through, you
  //  visit every door and toggle the door (if the door is
  //    closed, you open it; if it is open, you close it).

  //  The second time you only visit every 2nd door (door
  //  #2, #4, #6, ...). The third time, every 3rd door
  //    (door #3, #6, #9, ...), etc, until you only visit
  //    the 100th door.
  //
  //  Question: What state are the doors in after the last
  //  pass? Which are open, which are closed?
  //
  //  [Source http://rosettacode.org]

  val doors = List.newBuilder[Door]
  //  var days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

  for (index <- 1 until 100) {
    doors += new Door(index)
  }

  def main(args: Array[String]): Unit = {
    printAllElement
    onlyVisit(100)
    printAllElement
  }

  def onlyVisit(index: Int) = {
    var init = 1
    println(index)
    // should reverse的条件是 % init ==0
    while (init != index) {
      doors.result().foreach(x => if (x.getIndex % init == 0) {
        x.reverse()
      })
      init += 1
    }
  }

  def printAllElement = {
    doors.result().foreach(x => println(x.getStatus))
  }
}

class Equipment(val routine: Int => Int) {
  def simulate(input: Int) = {
    print("Running simulation")
    routine(input)
  }
}

object Equipment {
  def main(args: Array[String]): Unit = {
    val equipment1 = new Equipment({ input => println("calc with" + input); input })
  }
}

class Resource private() {
  println("Starting transaction")

  private def cleanUp(): Unit = {
    println("Ending transation")
  }

  def op1 = println("Operation1")

  def op2 = println("Operation2")

  def op3 = println("Operation3")
}

object Resource {
  def use(codeBlock: Resource => Unit) = {
    val resource = new Resource

    try {
      codeBlock(resource)
    }
    finally {
      resource.cleanUp()
    }
  }
}

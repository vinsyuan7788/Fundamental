package org.lang.scala.conclusion.keyword

import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

/**
 * 	This is a stand-alone object to test break and continue
 * 	-- In Scala, by default "break" and "continue" keyword is NOT supported
 *     -- Since they can replaced by smaller recursive methods and have issues with closure, etc.
 *     -- Hence they are assumed unnecessary by Scala officials
 *  -- Since Scala 2.8, if importing "scala.util.control.Breaks._" package, then:
 *     -- Can use a "breakable" block to simulate "break" and "continue" functionality
 *     -- But "continue" block is still not supported yet (until version 2.11.8 and 2.12.1)
 *     
 * 	@author VinceYuan
 */
object TestBreakAndContinue {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    println("Here simulates single \"break\" functionality:")
    testSingleBreak()
    println("\nHere simulates multiple \"break\" functionality:")
    testMultipleBreak()
    println("\nHere simulates single \"continue\" functionality:")
    testSingleContinue()
    println("\nHere simulates multiple \"continue\" functionality:")
    testMultipleContinue()
  }
  
  /**
   * 	This is a method to simulate single "break" functionality
   *  -- For "breakable" block
   *     -- If there is "break", it will break the statements that are surrounded by the nearest "breakable" block
   *     -- If there is no "break", the statements surrounded by "breakable" block will be executed as usual
   */
  private def testSingleBreak(): Unit = {
    
    /*	To BREAK a loop, using "breakable" OUTSIDE the loop	 */
    var i = 0
    breakable {     
      while (true) {
        if (i == 10) break
        println(s"Count: ${i}")
        i += 1
      }
    }
  }
  
  /**
   * 	This is a method to simulate multiple "break" functionality
   *  -- For "breakable" block
   *     -- If there is "break", it will break the statements that are surrounded by the nearest "breakable" block
   *     -- If there is no "break", the statements surrounded by "breakable" block will be executed as usual
   */
  private def testMultipleBreak(): Unit = {
    
    /*	To BREAK a loop, using "breakable" OUTSIDE the loop	 */
    breakable {
      for (i <- 0 until 100) {
        if (i == 3) break
        breakable {
          for (j <- 0 until 100) {
            if (j == 3) break
            println(s"Count: ${i}, ${j}")
          }
        }
      }
    }
  }
  
  /**
   * 	This is a method to simulate single "continue" functionality
   *  -- For "breakable" block
   *     -- If there is "break", it will break the statements that are surrounded by the nearest "breakable" block
   *     -- If there is no "break", the statements surrounded by "breakable" block will be executed as usual
   */
  private def testSingleContinue(): Unit = {
    
    /*	To CONTINUE a loop, using "breakable" INSIDE the loop	 */
    for (i <- 0 until 10) {
      breakable {
        if (i % 2 == 0) break
        println(s"Count: ${i}")
      }
    }
  }
  
  /**
   * 	This is a method to simulate multiple "continue" functionality
   *  -- For "breakable" block
   *     -- If there is "break", it will break the statements that are surrounded by the nearest "breakable" block
   *     -- If there is no "break", the statements surrounded by "breakable" block will be executed as usual
   */
  private def testMultipleContinue(): Unit = {
    
    for (i <- 0 until 6) {
      breakable {
        if (i % 2 == 0) break
        for (j <- 0 until 6) {
          breakable {
            if (j % 2 == 0) break
            println(s"Count: ${i}, ${j}")
          }
        }
      }
    }
  }
}
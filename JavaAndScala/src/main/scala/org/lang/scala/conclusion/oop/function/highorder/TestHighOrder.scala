package org.lang.scala.conclusion.oop.function.highorder

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test high-order function
 * 	-- A function that has function parameters (namely takes function as arguments) or returns a function
 * 		
 * 	High-order function can be used to:
 * 	-- Demonstrate scope and closure
 *  -- Achieve the same functionality as method currying
 *  -- etc.
 *  
 * 	@author VinceYuan
 */
object TestHighOrder {
  
  /*	Necessary instance variables	*/
  private val highOrderFunc1 = (x: Int) => (y: Float) => (z: Double) => x + y + z
  private val highOrderFunc2 = {
    (x: Int) => {
      (y: Float) => {
        (z: Double) => {
          x + y + z
        }
      }
    }
  }
  private val highOrderFunc3 = {
    (x: Int) => {
      val a = x
      (y: Float) => {
        val b = y
        (z: Double) => {
          val c = z
          a + b + c
        }
      }
    }
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testHighOrderFunction()
  }
  
  /**
   * 	This is a method to test high-order function
   */
  private def testHighOrderFunction(): Unit = {
    
    println(highOrderFunc1)
    println(ReflectionUtils.getRuntimeType(highOrderFunc1))
    println(highOrderFunc2)
    println(ReflectionUtils.getRuntimeType(highOrderFunc2))
    println(highOrderFunc3)
    println(ReflectionUtils.getRuntimeType(highOrderFunc3))
    println(highOrderFunc1(1))
    println(ReflectionUtils.getRuntimeType(highOrderFunc1(1)))
    println(highOrderFunc1(1)(3.5f))
    println(ReflectionUtils.getRuntimeType(highOrderFunc1(1)(3.5f)))
    println(highOrderFunc1(1)(3.5f)(7.5))
    println(ReflectionUtils.getRuntimeType(highOrderFunc1(1)(3.5f)(7.5))) 
  }
}
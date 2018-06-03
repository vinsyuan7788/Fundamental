package org.lang.scala.conclusion.oop.method.curry

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test currying
 *  -- When a method is called with a fewer number of parameter lists, then this will yield a function taking the missing parameter lists as its arguments
 *     -- Hence currying in Scala refers to method currying
 *  
 *  Currying, in practice, allows to pass the arguments in separate steps instead of passing them together once
 *  -- E.g., passing implicit values (or implicit conversion) to a function or method before actually invoking it 
 * 
 * 	@author VinceYuan
 */
object TestCurrying {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCurrying()
  }
  
  /**
   * 	This is a method to test method currying
   */
  private def testCurrying(): Unit = {
    
    /*	Method currying basics	*/
    println("Here demonstrates method currying basics:")
    val func1 = curryingMethod1 _ 
    val func2 = curryingMethod1(1) _
    val func3 = curryingMethod1(1)(2) _
    /*
     * 	Here underscore "_" is a no-argument placeholder
     *  -- Usable only when there is only ONE argument actually needed
     *  -- More details refer to "functional/TestFunction.scala"
     */
    val func4 = curryingMethod1(1)(2)(_)   
    val result = curryingMethod1(1)(2)(3)
    println(func1)
    println(ReflectionUtils.getRuntimeType(func1))
    println(func2)
    println(ReflectionUtils.getRuntimeType(func2))
    println(func3)
    println(ReflectionUtils.getRuntimeType(func3))
    println(func4)
    println(ReflectionUtils.getRuntimeType(func4))
    println(result)
    println(ReflectionUtils.getRuntimeType(result))
    
    /*	Test if currying methods and high-order functions can achieve the same mechanism	 */
    println("\nHere demonstrates currying methods and high-order functions can achieve the same mechanism:")
    println(curryingMethod1 _  + ": " + ReflectionUtils.getRuntimeType(curryingMethod1 _))
    println(method1_returnsHighOrderFunc _  + ": " + ReflectionUtils.getRuntimeType(method1_returnsHighOrderFunc _))
    println(highOrderFunc1 + ": " + ReflectionUtils.getRuntimeType(highOrderFunc1))
    println(highOrderFunc2 + ": " + ReflectionUtils.getRuntimeType(highOrderFunc2))
    
    /*	Method currying application case	 */
    println("\nHere demonstrates method currying application case:")
    val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(filter(nums, modN(2)))
    println(filter(nums, modN(3)))
  }
  
  /**
   * 	Here are the methods regarding currying
   */
  def curryingMethod1(x: Int)(y: Long)(z: Float): Double = {
    x + y + z
  }
  def modN(n: Int)(x: Int) = ((x % n) == 0)
  def filter(xs: List[Int], p: Int => Boolean): List[Int] = {
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p) 
  }
  
  /**
   * 	Here are the high-order functions and methods that return high-order functions that achieve the same functionality as currying
   *  -- But they are NOT currying
   */
  val highOrderFunc1 = (x: Int) => {
    (y: Long) => {
      (z: Float) => {
        x + y + z
      }
    }
  }
  val highOrderFunc2: Int => (Long => (Float => Double)) = x => {
    y => {
      z => {
        x + y + z
      }
    }
  }
  def method1_returnsHighOrderFunc(x: Int) = {
    (y: Long) => {
      val a = 10
      (z: Float) => {
        x + y + z + a
      }
    }
  }
}
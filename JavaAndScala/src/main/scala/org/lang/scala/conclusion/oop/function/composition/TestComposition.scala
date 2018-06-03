package org.lang.scala.conclusion.oop.function.composition

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test function composition
 *  -- "compose" ONLY works on <function1>
 *  -- "andThen" ONLY works on <function1>
 * 
 * 	@author VinceYuan
 */
object TestComposition {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFunctionComposition()
  }
  
  /**
   * 	This is a method to test function composition
   */
  private def testFunctionComposition(): Unit = {
    
    /*	Given some <function1> functions	*/
    val func1 = method1 _
    val func2 = method2 _
    val func3 = (x: Int) => (x + 100)
    val func4: Int => Int = {
      x => x * 100
    }
    println(func1 + " is a " + ReflectionUtils.getRuntimeType(func1))
    println(func2 + " is a " + ReflectionUtils.getRuntimeType(func2))
    println(func3 + " is a " + ReflectionUtils.getRuntimeType(func3))
    println(func4 + " is a " + ReflectionUtils.getRuntimeType(func4))
    
    /*	Composite functions	 */
    val funcComp1 = func1 compose func2
    val funcAntn1 = func1 andThen func2
    val funcComp2 = func3 compose func4
    val funcAntn2 = func3 andThen func4
    println(funcComp1("x"))
    println(funcAntn1("x"))
    println(funcComp2(10))
    println(funcAntn2(10))
  }
  
  /**
   * 	Here are the methods to convert to functions
   */
  private def method1(s: String) = "func1(" + s + ")"
  private def method2(s: String) = "func2(" + s + ")"
}
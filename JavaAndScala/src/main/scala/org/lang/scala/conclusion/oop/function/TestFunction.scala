package org.lang.scala.conclusion.oop.function

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test function
 *  -- Function declaration: can use "val" or "def" keyword
 *     -- val <funcName>[: funcType] = [{] Unit or ([parameterName[: parameterType], ...]) => [{] funcBody [}] [}]
 *     
 *  Practically, when declaring a function, no need to specify function type explicitly unless simple or necessary
 *  -- Since some function type may be complex, e.g., high-order function
 *  
 *  Differences between method and functions:
 *  -- Method is not an object, function is an object
 *  -- Method can use generics, function cannot use generics
 *  -- Method can input varargs, function cannot input varargs
 *  -- Method can explicit have "return" keyword, function cannot have "return" keyword
 *  -- Method can be recursive, function cannot be recursive
 * 
 * 	@author VinceYuan
 */
object TestFunction {
  
  /*	Necessary instance variables	 */
  private type IntegerProcessing = (Int, Double) => Double
  private val list: List[Int] = List(1, 2, 3, 4, 5)
  private val addDouble = (x: Int, y: Double) => x + y
  private val substractDouble = (x: Int, y: Double) => {
    x - y
  }
  private val multiplyDouble: IntegerProcessing = {
    (x, y) => {
      x * y
    }
  }
  // Here uses an underscore "_" to EXPLICITLY convert a method to a function
  private val divideDouble = divideDbl _
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests function basics:")
    testFunctionBasics()
    println("\nHere tests function parameter:")
    println(testFunctionParameter(addDouble, 10))
    println(testFunctionParameter(substractDouble, 1))
    println(testFunctionParameter(multiplyDouble, 10))
    println(testFunctionParameter(divideDouble, 2))
    /*
     * 	Here the method "divideDble" is converted to a function IMPLICITLY
     *  -- Hence no need to use a underscore "_"
     */
    println(testFunctionParameter(divideDbl, 2))
    /*
     *  Here underscore "_" is a no-argument placeholder
     *  -- Namely "divideDbl(_, _)" means "divideDbl" method does not take any argument, which is the same as "divideDbl"
     *  -- Underscore "_" can be used only when the function or method actually needs only ONE argument on invocation
     *     -- E.g., in this case, the 2nd parameter of "divideDble" actually has an argument on invocation (i.e., "f(_, x)"), hence only ONE underscores actually represents no-argument
     *     -- More details refer to "functional/TestCurrying.scala"
     */
    println(testFunctionParameter(divideDbl(_, _), 2))
  }
  
  /**
   * 	This is a method to test function basics 
   */
  private def testFunctionBasics(): Unit = {
    val func1 = (x: String, y: String) => x.concat(y)
    println(func1)
    println(ReflectionUtils.getRuntimeType(func1))
    println("Execute function1: " + func1("Hello ", "Scala"))
    val func2 = (x: Int, y: Int) => {
      x + y
    }
    println(func2)
    println(ReflectionUtils.getRuntimeType(func2))
    println("Execute function2: " + func2(1, 2))
  }
  
  /**
   * 	This is a method to test function parameter
   */
  private def testFunctionParameter(f: IntegerProcessing, x: Double): List[Double] = {
    list.map(f(_, x))
  }
  
  /**
   * 	This is a method that will be converted to a function
   */
  private def divideDbl(x: Int, y: Double): Double = {
    x / y
  }
}
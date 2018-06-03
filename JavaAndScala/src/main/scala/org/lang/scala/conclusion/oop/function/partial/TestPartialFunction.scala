package org.lang.scala.conclusion.oop.function.partial

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test partial function
 *  -- Partial function is used to match the input and do the corresponding output
 *     -- It is an application case of pattern matching
 *        -- Details regarding pattern matching refers to "org/scala/conclusion/statement/matching" package
 *        
 *  Partial function can be used for (input) VALUE matching, NOT for type matching, since
 *  -- If several types are involves, then only "Any" can be used (for input type and return type)
 *  -- If generic types needs to be involved, then must be implemented through method
 *     -- Generics types are not supported on function
 *     -- Return type is still "Any" even input type can be generics through method
 *  Another way for value matching is pattern matching: refer to "matching" package
 * 
 * 	@author VinceYuan
 */
object TestPartialFunction {
  
  /*	Instance variables	*/
  private val partialFunc1: PartialFunction[Any, String] = {
    case "A" | "B" | "C" | "D" | "E" | "F" => "This is a string."
    case 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 => "This is a number."
  }
  private val partialFunc2 = (x: Any) => x match {
    case "A" | "B" | "C" | "D" | "E" | "F" => "This is a string."
    case 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 => "This is a number."
  }
  private val partialFunc3: PartialFunction[Any, Any] = {
    case x: Int => x
    case x: Short => x
    case x: Long => x
    case x: Float => x
    case x: Double => x
    case x: Boolean => x
    case x: Char => x
    case x: String => x
//    case x: Any => x
  }
  private val partialFunc4 = (x: Any) => x match {
    case x: Int => x
    case x: Short => x
    case x: Long => x
    case x: Float => x
    case x: Double => x
    case x: Boolean => x
    case x: Char => x
    case x: String => x
//    case x: Any => x
  }
  // Here cannot convert method to function since the method involves generics
//  private val partialFunc5 = patialMethod1 _
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testPartialFunction()
  }
  
  /**
   * 	This is a method to test partial function
   */
  private def testPartialFunction(): Unit = {
    
    println(partialFunc1("A"))
    println(partialFunc2("E"))
    println(partialFunc1(1))
    println(partialFunc2(5))
    
    val int = 1
    val short: Short = 1
    val long = 1l
    val float = 1f
    val double = 1d
    val bool = true
    val char = '1'
    val str = "1" 
    println(partialFunc3(int) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(int)))
    println(partialFunc4(int) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(int)))
    println(partialMethod1(int) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(int)))
    println(partialFunc3(short) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(short)))
    println(partialFunc4(short) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(short)))
    println(partialMethod1(short) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(short)))
    println(partialFunc3(long) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(long)))
    println(partialFunc4(long) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(long)))
    println(partialMethod1(long) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(long)))
    println(partialFunc3(float) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(float)))
    println(partialFunc4(float) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(float)))
    println(partialMethod1(float) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(float)))
    println(partialFunc3(double) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(double)))
    println(partialFunc4(double) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(double)))
    println(partialMethod1(double) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(double)))
    println(partialFunc3(bool) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(bool)))
    println(partialFunc4(bool) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(bool)))
    println(partialMethod1(bool) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(bool)))
    println(partialFunc3(char) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(char)))
    println(partialFunc4(char) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(char)))
    println(partialMethod1(char) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(char)))
    println(partialFunc3(str) + ": " + ReflectionUtils.getRuntimeType(partialFunc3(str)))
    println(partialFunc4(str) + ": " + ReflectionUtils.getRuntimeType(partialFunc4(str)))
    println(partialMethod1(str) + ": " + ReflectionUtils.getRuntimeType(partialMethod1(str)))
  }
  
  /**
   * 	Here are the methods that return partial functions with generics
   *  -- Return type MUST be "Any" even using generics in this case
   */
  private def partialMethod1[T] = (x: T) => x match {
    case x: Int => x
    case x: Short => x
    case x: Long => x
    case x: Float => x
    case x: Double => x
    case x: Boolean => x
    case x: Char => x
    case x: String => x
//    case x: Any => x
  }
//  private def partialMethod2[T]: PartialFunction[T, T] = {
//    val partialFunc: PartialFunction[T, T] = {
//      case x: Int => x
//      case x: Short => x
//      case x: Long => x
//      case x: Float => x
//      case x: Double => x
//      case x: Boolean => x
//      case x: Char => x
//      case x: String => x     
//    }
//    partialFunc
//  }
  private def partialMethod3[T](x: T): Any = {
    x match {
      case x: Int => x
      case x: Short => x
      case x: Long => x
      case x: Float => x
      case x: Double => x
      case x: Boolean => x
      case x: Char => x
      case x: String => x
//    case x: Any => x
    }
  }
  private def partialMethod4: PartialFunction[Any, Any] = {
    partialFunc3   
  }
}
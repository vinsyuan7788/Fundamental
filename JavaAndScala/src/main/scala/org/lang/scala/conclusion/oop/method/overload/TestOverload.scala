package org.lang.scala.conclusion.oop.method.overload

/**
 * 	This is a stand-alone object to test method overloading
 * 
 * 	@author VinceYuan
 */
object TestOverload {
  
  /*	Necessary instance variables	*/
  private val a = 1
  private val b = 2
  private val c = 3
  private val d = 4
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val sum1 = add(a, b)
    val sum2 = add(a, b, c)
    val sum3 = add(a, b, c, d)
    println(sum1)
    println(sum2)
    println(sum3)
  }
  
  /**
   * 	Here are the overloaded methods
   */
  private def add(a: Int, b: Int) = {
    a + b
  }
  private def add(a: Int, b: Int, c: Int) = {
    a + b + c
  }
  private def add(a: Int, b: Int, c: Int, d: Int) = {
    a + b + c + d
  }
}
package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common

/**
 * 	This is a stand-alone class to test "volatile" keyword
 * 
 * 	@author VinceYuan
 */
class NumberManager {
  
  /*	Necessary instance variables	*/
  @volatile private var number1 = 1
  @volatile private var number2 = 2
  
  /**
   * 	This is a method to change the numbers
   */
  def change() = {
    number1 = 3
    number2 = number1
  }
  
  /**
   * 	This is a method to print the numbers
   */
  def print() = {
    println(s"1st nubmer: ${number1}; 2nd number: ${number2}")
  }
}
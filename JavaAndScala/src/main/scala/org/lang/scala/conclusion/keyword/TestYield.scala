package org.lang.scala.conclusion.keyword

import scala.Vector

/**
 * 	This is a stand-alone object to test "yield" keyword
 *  -- Yield: process each element and generate a new corresponding data structure
 *  
 *  @author VinceYuan
 */
object TestYield {
  
  /*	Necessary instance variables	*/
  private val array: Array[Int] = Array(1, 2, 3, 4, 5)
  private val range: Range = 1.to(10)
  private val vector: Vector[String] = Vector("China", "USA", "Canada")
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testYield()
  }
  
  /**
   * 	This is a method to test "yield" keyword
   */
  private def testYield(): Unit = {
    
    val newArray = for (i <- array) yield i * 2
    println(newArray.toBuffer)

    val newRange = for (i <- range) yield i * 2
    println(newRange)
    
    val newVector = for (i <- vector) yield i * 2
    println(newVector)
  }
}
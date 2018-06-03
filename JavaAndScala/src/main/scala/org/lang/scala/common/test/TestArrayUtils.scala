package org.lang.scala.common.test

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone object to test ArrayUtils
 * 
 * 	@author VinceYuan
 */
object TestArrayUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testArrayUtils()
  }
  
  /**
   * 	This is a method to test ArrayUtils
   */
  private def testArrayUtils(): Unit = {
    
    val arr = Array(5, 1, 4, 2, 8)
    println(s"Original array:\n${arr.mkString(", ")}")
    
    ArrayUtils.swap(arr, 1, 3)
    println(s"Swapped array:\n${arr.mkString(", ")}")
    
    ArrayUtils.swap(arr, 1, 3, 1, 3)
    println(s"Swapped array:\n${arr.mkString(", ")}")
    
    ArrayUtils.insertLeft(arr, 2, 3)
    println(s"Left-inserted array:\n${arr.mkString(", ")}")
    
    ArrayUtils.insertLeft(arr, 2, 4, 4, 2)
    println(s"Left-inserted array:\n${arr.mkString(", ")}")
    
    ArrayUtils.insertRight(arr, 2, 4, 2, 2)
    println(s"Right-inserted array:\n${arr.mkString(", ")}")
    
    ArrayUtils.insertRight(arr, 4, 3)
    println(s"Right-inserted array:\n${arr.mkString(", ")}")
  }
}
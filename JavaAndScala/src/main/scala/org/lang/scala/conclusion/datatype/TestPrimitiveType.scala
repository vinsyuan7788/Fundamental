package org.lang.scala.conclusion.datatype

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test data types
 *  -- Allow block expression to assign values to variables
 * 
 * 	@author VinceYuan
 */
object TestPrimitiveType {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests primitive types:");
    testPrimitiveType()
  }
  
  /**
   * 	This is a method to test primitive type
   */
  private def testPrimitiveType(): Unit = {
    
    /*	Variable declaration and initialization	 */
    val i: Int = 0
    val j: Long = if (i > 0) 1l else -1l       // Block expression: equivalent to "i > 0 ? 1l : -1l" in Java
    val k: Float = if (i > 0) {                // Block expression: equivalent to "i > 0 ? 1f : -1f" in Java
      1.0f
    } else {
      -1.0f
    }
    val l: Double = {                          // Block expression: equivalent to "i > 0 ? 1.0 : -1.0" in Java
      if (i > 0) {
        1.0 
      } else {
        -1.0
      }
    }
    
    /*	Output information	*/
    println("if " + i + " is " + ReflectionUtils.getRuntimeType(i) + "-typed: " + i.isInstanceOf[Int])
    println("if " + j + " is " + ReflectionUtils.getRuntimeType(j) + "-typed: " + j.isInstanceOf[Long])
    println("if " + k + " is " + ReflectionUtils.getRuntimeType(k) + "-typed: " + k.isInstanceOf[Float])
    println("if " + l + " is " + ReflectionUtils.getRuntimeType(l) + "-typed: " + l.isInstanceOf[Double])
  }
}
package org.scala.conclusion.structure.addableonly

import scala.Vector
import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test vector
 * 
 * 	@author VinceYuan
 */
object TestVector {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testVector()
  }
  
  /**
   * 	This is a method to test Vector
   */
  private def testVector(): Unit = {
    
    /*	This is a vector to store vectors	 */
    var vector: Vector[Any] = Vector()
    
    /*	Initialize two vectors	 */
    val vector1 = for (i <- 1 to 10) yield i * 10
    vector = vector :+ vector1
    val vector2 = Vector("China", "Korea", "India")
    vector = vector :+ vector2
    
    /*	Output information	*/
    println("If " + vector(0) + " and " + vector(1) + " are the same: " + vector(0).equals(vector(1)))
    println("vector(0) data type is: " + ReflectionUtils.getRuntimeType(vector(0)))
    println("vector1 data type is: " + ReflectionUtils.getRuntimeType(vector1))
    println("vector(1) data type is: " + ReflectionUtils.getRuntimeType(vector(1)))
    println("vector2 data type is: " + ReflectionUtils.getRuntimeType(vector2))
    println("If vector1 is int-vector: " + vector1.isInstanceOf[Vector[Int]])
    println("If vector2 is string-vector: " + vector2.isInstanceOf[Vector[String]])
    
    /*	Traverse a vector using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a vector using for loop:")
    for (i <- vector1) {
      if (i > vector1(0)) stringBuilder.append(", ")
      stringBuilder.append(i)
    }
    println(stringBuilder)
    
    /*	Traverse a vector using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse a vector using functional operation:")
    vector2.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
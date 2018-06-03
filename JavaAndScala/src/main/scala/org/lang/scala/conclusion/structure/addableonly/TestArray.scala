package org.scala.conclusion.structure.addableonly

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * 	This is a stand-alone object to test array
 *  -- Array is fixed-length
 *  -- Array is mutable
 *  
 * 	@author VinceYuan
 */
object TestArray {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here demonstrates Array basics:")
    testArray()
    println("\nHere demonstrates other Array methods:")
    testOtherMethods()
    println("\nHere demonstrates multi-dimensional Array:")
    testMultiDimensionArray()
  }
  
  /**
   * 	This is a method to test Array
   */
  private def testArray(): Unit = {
    
    /*	This is an array to store arrays	*/
    var array: Array[Any] = Array()
    
    /*	Initialize two arrays	 */
    val array1 = new Array[String](5)
    array1(0) = "China"
    array1(1) = "Korea"
    array1(2) = "Chili"
    array1(3) = "India"
    array1(4) = "Yemen"
    array = array :+ array1
    val array2 = Array(3, 5, 7,  2, 3)
    array = array :+ array2

    /*	Output information	*/
    println("If " + array(0).asInstanceOf[Array[String]].toBuffer + " and "  + array(1).asInstanceOf[Array[Int]].toBuffer + " are the same: " + array(0).equals(array(1)))
    println("array(0) data type is: " + ReflectionUtils.getRuntimeType(array(0)))
    println("array1 data type is: " + ReflectionUtils.getRuntimeType(array1))
    println("array(1) data type is: " + ReflectionUtils.getRuntimeType(array(1)))
    println("array2 data type is: " + ReflectionUtils.getRuntimeType(array2))
    println("If array1 is string-array: " + array1.isInstanceOf[Array[String]])
    println("If array2 is int-array: " + array2.isInstanceOf[Array[Int]])
    
    /*	Traverse an array using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse an array using for loop:")
    for (i <- 0 until array1.size) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(array1(i))
    }
    println(stringBuilder)
    
    /*	Traverse an array using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse an array using functional operation:")
    array1.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
  
  /**
   * 	This is a method to test other Array methods
   */
  private def testOtherMethods(): Unit = {
    
    val arr = Array(2, 4, 5, 1, 3)
    val randElem = arr(Random.nextInt(arr.length))
    val elemIdx = arr.indexOf(randElem)
    println("The index of " + randElem + " is: " + elemIdx)
    val nonExistElemIdx = arr.indexOf(6)
    println("The index of non-existing element: " + nonExistElemIdx)    // -1
  }
  
  /**
   * 	This is a method to test multi-dimensional array
   */
  private def testMultiDimensionArray(): Unit = {
    
    val arr1 = Array(1, 2, 3, 4, 5)
    val arr2 = Array("a", "b", "c", "d")
    val arr3 = Array(arr1.toBuffer, arr2.toBuffer)
    println(ReflectionUtils.getRuntimeType(arr3))
    println("If arr3 is an array: " + arr3.isInstanceOf[Array[Any]])
    println(arr3.toBuffer)
  }
}
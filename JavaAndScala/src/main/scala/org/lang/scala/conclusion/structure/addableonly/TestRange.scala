package org.scala.conclusion.structure.addableonly

import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test range
 *  -- Range: a series of consecutive numbers
 * 
 * 	@author VinceYuan
 */
object TestRange {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testRange()
  }
  
  /**
   * 	This is a method to test Range
   */
  private def testRange(): Unit = {
    
    /*	This is a list to store ranges	*/
    var rangeList: List[Any] = List()
    
    /*	Initialize two ranges	 */
    val range1 = 1 to 10
    rangeList = range1 :: rangeList
    val range2 = 1.until(10)
    rangeList = rangeList :+ range2

    /*	Output information	*/
    println("If " + rangeList(0) + " and " + rangeList(1) + " are the same: " + rangeList(0).equals(rangeList(1)))
    println("rangeList(0) data type is: " + ReflectionUtils.getRuntimeType(rangeList(0)))
    println("Range1 data type is: " + ReflectionUtils.getRuntimeType(range1))
    println("rangeList(1) data type is: " + ReflectionUtils.getRuntimeType(rangeList(1)))
    println("Range2 data type is: " + ReflectionUtils.getRuntimeType(range2))
    println("If range1 is range-typed: " + range1.isInstanceOf[Range])
    println("If range2 is range-typed: " + range2.isInstanceOf[Range])
    
    /*	Traverse a range using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a range using for loop:")
    for (i <- range1) {
      if (i > range1(0)) stringBuilder.append(", ")
      stringBuilder.append(i)
    }
    println(stringBuilder)
    
    /*	Traverse a range reversely using for loop	 */
    stringBuilder.clear();
    println("\nNow traverse a range reversely using for loop:")
    for (i <- range1.reverse) {
      if (i < range1.reverse(0)) stringBuilder.append(", ")
      stringBuilder.append(i)
    }
    println(stringBuilder)
    
    /*	Traverse a range using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse a range using functional operation:")
    range1.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
package org.scala.conclusion.structure.addableremovable

import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test Set
 *  -- Set is immutable
 *     -- This can ensure thread-security
 *  
 *	@author VinceYuan
 */
object TestSet {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testList()
  }
  
  /**
   * 	This is a method to test S
   */
  private def testList(): Unit = {
    
    /*	This is a set to store sets	 */
    var setList: List[Any] = List()
    
    /*	Initialize two ranges	 */
    var set1 = Set[Int]()
    set1 = set1 + 1
    set1 = set1 ++ List(2, 3, 4, 5)
    set1 = set1 ++ Array(6, 7, 8, 9)
    setList = set1 :: setList
    var set2 = Set[String]("USA", "KOR")
    set2 = set2 + "JPN"
    set2 = set2 ++ List("CHN", "BRA")
    setList = setList :+ set2
    
    /*	Output information	*/
    println("If " + setList(0) + " and " + setList(1) + " are the same: " + setList(0).equals(setList(1)))
    println("setList(0) data type is: " + ReflectionUtils.getRuntimeType(setList(0)))
    println("set1 data type is: " + ReflectionUtils.getRuntimeType(set1))
    println("setList(1) data type is: " + ReflectionUtils.getRuntimeType(setList(1)))
    println("set2 data type is: " + ReflectionUtils.getRuntimeType(set2))
    println("If set1 is int-set: " + set1.isInstanceOf[Set[Int]])
    println("If set2 is string-set: " + set2.isInstanceOf[Set[String]])
    
    /*	Traverse a set using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a set using for loop:")
    var i = 0
    for (element <- set1) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(element)
      i += 1
    }
    println(stringBuilder)
    
    /*	Traverse a set using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse a set using functional operation:")
    set2.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
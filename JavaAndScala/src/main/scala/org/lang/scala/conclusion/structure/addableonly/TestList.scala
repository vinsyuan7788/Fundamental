package org.scala.conclusion.structure.addableonly

import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test List
 *  -- List is immutable
 *     -- This can ensure thread-security
 *  
 *	@author VinceYuan
 */
object TestList { 
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testList()
  }
  
  /**
   * 	This is a method to test List
   */
  private def testList(): Unit = {
    
    /*	This is a list to store lists	 */
    var list: List[Any] = List()
    
    /*	Initialize two ranges	 */
    var list1 = List[Int]()
    list1 = list1 :+ 1
    list1 = list1 ++ List(2, 3, 4, 5)
    list1 = list1 ++ Array(6, 7, 8, 9)
    list = list :+ list1
    var list2 = List[String]("USA", "KOR")
    list2 = "JPN" :: list2
    list2 = List("CHN", "BRA") ::: list2
    list = list :+ list2
    
    /*	Output information	*/
    println("If " + list(0) + " and " + list(1) + " are the same: " + list(0).equals(list(1)))
    println("list(0) data type is: " + ReflectionUtils.getRuntimeType(list(0)))
    println("list1 data type is: " + ReflectionUtils.getRuntimeType(list1))
    println("list(1) data type is: " + ReflectionUtils.getRuntimeType(list(1)))
    println("list2 data type is: " + ReflectionUtils.getRuntimeType(list2))
    println("If list1 is int-list: " + list1.isInstanceOf[List[Int]])
    println("If list2 is string-list: " + list2.isInstanceOf[List[String]])
    
    /*	Traverse a list using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a list using for loop:")
    for (i <- 0 until list1.size) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(list1(i))
    }
    println(stringBuilder)
    
    /*	Traverse a list using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse a list using functional operation:")
    list2.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
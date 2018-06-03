package org.lang.scala.common.test

import org.lang.scala.common.utils.SearchUtils

/**
 * 	This is a stand-alone object to test SearchUtils
 * 
 * 	@author VinceYuan
 */
object TestSearchUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSearchUtils()
  }
  
  /**
   * 	This is a method to test SearchUtils
   */
  private def testSearchUtils(): Unit = {

    var arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    var elem = 6
    var index = SearchUtils.depthFirstSearch(arr, elem)
    println(s"Using depth first search:\nThe index of ${elem} in [${arr.mkString(", ")}]:\n${index}")

    arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    elem = 6
    index = SearchUtils.depthFirstSearch(arr, 0, 3, elem)
    println(s"Using depth first search:\nThe index of ${elem} in the first 4 elements of [${arr.mkString(", ")}]:\n${index}")

    arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    elem = 6
    index = SearchUtils.depthFirstSearch(arr, 4, arr.length - 1, elem)
    println(s"Using depth first search:\nThe index of ${elem} in the last 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(5, 1, 8, 4, 6, 7, 9, 2)   
    elem = 6
    index = SearchUtils.breadthFirstSearch(arr, elem)
    println(s"\nUsing breadth first search:\nThe index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(5, 1, 8, 4, 6, 7, 9, 2)   
    elem = 6
    index = SearchUtils.breadthFirstSearch(arr, 0, 3, elem)
    println(s"Using breadth first search:\nThe index of ${elem} in the first 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(5, 1, 8, 4, 6, 7, 9, 2)   
    elem = 6
    index = SearchUtils.breadthFirstSearch(arr, 4, arr.length - 1, elem)
    println(s"Using breadth first search:\nThe index of ${elem} in the last 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(1, 3, 4, 5, 7, 8, 9)   
    elem = 8
    index = SearchUtils.binarySearch(arr, true, elem)
    println(s"\nUsing binary search:\nThe index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
 
    arr = Array(1, 3, 4, 5, 7, 8, 9)   
    elem = 8
    index = SearchUtils.binarySearch(arr, true, 0, 3, elem)
    println(s"Using binary search:\nThe index of ${elem} in the first 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(1, 3, 4, 5, 7, 8, 9)   
    elem = 8
    index = SearchUtils.binarySearch(arr, true, 3, arr.length - 1, elem)
    println(s"Using binary search:\nThe index of ${elem} in the last 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(9, 8, 7, 5, 4, 3, 1)   
    elem = 8
    index = SearchUtils.binarySearch(arr, false, elem)
    println(s"Using binary search:\nThe index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(9, 8, 7, 5, 4, 3, 1)   
    elem = 8
    index = SearchUtils.binarySearch(arr, false, 0, 3, elem)
    println(s"Using binary search:\nThe index of ${elem} in the first 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(9, 8, 7, 5, 4, 3, 1)   
    elem = 8
    index = SearchUtils.binarySearch(arr, false, 3, arr.length - 1, elem)
    println(s"Using binary search:\nThe index of ${elem} in the last 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(5, 1, 4, 6, 8, 3, 2, 9)
    elem = 8
    index = SearchUtils.linearSearch(arr, elem)
    println(s"\nUsing linear search:\nThe index of ${elem} in [${arr.mkString(", ")}]:\n${index}")

    arr = Array(5, 1, 4, 6, 8, 3, 2, 9)
    elem = 8
    index = SearchUtils.linearSearch(arr, 0, 3, elem)
    println(s"Using linear search:\nThe index of ${elem} in the first 4 elements of [${arr.mkString(", ")}]:\n${index}")
    
    arr = Array(5, 1, 4, 6, 8, 3, 2, 9)
    elem = 8
    index = SearchUtils.linearSearch(arr, 4, arr.length - 1, elem)
    println(s"Using linear search:\nThe index of ${elem} in the last 4 elements of [${arr.mkString(", ")}]:\n${index}")
  }
}
package org.lang.scala.common.test

import org.lang.scala.common.utils.SortUtils

/**
 * 	This is a stand-alone object to test SortUtils
 * 
 * 	@author VinceYuan
 */
object TestSortUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSortUtils()
  }
  
  /**
   * 	This is a method to test SortUtils
   */
  private def testSortUtils(): Unit = {
    
    val arr = Array(5, 1, 4, 2, 8)
    println(s"Original array:\n${arr.mkString(", ")}")
    
    SortUtils.quickSortAsc(arr)
    println(s"Quick sorted array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.quickSortDesc(arr)
    println(s"Quick sorted array in descending order:\n${arr.mkString(", ")}")
    
    SortUtils.quickSortAsc(arr, 1, arr.length - 1)    // Sort the last 4 elements
    println(s"Quick sorted last 4 elements in the array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.quickSortDesc(arr, 1, arr.length - 1)   // Sort the last 4 elements
    println(s"Quick sorted last 4 elements in the array in descending order:\n${arr.mkString(", ")}")
    
    SortUtils.mergeSortAsc(arr)
    println(s"Merge sorted array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.mergeSortDesc(arr)
    println(s"Merge sorted array in descending order:\n${arr.mkString(", ")}")
    
    SortUtils.mergeSortAsc(arr, 1, arr.length - 1)    // Sort the last 4 elements
    println(s"Merge sorted last 4 elements in the array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.mergeSortDesc(arr, 1, arr.length - 1)   // Sort the last 4 elements
    println(s"Merge sorted last 4 elements in the array in descending order:\n${arr.mkString(", ")}")
    
    SortUtils.heapSortAsc(arr)
    println(s"Heap sorted array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.heapSortDesc(arr)
    println(s"Heap sorted array in descending order:\n${arr.mkString(", ")}")
    
    SortUtils.heapSortAsc(arr, 1, arr.length - 1)     // Sort the last 4 elements
    println(s"Heap sorted last 4 elements in the array in ascending order:\n${arr.mkString(", ")}")
    
    SortUtils.heapSortDesc(arr, 1, arr.length - 1)    // Sort the last 4 elements
    println(s"Heap sorted last 4 elements in the array in descending order:\n${arr.mkString(", ")}")
  }
}
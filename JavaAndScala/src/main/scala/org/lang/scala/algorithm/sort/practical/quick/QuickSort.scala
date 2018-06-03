package org.lang.scala.algorithm.sort.practical.quick

import org.lang.scala.common.utils.ArrayUtils
import org.lang.scala.common.utils.SortUtils

/**
 * 	This is a stand-alone object to implement quick sort
 * 	-- Time complexity: O(n log n) or O(n) for best and O(n^2) for the worst 
 * 	-- This algorithm is unstable sort algorithm
 *  -- Can be optimized by picking pivot randomly or median of three
 *  -- What is more important is "keep track of index" idea for array elements
 * 
 * 	@author VinceYuan
 */
object QuickSort {
      
  /**
   * 	This is a stand-alone object to implement quick sort
   */
  private def quickSortWithHoarePartition(arr: Array[Int]): Array[Int] = {
 
    /*	Sort the array	*/
    sortRecursively(arr, 0, arr.length - 1) 
    
    /****************************	Core in quick sort	*************************************/
    /*	Define an internal method to implement quick sort recursively in ascending order	*/
    def sortRecursively(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      
      /*	Implement quick sort to the array	 */
      if (startIdx < endIdx) {
        val pivotIdx = hoarePartition(arr, startIdx, endIdx)
        sortRecursively(arr, startIdx, pivotIdx - 1)
        sortRecursively(arr, pivotIdx + 1, endIdx)
      }
    }
    
    /*	Partition the array into 2 part: one with elements larger than pivot and one with smaller	*/
    def hoarePartition(arr: Array[Int], startIdx: Int, endIdx: Int): Int= {
      val pivot = arr(startIdx)
      var leftIdx = startIdx
      var rightIdx = endIdx
      while (leftIdx < rightIdx) {
        while (arr(rightIdx) >= pivot && leftIdx < rightIdx) rightIdx -= 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
        while (arr(leftIdx) <= pivot && leftIdx < rightIdx) leftIdx += 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
      }
      val pivotIdx = leftIdx
      pivotIdx
    }
    /**************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a stand-alone object to implement quick sort
   */
  private def quickSortWithLomutoPartition(arr: Array[Int]): Array[Int] = {

    /*	Sort the array  */
    sortRecursively(arr, 0, arr.length - 1) 
    
    /****************************	Core in quick sort	*************************************/
    /*	Define an internal method to implement quick sort recursively in ascending order	*/
    def sortRecursively(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      
      /*	Implement quick sort to the array	 */
      if (startIdx < endIdx) {
        val pivotIdx = lomutoPartition(arr, startIdx, endIdx)
        sortRecursively(arr, startIdx, pivotIdx - 1)
        sortRecursively(arr, pivotIdx + 1, endIdx)
      }
    }
    
    /*	Partition the array into 2 part: one with elements larger than pivot and one with smaller	*/
    def lomutoPartition(arr: Array[Int], startIdx: Int, endIdx: Int): Int = {      
      val pivot = arr(endIdx)
      var pivotIdx = startIdx
      for (i <- startIdx until endIdx) {
        if (arr(i) <= pivot) {
          if (i != pivotIdx) ArrayUtils.swap(arr, i, pivotIdx)
          pivotIdx = pivotIdx + 1
        }
      }
      ArrayUtils.swap(arr, pivotIdx, endIdx)
      pivotIdx
    }
    /**************************************************************************************/

    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(5, 1, 4, 2, 8)
    println(s"Original Array:\n${arr.mkString(", ")}")
    
    var startTime: Long = 0
    var elapsedTime: Long = 0
    
    startTime = System.currentTimeMillis()
    val sortedArrWithHoare= quickSortWithHoarePartition(arr)
    elapsedTime = System.currentTimeMillis() - startTime
    println(s"Sorted Array with quick sort with Hoare partition:\n${sortedArrWithHoare.mkString(", ")}; elapsed time: ${elapsedTime} ms")
    
    startTime = System.currentTimeMillis()
    val sortedArrWithLomuto = quickSortWithLomutoPartition(arr)
    elapsedTime = System.currentTimeMillis() - startTime
    println(s"Sorted Array with quick sort with Lomuto partition:\n${sortedArrWithLomuto.mkString(", ")}; elapsed time: ${elapsedTime} ms")
    
    SortUtils.quickSortDesc(arr)
    println(s"Sorted array with quick sort with Hoare partition:\n${arr.mkString(", ")}")
  }
}
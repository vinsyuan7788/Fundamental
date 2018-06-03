package org.lang.scala.algorithm.sort.useless.bubble

import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone object to implement bubble sort
 *  -- Time complexity: O(n) for best and O(n^2) for worst
 *  -- Can be either stable or unstable: up to the predication (or predicate condition)
 *  -- What is more important is "swap" idea for array elements
 * 
 * 	@author VinceYuan
 */
object BubbleSort {
  
  /**
   * 	This is a method to implement bubble sort in ascending order
   */
  private def bubbleSortAsc(arr: Array[Int]): Array[Int] = {
    
    /*	Get the length of the array	 */
    val arrLen = arr.length
    
    /***************************	Core in bubble sort algorithm	****************************/
    /*	Implement bubble sort for the array	 */
    breakable {
      for (i <- 0 until arrLen) {
        var sorted = true
        var maxIdxToSort = arrLen
        for (j <- 1 until maxIdxToSort) {
          if (arr(j - 1) > arr(j)) {        // Sort in ascending order     
            ArrayUtils.swap(arr, j - 1, j)
            maxIdxToSort = j
            sorted = false
          }
        }
        if (sorted) break
      }
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a method to implement bubble sort in descending order
   */
  private def bubbleSortDesc(arr: Array[Int]): Array[Int] = {
    
    /*	Get the length of the array	 */
    val arrLen = arr.length
    var maxIdxToSort = arrLen
    
    /***************************	Core in bubble sort algorithm	****************************/
    /*	Implement bubble sort for the array	 */
    breakable {
      for (i <- 0 until arrLen) {
        var sorted = true   
        for (j <- 1 until maxIdxToSort) {
          if (arr(j - 1) < arr(j)) {        // Sort in descending order
            ArrayUtils.swap(arr, j - 1, j)
            maxIdxToSort = j
            sorted = false
          }
        }
        if (sorted) break
      }
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(5, 1, 4, 2, 8)
    println(s"Original Array:\n${arr.mkString(", ")}")
    
    /*
     * 	Bubble sort algorithm works like this:
     *  -- Initially: (5)(1)(4)(2)(8)
     * 	-- 1st round (i = 0, j = 0): (5)(1)(4)(2)(8), maxIdxToSort=5, sorted=true
     *               (i = 0, j = 1): [1][5](4)(2)(8), maxIdxToSort=1, sorted=false
     *               (i = 0, j = 2): (1)[4][5](2)(8), maxIdxToSort=2, sorted=false
     *               (i = 0, j = 3): (1)(4)[2][5](8), maxIdxToSort=3, sorted=false
     *               (i = 0, j = 4): (1)(4)(2)[5][8]
     *               not break
     *  -- 2nd round (i = 1, j = 0): (1)(4)(2)(5)(8), maxIdxToSort=3, sorted=true
     *               (i = 1, j = 1): [1][4](2)(5)(8) 
     *               (i = 1, j = 2): (1)[2][4](5)(8), maxIdxToSort=2, sorted=false
     *               not break
     *  -- 3rd round (i = 2, j = 0): (1)(2)(4)(5)(8), maxIdxToSort=2, sorted=true
     *               (i = 2, j = 1): [1][2](4)(5)(8)
     *               break
     *  -- Finally: (1)(2)(4)(5)(8)
     */
    val sortedArrAsc = bubbleSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = bubbleSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
package org.lang.scala.algorithm.sort.useless.insertion.shell

import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

/**
 * 	This is a stand-alone object to implement shell sort
 * 	-- Time complexity: O(n log n) for best and O(n(log n)^2) for the worst
 *     -- It is up to how the gap is determined
 *     -- Since it has (log n), it means if the data size is small, it will have a better performance, while otherwise if the data size is large 
 * 	-- This algorithm is unstable sort algorithm
 *  -- What is more important is "gap" idea for array elements
 * 
 * 	@author VinceYuan
 */
object ShellSort {
  
  /**
   * 	This is a method to implement shell sort in ascending order
   */
  private def shellSortAsc(arr: Array[Int]): Array[Int] = {
  
    /*	Get the length of the array	 */
    val arrLen = arr.length
    
    /***************************	Core in shell sort algorithm	****************************/
    /*	Implement shell sort for the array	*/
    var gap = arrLen / 2
    while (gap > 0) {
      for (i <- gap until arrLen) {
        if (arr(i - gap) > arr(i)) {
          val temp = arr(i)
          var k = i
          breakable {
            for (j <- (i - gap) to 0 by -gap) {
              if (arr(j) > temp) {
                arr(j + gap) = arr(j)
                k = j
              } else {
                break
              }
            }
          }
          arr(k) = temp 
        }
      }
      gap = gap / 2
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
    /**
   * 	This is a method to implement shell sort in descending order
   */
  private def shellSortDesc(arr: Array[Int]): Array[Int] = {
  
    /*	Get the length of the array	 */
    val arrLen = arr.length
    
    /***************************	Core in shell sort algorithm	****************************/
    /*	Implement shell sort for the array	*/
    var gap = arrLen / 2
    while (gap > 0) {
      for (i <- gap until arrLen) {
        if (arr(i - gap) < arr(i)) {
          val temp = arr(i)
          var k = i
          breakable {
            for (j <- (i - gap) to 0 by -gap) {
              if (arr(j) < temp) {
                arr(j + gap) = arr(j)
                k = j
              } else {
                break
              }
            }
          }
          arr(k) = temp 
        }
      }
      gap = gap / 2
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
    
    val sortedArrAsc = shellSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = shellSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
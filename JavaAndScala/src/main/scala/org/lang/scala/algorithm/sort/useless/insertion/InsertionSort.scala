package org.lang.scala.algorithm.sort.useless.insertion

import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

/**
 * 	This is a stand-alone object to implement insertion sort
 * 	-- Time complexity: O(n) for best and O(n^2) for worst
 * 	-- Can be either stable or unstable: up to the predication (or predicate condition)
 *  -- What is more important is "swap" idea for array elements
 * 
 * 	@author VinceYuan
 */
object InsertionSort {
  
  /**
   * 	This is a method to implement insertion sort in ascending order
   */
  private def insertionSortAsc(arr: Array[Int]): Array[Int] = {
    
    /*	Get the length of the array	*/
    val arrLen = arr.length
    
    /**************************	Core in insertion sort algorithm	**************************/
    /*	Implement insertion sort for the array	*/
    for (i <- 1 until arrLen) {               // If the left element is LARGER than right element
      if (arr(i - 1) > arr(i)) {
        val rightMostElem = arr(i)
        var indexToInsert = i
        breakable {
          for (j <- (i - 1) to 0 by -1) {
            if (arr(j) > rightMostElem) {     // If there are elements LARGER than rightMostElem
              arr(j + 1) = arr(j)
              indexToInsert = j
            } else {
              break
            }
          } 
        }
        arr(indexToInsert) = rightMostElem
      }
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a method to implement insertion sort in descending order
   */
  private def insertionSortDesc(arr: Array[Int]): Array[Int] = {
    
    /*	Get the length of the array	*/
    val arrLen = arr.length

    /**************************	Core in insertion sort algorithm	**************************/
    /*	Implement insertion sort for the array	*/
    for (i <- 1 until arrLen) {
      if (arr(i - 1) < arr(i)) {              // If the left element is SMALLER than right element
        val rightMostElem = arr(i)
        var indexToInsert = i
        breakable {
          for (j <- (i - 1) to 0 by -1) {
            if (arr(j) < rightMostElem) {     // If there are elements SMALLER than rightMostElem
              arr(j + 1) = arr(j)
              indexToInsert = j
            } else {
              break
            }
          } 
        }
        arr(indexToInsert) = rightMostElem
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
     * 	Insertion sort algorithm works like this:
     *  -- Initially: (5)(1)(4)(2)(8)
     *  -- 1st round (i = 1, j = 0): (5)(1)(4)(2)(8), rightMostElem=1, indexToInsert=1
     *               (i = 1, j = 0): [1][5](4)(2)(8), rightMostElem=1, indexToInsert=0
     *  -- 2nd round (i = 2, j = 0): (1)(5)(4)(2)(8), rightMostElem=4, indexToInsert=2
     *               (i = 2, j = 1): (1)[4][5](2)(8), rightMostElem=4, indexToInsert=1
     *               (i = 2, j = 0): [1][4](5)(2)(8), break
     *  -- 3rd round (i = 3, j = 0): (1)(4)(5)(2)(8), rightMostElem=2, indexToInsert=3
     *               (i = 3, j = 2): (1)(4)[2][5](8), rightMostElem=2, indexToInsert=2
     *               (i = 3, j = 1): (1)[2][4](5)(8), rightMostElem=2, indexToInsert=1
     *               (i = 4, j = 0): [1][2](4)(5)(8), break
     *  -- 4th round (i = 4, j = 0): (1)(2)(4)(5)(8), rightMostElem=8, indexToInsert=4
     *               (i = 4, j = 3): (1)(4)(2)[5][8], break
     *  -- Finally: (1)(2)(4)(5)(8)
     */
    val sortedArrAsc = insertionSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = insertionSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
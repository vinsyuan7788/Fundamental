package org.lang.scala.algorithm.sort.useless.selection

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone object to implement selection sort
 *  -- Time complexity: O(n^2)
 *  -- Can be either stable or unstable: up to the predication (or predicate condition)
 * 
 * 	@author VinceYuan
 */
object SelectionSort {
  
  /**
   * 	This is a method to implement selection sort in ascending order
   */
  private def selectionSortAsc(arr: Array[Int]): Array[Int] = {
  
    /*	Get the length of the array	 */
    val arrLen = arr.length
    
    /**************************	Core in selection sort algorithm	**************************/
    /*	Implement selection sort for the array	*/
    for (i <- 0 until arrLen) {
      var idxOfMinElem = i
      for (j <- i until arrLen) {
        if (arr(idxOfMinElem) > arr(j)) {        // Find the index of minimum element
          idxOfMinElem = j
        }
      }
      if (idxOfMinElem != i) ArrayUtils.swap(arr, idxOfMinElem, i)
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a method to implement selection sort in descending order
   */
  private def selectionSortDesc(arr: Array[Int]): Array[Int] = {
  
    /*	Get the length of the array	 */
    val arrLen = arr.length
    
    /**************************	Core in selection sort algorithm	**************************/
    /*	Implement selection sort for the array	*/
    for (i <- 0 until arrLen) {
      var idxOfMaxElem = i
      for (j <- i until arrLen) {
        if (arr(idxOfMaxElem) < arr(j)) {        // Find the index of maximum element
          idxOfMaxElem = j
        }
      }
      if (idxOfMaxElem != i) ArrayUtils.swap(arr, idxOfMaxElem, i)
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
    
    val sortedArrAsc = selectionSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = selectionSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
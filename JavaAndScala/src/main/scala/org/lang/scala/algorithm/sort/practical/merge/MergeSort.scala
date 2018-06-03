package org.lang.scala.algorithm.sort.practical.merge

import java.util.Arrays
import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone object to implement merge sort
 * 
 * 	@author VinceYuan
 */
object MergeSort {
  
  /**
   * 	This is a method to implement merge sort in ascending order
   */
  def mergeSortAsc(arr: Array[Int]): Array[Int] = {
    
    /*	Merge sort the array	*/
    sortRecursively(arr, 0, arr.length - 1)
    
    /****************************	Core in merge sort  **************************************/
    /*	Sort by dividing the array into left-part and right-part using index recursively	*/
    def sortRecursively(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val midIdx = math.floor((endIdx - startIdx) / 2 + startIdx).toInt
        sortRecursively(arr, startIdx, midIdx)
        sortRecursively(arr, midIdx + 1, endIdx)
        // Merge left-part and right-part (also recursively during running)  */
        merge(arr, startIdx, midIdx, endIdx)
      }
    }
    
    /*	Merge left-part and right-part using index	*/
    def merge(arr: Array[Int], startIdx: Int, midIdx: Int, endIdx: Int): Unit = {
    
      /*	Copy the original array to a new array	*/
      val auxArr = Arrays.copyOf(arr, arr.length)
      
      /*	Merge and sort the new array into the original array	*/ 
      var idxInLeftArr = startIdx
      var idxInRightArr = midIdx + 1
      var idxInOriginalArr = startIdx
      while (idxInLeftArr <= midIdx || idxInRightArr <= endIdx) {
        // If right-part array elements has been added into the original array, then only need to add left-part
        if (idxInRightArr > endIdx) {
          arr(idxInOriginalArr) = auxArr(idxInLeftArr)
          idxInLeftArr += 1
        // If left-part array elements has been added into the original array, then only need to add right-part
        } else if (idxInLeftArr > midIdx) {
          arr(idxInOriginalArr) = auxArr(idxInRightArr)
          idxInRightArr += 1
        // Otherwise both-part array elements are being added into the original array
        } else {
          if (auxArr(idxInLeftArr) < auxArr(idxInRightArr)) {    // Sort in ascending order
            arr(idxInOriginalArr) = auxArr(idxInLeftArr)
            idxInLeftArr += 1
          } else {
            arr(idxInOriginalArr) = auxArr(idxInRightArr)
            idxInRightArr += 1
          }  
        }
        idxInOriginalArr += 1
      }
    }
    /***************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a method to implement merge sort in descending order
   */
  def mergeSortDesc(arr: Array[Int]): Array[Int] = {
    
    /*	Merge sort the array	*/
    sortRecursively(arr, 0, arr.length - 1)
    
    /****************************	Core in merge sort  **************************************/
    /*	Sort by dividing the array into left-part and right-part using index recursively	*/
    def sortRecursively(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val midIdx = math.floor((endIdx - startIdx) / 2 + startIdx).toInt
        sortRecursively(arr, startIdx, midIdx)
        sortRecursively(arr, midIdx + 1, endIdx)
        // Merge left-part and right-part (also recursively during running)  */
        merge(arr, startIdx, midIdx, endIdx)
      }
    }
    
    /*	Merge left-part and right-part using index	*/
    def merge(arr: Array[Int], startIdx: Int, midIdx: Int, endIdx: Int): Unit = {
    
      /*	Copy the original array to a new array	*/
      val auxArr = Arrays.copyOf(arr, arr.length)
      
      /*	Merge and sort the new array into the original array	*/ 
      var idxInLeftArr = startIdx
      var idxInRightArr = midIdx + 1
      var idxInOriginalArr = startIdx
      while (idxInLeftArr <= midIdx || idxInRightArr <= endIdx) {
        // If right-part array elements has been added into the original array, then only need to add left-part
        if (idxInRightArr > endIdx) {
          arr(idxInOriginalArr) = auxArr(idxInLeftArr)
          idxInLeftArr += 1
        // If left-part array elements has been added into the original array, then only need to add right-part
        } else if (idxInLeftArr > midIdx) {
          arr(idxInOriginalArr) = auxArr(idxInRightArr)
          idxInRightArr += 1
        // Otherwise both-part array elements are being added into the original array
        } else {
          if (auxArr(idxInLeftArr) > auxArr(idxInRightArr)) {    // Sort in descending order
            arr(idxInOriginalArr) = auxArr(idxInLeftArr)
            idxInLeftArr += 1
          } else {
            arr(idxInOriginalArr) = auxArr(idxInRightArr)
            idxInRightArr += 1
          }  
        }
        idxInOriginalArr += 1
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
    
    val sortedArrAsc = mergeSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = mergeSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
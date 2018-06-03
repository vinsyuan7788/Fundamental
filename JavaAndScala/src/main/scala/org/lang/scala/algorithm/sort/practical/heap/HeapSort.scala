package org.lang.scala.algorithm.sort.practical.heap

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone object to implement heap sort
 * 	-- Time complexity: O(n log n) for both best and worst
 * 	-- This algorithm is an unstable sort algorithm
 * 
 * 	@author VinceYuan
 */
object HeapSort {
  
  /**
   * 	This is a stand-alone object to implement heap sort in ascending order
   */
  private def heapSortAsc(arr: Array[Int]): Array[Int] = {
    
    /****************************	Core in heap sort	 **************************************/
    /*	Build binary min heap iteratively	 */
    val endIdx = arr.length - 1
    for (startIdx <- 0 until endIdx) {
      buildBinaryMinHeap(arr, startIdx, endIdx)
    }    
    
    /*	Build binary min heap	 */
    def buildBinaryMinHeap(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
    
      val arrLen = endIdx - startIdx + 1
      val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
      
      /*	Min heapify the sub-array bottom-up	iteratively  */
      for (index <- medianIdx to startIdx by -1) {
        minHeapify(arr, index, startIdx, endIdx)
      }
      
      /*	Min-heapfiy inside the sub-array top-down recursively	*/
      def minHeapify(arr: Array[Int], index: Int, startIdx: Int, endIdx: Int): Unit = {
        
        val arrLen = endIdx - startIdx + 1
        val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
        
        /*	If the node with given index has children	 */
        if (index >= startIdx && index <= medianIdx) {
          val parentIdx = index
          val leftChildIdx = 2 * parentIdx + 1 - startIdx
          val rightChildIdx = 2 * parentIdx + 2 - startIdx
          var minChildIdx = leftChildIdx
          if (rightChildIdx > endIdx && arr(leftChildIdx) < arr(parentIdx)) {
            ArrayUtils.swap(arr, leftChildIdx, parentIdx)
            minHeapify(arr, leftChildIdx, startIdx, endIdx)
          }
          if (rightChildIdx <= endIdx && arr(leftChildIdx) > arr(rightChildIdx)) {
            minChildIdx = rightChildIdx
          }
          if (arr(minChildIdx) < arr(parentIdx)) {
            ArrayUtils.swap(arr, minChildIdx, parentIdx)
            minHeapify(arr, minChildIdx, startIdx, endIdx)
          }
        }
      }
    }
    /**************************************************************************************/
    
    /*	Return the sorted array	 */
    arr
  }
  
  /**
   * 	This is a stand-alone object to implement heap sort in descending order
   */
  private def heapSortDesc(arr: Array[Int]): Array[Int] = {
    
    /****************************	Core in heap sort	 **************************************/
    /*	Build binary max heap iteratively	 */
    val endIdx = arr.length - 1
    for (startIdx <- 0 until endIdx) {
      buildBinaryMaxHeap(arr, startIdx, endIdx)
    }
    
    /*	Build binary max heap	 */
    def buildBinaryMaxHeap(arr: Array[Int], startIdx: Int, endIdx: Int): Unit = {
      
      val arrLen = endIdx - startIdx + 1
      val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
      
      /*	Max heapify the sub-array bottom-up	iteratively  */
      for (index <- medianIdx to startIdx by -1) {
        maxHeapify(arr, index, startIdx, endIdx)
      }
      
      /*	Max heapify inside the sub-array top-down recursively	*/
      def maxHeapify(arr: Array[Int], index: Int, startIdx: Int, endIdx: Int): Unit = {
        
        val arrLen = endIdx - startIdx + 1
        val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
        
        /*	If the node with given index has children	 */
        if (index >= startIdx && index <= medianIdx) {
          val parentIdx = index
          val leftChildIdx = 2 * parentIdx + 1 - startIdx
          val rightChildIdx = 2 * parentIdx + 2 - startIdx
          var maxChildIdx = leftChildIdx
          if (rightChildIdx > endIdx && arr(leftChildIdx) > arr(parentIdx)) {
            ArrayUtils.swap(arr, leftChildIdx, parentIdx)
            maxHeapify(arr, leftChildIdx, startIdx, endIdx)
          }
          if (rightChildIdx <= endIdx && arr(leftChildIdx) < arr(rightChildIdx)) {
            maxChildIdx = rightChildIdx
          }
          if (arr(maxChildIdx) > arr(parentIdx)) {
            ArrayUtils.swap(arr, maxChildIdx, parentIdx)
            maxHeapify(arr, maxChildIdx, startIdx, endIdx)
          }
        }
      }
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
    
    val sortedArrAsc = heapSortAsc(arr)
    println(s"Sorted Array in ascending order:\n${sortedArrAsc.mkString(", ")}")
    
    val sortedArrDesc = heapSortDesc(arr)
    println(s"Sorted Array in descending order:\n${sortedArrDesc.mkString(", ")}")
  }
}
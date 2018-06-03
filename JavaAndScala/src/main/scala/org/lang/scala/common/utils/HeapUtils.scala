package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contains heap utility methods
 * 
 * 	@author VinceYuan
 */
object HeapUtils {
  
  /**
   * 	This is a method to build a binary max-heap for the given array
   * 
   *  For example: for an array [5, 1, 8, 4, 6, 7, 9, 2], it is organized as below:
   *  
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--
   * 
   * 	After max-heapification, it would be organized as a possible max-heap shown below:
   * 
   *          9
   *          |
   *      6 ----- 8
   *      |       |
   *    4---1   7---5
   *    |
   * 	2-- 
   */
  def buildBinaryMaxHeap[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    buildBinaryMaxHeap(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to build a binary max-heap for the (sub-array of) given array
   */
  def buildBinaryMaxHeap[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    
    /*	Check sub array indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Construct a max heap from the array	 */
    val arrLen = endIdx - startIdx + 1
    val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
    for (parentIdx <- medianIdx to startIdx by -1) {
      
      /*	Max-heapify the tree structure as max heap	*/
      maxHeapify(arr, parentIdx, startIdx, endIdx)
    }
     
    /*	Max-heapify the sub-tree in the given array for max heap	*/
    def maxHeapify(arr: Array[T], index: Int, startIdx: Int, endIdx: Int): Unit = {
      
      /*	If the node with given index has children	 */
      if (TreeUtils.ifNodeHasChildren(arr, index, startIdx, endIdx)) {
       
        /*	Get the indices of parent, left child and right child	 */
        val parentIdx = index
        val leftChildIdx = 2 * parentIdx + 1 - startIdx
        val rightChildIdx = 2 * parentIdx + 2 - startIdx
          
        /*	Max-heapify the sub-tree for max heap	 */
        var maxChildIdx = leftChildIdx
        if (rightChildIdx > endIdx && ord.gt(arr(leftChildIdx), arr(parentIdx))) {
          ArrayUtils.swap(arr, leftChildIdx, parentIdx)
          maxHeapify(arr, leftChildIdx, startIdx, endIdx)
        } 
        if (rightChildIdx <= endIdx && ord.lt(arr(leftChildIdx), arr(rightChildIdx))) {
          maxChildIdx = rightChildIdx
        }
        if (ord.gt(arr(maxChildIdx), arr(parentIdx))) {
          ArrayUtils.swap(arr, maxChildIdx, parentIdx)
          maxHeapify(arr, maxChildIdx, startIdx, endIdx)
        }
      }
    }
  }
  
  /**
   * 	This is a method to build a binary min-heap for the given array
   * 
   *  For example: for an array [5, 1, 8, 4, 6, 7, 9, 2], it is organized as below:
   *  
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--
   * 
   * 	After min-heapification, it would be organized as a possible min-heap shown below:
   * 
   *          1
   *          |
   *      2 ----- 5
   *      |       |
   *    4---6   7---8
   *    |
   * 	9-- 
   */
  def buildBinaryMinHeap[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    buildBinaryMinHeap(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to build a binary min-heap for the (sub-array of) given array
   */
  def buildBinaryMinHeap[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {

    /*	Check sub array indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Construct a min heap from the array	 */
    val arrLen = endIdx - startIdx + 1
    val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
    for (parentIdx <- medianIdx to startIdx by -1) {
           
      /*	Min-heapify the tree structure as min heap	*/
      minHeapify(arr, parentIdx, startIdx, endIdx)     
    }
    
    /*	Min-heapify the sub-tree in the given array for min heap	*/
    def minHeapify(arr: Array[T], index: Int, startIdx: Int, endIdx: Int): Unit = {
      
      /*	If the node with given index has children	 */
      if (TreeUtils.ifNodeHasChildren(arr, index, startIdx, endIdx)) {
        
        /*	Get the indices of parent, left child and right child	 */
        val parentIdx = index
        val leftChildIdx = 2 * parentIdx + 1 - startIdx
        val rightChildIdx = 2 * parentIdx + 2 - startIdx
          
        /*	Min-heapify the sub-tree for min heap	 */
        var minChildIdx = leftChildIdx
        if (rightChildIdx > endIdx && ord.lt(arr(leftChildIdx), arr(parentIdx))) {
          ArrayUtils.swap(arr, leftChildIdx, parentIdx)
          minHeapify(arr, leftChildIdx, startIdx, endIdx)
        } 
        if (rightChildIdx <= endIdx && ord.gt(arr(leftChildIdx), arr(rightChildIdx))) {
          minChildIdx = rightChildIdx
        }
        if (ord.lt(arr(minChildIdx), arr(parentIdx))) {
          ArrayUtils.swap(arr, minChildIdx, parentIdx)
          minHeapify(arr, minChildIdx, startIdx, endIdx)
        }
      }
    }
  }
}
package org.lang.scala.common.utils

import scala.reflect.ClassTag

/**
 * 	This is a stand-alone object that contains sort utility methods
 * 
 * 	@author VinceYuan
 */
object SortUtils {
  
  /**
   * 	This is a method to sort the array in ascending order using quick sort
   * 
   * 	Assuming the original array is [5, 1, 4, 2, 8], then:
   *  Round 1: pivot = 5, leftIdx = 0, rightIdx = 4
   *           [5, 1, 4, 2, 8] ---> [2, 1, 4, 5, 8] ---> [2, 1, 4, 5, 8] ---> pivotIdx = 3
   *  Round 2: pivot = 2, leftIdx = 0, rightIdx = 3
   *           [2, 1, 4, 5] ---> [1, 2, 4, 5] ---> [1, 2, 4, 5] ---> pivotIdx = 1
   *  Round 3, 4, 5...: the array is no more changed, hence final sorted array:
   *  [1, 2, 4, 5, 8]                     
   */
  def quickSortAsc[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    quickSortAsc(arr, 0, arr.length - 1)  
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in ascending order using quick sort
   */
  def quickSortAsc[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
  
    /*	Check input indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Sort recursively	*/
    sortRecursively(arr, startIdx, endIdx)
    
    /*	Define how to sort (conquer and divide) recursively	 */
    def sortRecursively(arr: Array[T], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val pivotIdx = partition(arr, startIdx, endIdx)
        sortRecursively(arr, startIdx, pivotIdx - 1)
        sortRecursively(arr, pivotIdx + 1, endIdx)
      } 
    }
    
    /*	Define how to partition (conquer)	 */
    def partition(arr: Array[T], startIdx: Int, endIdx: Int): Int = {      
      val pivot = arr(startIdx)
      var leftIdx = startIdx
      var rightIdx = endIdx
      while (leftIdx < rightIdx) {
        while (ord.gt(arr(rightIdx), pivot) && leftIdx < rightIdx) rightIdx -= 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
        while (ord.lt(arr(leftIdx), pivot) && leftIdx < rightIdx) leftIdx += 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
      }
      val pivotIdx = leftIdx
      pivotIdx
    }
  }

  /**
   * 	This is a method to sort the array in descending order using quick sort
   */
  def quickSortDesc[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    quickSortDesc(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in descending order using quick sort
   */
  def quickSortDesc[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    
    /*	Check input indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Sort recursively	*/
    sortRecursively(arr, startIdx, endIdx)
    
    /*	Define how to sort (conquer and divide) recursively	 */
    def sortRecursively(arr: Array[T], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val pivotIdx = partition(arr, startIdx, endIdx)
        sortRecursively(arr, startIdx, pivotIdx - 1)
        sortRecursively(arr, pivotIdx + 1, endIdx)
      } 
    }
    
    /*	Define how to partition (conquer)	 */
    def partition(arr: Array[T], startIdx: Int, endIdx: Int): Int = {      
      val pivot = arr(endIdx)
      var leftIdx = startIdx
      var rightIdx = endIdx
      while (leftIdx < rightIdx) {
        while (ord.gt(arr(leftIdx), pivot) && leftIdx < rightIdx) leftIdx += 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
        while (ord.lt(arr(rightIdx), pivot) && leftIdx < rightIdx) rightIdx -= 1
        ArrayUtils.swap(arr, leftIdx, rightIdx)
      }
      val pivotIdx = leftIdx
      pivotIdx
    }
  }
  
  /**
   * 	This is a method to sort the array in ascending order using merge sort
   * 
   * 	Assuming the original array is [5, 1, 4, 2, 8], then:
   *  Round 1: pivot = 5, leftIdx = 0, rightIdx = 4
   *           [5, 1, 4, 2, 8] ---> [2, 1, 4, 5, 8] ---> [2, 1, 4, 5, 8] ---> pivotIdx = 3
   *  Round 2: pivot = 2, leftIdx = 0, rightIdx = 3
   *           [2, 1, 4, 5] ---> [1, 2, 4, 5] ---> [1, 2, 4, 5] ---> pivotIdx = 1
   *  Round 3, 4, 5...: the array is no more changed, hence final sorted array:
   *  [1, 2, 4, 5, 8]
   */
  def mergeSortAsc[T : ClassTag](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    mergeSortAsc(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in ascending order using merge sort
   */
  def mergeSortAsc[T : ClassTag](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    
    /*	Check input indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Divide and merge (divide and conquer) recursively	 */
    divide(arr, startIdx, endIdx)
    
    /*	Define how to divide array into left-part and right-part recursively	*/
    def divide(arr: Array[T], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val midIdx = math.floor((endIdx - startIdx) / 2 + startIdx).toInt
        divide(arr, startIdx, midIdx)
        divide(arr, midIdx + 1, endIdx)
        merge(arr, startIdx, midIdx, endIdx)
      }
    }
    
    /*	Define how to merge left-part and right-part	*/
    def merge(arr: Array[T], startIdx: Int, midIdx: Int, endIdx: Int): Unit = {
      
      /*	Copy the original array	 */
      val auxArr = arr.clone()
      
      /*	Merge left-part and right-part	*/
      var idxInLeftArr = startIdx
      var idxInRightArr = midIdx + 1
      var idxInOriginalArr = startIdx      
      while (idxInLeftArr <= midIdx || idxInRightArr <= endIdx) {
        if (idxInRightArr > endIdx) {
          arr(idxInOriginalArr) = auxArr(idxInLeftArr)
          idxInLeftArr += 1
        } else if (idxInLeftArr > midIdx) {
          arr(idxInOriginalArr) = auxArr(idxInRightArr)
          idxInRightArr += 1
        } else {
          if (ord.lt(auxArr(idxInLeftArr), auxArr(idxInRightArr))) {
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
  }
  
  /**
   * 	This is a method to sort the array in descending order using merge sort
   */
  def mergeSortDesc[T : ClassTag](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    mergeSortDesc(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in descending order using merge sort
   */
  def mergeSortDesc[T : ClassTag](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    
    /*	Check input indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Divide and merge (divide and conquer) recursively	 */
    divide(arr, startIdx, endIdx)
    
    /*	Define how to divide array into left-part and right-part recursively with index	 */
    def divide(arr: Array[T], startIdx: Int, endIdx: Int): Unit = {
      if (startIdx < endIdx) {
        val midIdx = math.floor((endIdx - startIdx) / 2 + startIdx).toInt
        divide(arr, startIdx, midIdx)
        divide(arr, midIdx + 1, endIdx)
        merge(arr, startIdx, midIdx, endIdx)
      }
    }
    
    /*	Define how to merge left-part and right-part with index	 */
    def merge(arr: Array[T], startIdx: Int, midIdx: Int, endIdx: Int): Unit = {
      
      /*	Copy the original array	 */
      val auxArr = arr.clone()
      
      /*	Merge left-part and right-part	*/
      var idxInLeftArr = startIdx
      var idxInRightArr = midIdx + 1
      var idxInOriginalArr = startIdx     
      while (idxInLeftArr <= midIdx || idxInRightArr <= endIdx) {
        if (idxInRightArr > endIdx) {
          arr(idxInOriginalArr) = auxArr(idxInLeftArr)
          idxInLeftArr += 1
        } else if (idxInLeftArr > midIdx) {
          arr(idxInOriginalArr) = auxArr(idxInRightArr)
          idxInRightArr += 1
        } else {
          if (ord.gt(auxArr(idxInLeftArr), auxArr(idxInRightArr))) {
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
  }
  
  /**
   * 	This is a method to sort the array in ascending order with heap sort
   */
  def heapSortAsc[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    heapSortAsc(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in ascending order with heap sort
   */
  def heapSortAsc[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    for (index <- startIdx until endIdx) {
      HeapUtils.buildBinaryMinHeap(arr, index, endIdx)
    }
  }
  
  /**
   * 	This is a method to sort the array in descending order with heap sort
   */
  def heapSortDesc[T](arr: Array[T])(implicit ord: Ordering[T]): Unit = {
    heapSortDesc(arr, 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to sort the (sub-array of) array in descending order with heap sort
   */
  def heapSortDesc[T](arr: Array[T], startIdx: Int, endIdx: Int)(implicit ord: Ordering[T]): Unit = {
    for (index <- startIdx until endIdx) {
      HeapUtils.buildBinaryMaxHeap(arr, index, endIdx)
    }
  }
}
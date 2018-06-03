package org.lang.scala.conclusion.dandc.common.classes.forkjointask.recursivetask

import java.util.concurrent.RecursiveTask

import scala.reflect.ClassTag

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone class that represents a recursive task
 *  -- Recursive task has a return value
 * 
 * 	@author VinceYuan
 */
class QuickSort[T : ClassTag : Ordering] extends RecursiveTask[Array[T]] {
  
  /*	Necessary instance variables	*/
  private val sizeGranularity = 1
  private var arr: Array[T] = _
  private val ord = implicitly[Ordering[T]]
  
  /*	Auxiliary constructors	*/
  def this(arr: Array[T]) = {
    this()
    this.arr = arr
  }
  
  /**
   * 	This is a method to do the computation
   */
  override def compute(): Array[T] = {
    
    // If the array can be sorted
    if (canSort) {
      // Sort the array and get pivot index
      val pivotIdx = partition(arr)
      var sortLeft: QuickSort[T] = null
      var sortRight: QuickSort[T] = null
      // If pivot index = 0
      if (pivotIdx == 0) {
        val rightArr = arr.takeRight(arr.length - pivotIdx - 1)
        // Create sub-tasks
        sortRight = new QuickSort(rightArr)
        // Fork threads to run sub-tasks and wait for their completion
        val sortedArr = sortRight.fork().join()
        arr.take(1) ++ sortedArr
      // If pivot index = arr.lenght - 1
      } else if (pivotIdx == arr.length - 1) {
        val leftArr = arr.take(pivotIdx)
        // Create sub-tasks
        sortLeft = new QuickSort(leftArr)
        // Fork threads to run sub-tasks and wait for their completion
        val sortedArr = sortLeft.fork().join()
        sortedArr ++ arr.takeRight(1)
      // Otherwise
      } else {
        val leftArr = arr.take(pivotIdx)
        val rightArr = arr.takeRight(arr.length - pivotIdx - 1)
        // Create sub-tasks
        sortLeft = new QuickSort(leftArr)
        sortRight = new QuickSort(rightArr)
        // Fork threads to run sub-tasks
        sortLeft.fork()
        sortRight.fork()
        // Wait for the completion of sub-tasks
        val sortedLeftArr = sortLeft.join()
        val sortedRightArr = sortRight.join()
        (sortedLeftArr :+ arr(pivotIdx)) ++ sortedRightArr
      }
    } else {
      arr
    }
  }
  
  /**
   * 	This is a method to partition the array
   */
  private def partition(arr: Array[T]) = {
    
    val pivot = arr(0)
    var leftIdx = 0
    var rightIdx = arr.length - 1
    while (leftIdx < rightIdx) {
      while (ord.gt(arr(rightIdx), pivot) && leftIdx < rightIdx) rightIdx -= 1
      ArrayUtils.swap(arr, leftIdx, rightIdx)
      while (ord.lt(arr(leftIdx), pivot) && leftIdx < rightIdx) leftIdx += 1
      ArrayUtils.swap(arr, leftIdx, rightIdx)
    }
    val pivotIdx = leftIdx
    pivotIdx
  }
  
  /**
   * 	This is a method to predicate if a task can be computed directly
   */
  private def canSort = if (arr.length > sizeGranularity) true else false
}
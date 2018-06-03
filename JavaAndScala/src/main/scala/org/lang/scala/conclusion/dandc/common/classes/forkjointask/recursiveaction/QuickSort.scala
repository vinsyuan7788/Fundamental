package org.lang.scala.conclusion.dandc.common.classes.forkjointask.recursiveaction

import java.util.concurrent.RecursiveAction

import org.lang.scala.common.utils.ArrayUtils

/**
 * 	This is a stand-alone class that represents a recursive action
 *  -- Recursive action has no return value
 * 
 * 	@author VinceYuan
 */
class QuickSort[T : Ordering] extends RecursiveAction {
  
  /*	Necessary instance variables	*/
  private val idxRangeGranularity = 0
  private var arr: Array[T] = _
  private var startIdx: Int = _
  private var endIdx: Int = _
  private val ord = implicitly[Ordering[T]]
  
  /*	Auxiliary constructors	*/
  def this(arr: Array[T]) = {
    this()
    this.arr = arr
    this.startIdx = 0
    this.endIdx = arr.length - 1
  }
  def this(arr: Array[T], startIdx: Int, endIdx: Int) = {
    this()
    this.arr = arr
    this.startIdx = startIdx
    this.endIdx = endIdx
  }
  
  /**
   * 	This is a method to do the computation
   */
  override def compute(): Unit = {
    
    // If the array can be sorted
    if (canSort) {
      // Get the pivot index 
      val pivotIdx = partition(arr, startIdx, endIdx)
      // Create sub-tasks
      val sortLeft = new QuickSort(arr, startIdx, pivotIdx - 1)
      val sortRight = new QuickSort(arr, pivotIdx + 1, endIdx)
      // Fork threads to run sub-tasks
      sortLeft.fork()
      sortRight.fork()
      // Wait for the completion of sub-tasks
      sortLeft.join()        
      sortRight.join()
    }
  }
  
  /**
   * 	This is a method to partition the array
   */
  private def partition(arr: Array[T], startIdx: Int, endIdx: Int) = {
    
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
  
  /**
   * 	This is a method to predicate if a task can be computed directly
   */
  private def canSort = if (endIdx - startIdx > idxRangeGranularity) true else false
}
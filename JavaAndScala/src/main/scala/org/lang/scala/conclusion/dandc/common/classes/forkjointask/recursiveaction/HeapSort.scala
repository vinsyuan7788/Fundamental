package org.lang.scala.conclusion.dandc.common.classes.forkjointask.recursiveaction

import java.util.concurrent.RecursiveAction

import scala.reflect.ClassTag

import org.lang.scala.common.utils.HeapUtils

/**
 * 	This is a stand-alone class that represents a recursive action
 *  -- Recursive action has no return value
 * 
 * 	@author VinceYuan
 */
class HeapSort[T : ClassTag : Ordering] extends RecursiveAction {
  
  /*	Necessary instance variables	*/
  private val idxRangeGranularity = 0
  private var arr: Array[T] = _
  private var startIdx: Int = _
  private var endIdx: Int = _
  
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
      HeapUtils.buildBinaryMinHeap(arr, startIdx, endIdx)
      new HeapSort(arr, startIdx + 1, endIdx).fork().join()
    }
  }
  
  /**
   * 	This is a method to predicate if a task can be computed directly
   */
  private def canSort = if (endIdx - startIdx > idxRangeGranularity) true else false
}
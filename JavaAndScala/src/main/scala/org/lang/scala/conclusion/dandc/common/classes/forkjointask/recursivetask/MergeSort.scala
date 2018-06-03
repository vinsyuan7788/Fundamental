package org.lang.scala.conclusion.dandc.common.classes.forkjointask.recursivetask

import java.util.concurrent.RecursiveTask

import scala.reflect.ClassTag

/**
 * 	This is a stand-alone class that represents a recursive task
 *  -- Recursive task has a return value
 * 
 * 	@author VinceYuan
 */
class MergeSort[T : ClassTag : Ordering] extends RecursiveTask[Array[T]] {
  
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
      // Divide the array into left and right
      val midIdx = math.floor((arr.length - 1) / 2).toInt
      val leftArr = arr.take(midIdx + 1)
      val rightArr = arr.takeRight(arr.length - 1 - midIdx)
      // Create sub-tasks
      val sortLeft = new MergeSort(leftArr)
      val sortRight = new MergeSort(rightArr)
      // For threads to run sub-tasks 
      sortLeft.fork()
      sortRight.fork()
      // Wait for the completion of sub-tasks and get return sorted arrays
      val sortedLeftArr = sortLeft.join()
      val sortedRightArr = sortRight.join()
      // Merge two sorted arrays and return
      val sortedArr = merge(sortedLeftArr, sortedRightArr)
      sortedArr
    // Otherwise return the array directly
    } else {
      arr
    }
  }
  
  /**
   * 	This is a method to merge the array
   */
  private def merge(sortedLeftArr: Array[T], sortedRightArr: Array[T]): Array[T] = {
    
    /*	Initialize an array	to store sorted elements	*/
    var arr = Array[T]()
    
    /*	Merge left-part and right-part	*/
    var idxInLeftArr = 0
    var idxInRightArr = 0
    val endIdxInLeftArr = sortedLeftArr.length - 1
    val endIdxInRightArr = sortedRightArr.length - 1
    while (idxInLeftArr <= endIdxInLeftArr || idxInRightArr <= endIdxInRightArr) {
      if (idxInRightArr > endIdxInRightArr) {
        arr :+= sortedLeftArr(idxInLeftArr)
        idxInLeftArr += 1
      } else if (idxInLeftArr > endIdxInLeftArr) {
        arr :+= sortedRightArr(idxInRightArr)
        idxInRightArr += 1
      } else {
        if (ord.lt(sortedLeftArr(idxInLeftArr), sortedRightArr(idxInRightArr))) {
          arr :+= sortedLeftArr(idxInLeftArr)
          idxInLeftArr += 1
        } else {
          arr :+= sortedRightArr(idxInRightArr)
          idxInRightArr += 1            
        }
      }
    }
    
    /*	Return sorted array	 */
    arr
  }
  
  /**
   * 	This is a method to predicate if a task can be computed directly
   */
  private def canSort = if (arr.length > sizeGranularity) true else false
}
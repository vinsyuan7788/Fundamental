package org.lang.scala.common.utils

import scala.collection.mutable.Stack
import scala.collection.mutable.Queue

/**
 * 	This is a stand-alone object that contains search utility methods
 * 
 * 	@author VinceYuan
 */
object SearchUtils {
  
  /**
   * 	This is a method to search a specific element in the given array using DFS
   * 
   * 	For example, for array [5, 1, 8, 4, 6, 7, 9, 2], the tree structure is:
   *
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--	
   *  
   *  There are 8 vertices (or nodes) and 7 edges in total
   *  -- Vertex: 5, 1, 8, 4, 6, 7, 9, 2
   *  -- Edge: 5 ---> 1
   *           5 ---> 8
   *           1 ---> 4
   *           1 ---> 6
   *           8 ---> 7
   *           8 ---> 9
   *           4 ---> 2      
   *  -- Hence worst-case time complexity is O(8 + 7) = O(15)                     
   * 	The indices in the stack would be (suppose the element is not found finally):
   *  -- Initial: 0
   *  -- Round 1: 1, 2
   *  -- Round 2: 1, 4, 5
   *  -- Round 3: 1, 4
   *  -- Round 4, 1
   *  -- Round 5: 3, 4
   *  -- Round 6: 3
   *  -- Round 7: 6, 7
   *  -- Round 8: 6
   */
  def depthFirstSearch[T](arr: Array[T], elem: T)(implicit ord: Ordering[T]): Int = {
    depthFirstSearch(arr, 0, arr.length - 1, elem)
  }

  /**
   * 	This is a method to search a specific element in the (sub-array of) given array using DFS
   */
  def depthFirstSearch[T](arr: Array[T], startIdx: Int, endIdx: Int, elem: T)(implicit ord: Ordering[T]): Int = {
    
    val stack = Stack[Int]()
    stack.push(startIdx)
    
    while (stack.size != 0) {
      val currentIdx = stack.pop()
      if (ord.equiv(arr(currentIdx), elem)) {
        return currentIdx - startIdx
      } else {
        val medianIdx = math.floor((endIdx - startIdx + 1) / 2 - 1 + startIdx).toInt
        if (currentIdx >= 0 && currentIdx <= medianIdx) {
          val leftChildIdx = 2 * currentIdx + 1 - startIdx
          val rightChildIdx = 2 * currentIdx + 2 - startIdx
          if (rightChildIdx > endIdx) {
            stack.push(leftChildIdx)
          } else {
            for (index <- leftChildIdx to rightChildIdx) {
              stack.push(index)
            }
          }
        }
      }
    }
    
    -1
  }
  
  /**
   * 	This is a method to search a specific element in the given array using BFS
   * 
   * 	For example, for array [5, 1, 8, 4, 6, 7, 9, 2], the tree structure is:
   *
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--	
   *  
   *  There are 8 vertices (or nodes) and 7 edges in total
   *  -- Vertex: 5, 1, 8, 4, 6, 7, 9, 2
   *  -- Edge: 5 ---> 1
   *           5 ---> 8
   *           1 ---> 4
   *           1 ---> 6
   *           8 ---> 7
   *           8 ---> 9
   *           4 ---> 2 
   *  -- Hence worst-case time complexity is O(8 + 7) = O(15)                          
   * 	The indices in the queue would be (suppose the element is not found finally):
   *  -- Initial: 0
   *  -- Round 1: 1, 2
   *  -- Round 2: 2, 3, 4
   *  -- Round 3: 3, 4, 5, 6
   *  -- Round 4, 4, 5, 6, 7
   *  -- Round 5: 5, 6, 7
   *  -- Round 6: 6, 7
   *  -- Round 7: 7
   */
  def breadthFirstSearch[T](arr: Array[T], elem: T)(implicit ord: Ordering[T]): Int = {
    breadthFirstSearch(arr, 0, arr.length - 1, elem)
  }
  
  /**
   * 	This is a method to search a specific element in the (sub-array of) given array using BFS
   */
  def breadthFirstSearch[T](arr: Array[T], startIdx: Int, endIdx: Int, elem: T)(implicit ord: Ordering[T]): Int = {

    val queue = Queue[Int]()
    queue.enqueue(startIdx)
    
    while (queue.size != 0) {
      val currentIdx = queue.dequeue()
      if (ord.equiv(arr(currentIdx), elem)) {
        return currentIdx - startIdx
      } else {
        val medianIdx = math.floor((endIdx - startIdx + 1) / 2 - 1 + startIdx).toInt
        if (currentIdx >= 0 && currentIdx <= medianIdx) {
          val leftChildIdx = 2 * currentIdx + 1 - startIdx
          val rightChildIdx = 2 * currentIdx + 2 - startIdx
          if (rightChildIdx > endIdx) {
            queue.enqueue(leftChildIdx)
          } else {
            for (index <- leftChildIdx to rightChildIdx) {
              queue.enqueue(index)
            }
          }
        }
      }
    }
    
    -1
  }
  
  /**
   * 	This is a method to search a specific element in the given sorted array using binary search
   */
  def binarySearch[T](sortedArr: Array[T], isAsc: Boolean, targetElem: T)(implicit ord: Ordering[T]): Int = {
    binarySearch(sortedArr, isAsc, 0, sortedArr.length - 1, targetElem)
  }
  
  /**
   * 	This is a method to search a specific element in the (sub-array of) given sorted array using binary search
   */
  def binarySearch[T](sortedArr: Array[T], isAsc: Boolean, startIdx: Int, endIdx: Int, targetElem: T)(implicit ord: Ordering[T]): Int = {

    /*	Initialize low index and high index	 */
    var lowIdx = startIdx
    var highIdx = endIdx 
     
    /*	Binary search target element and return its index if found	 */
    if (isAsc) {
      while (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        if (ord.equiv(targetElem, sortedArr(midIdx))) return midIdx - startIdx
        if (ord.gt(targetElem, sortedArr(midIdx))) lowIdx = midIdx + 1
        if (ord.lt(targetElem, sortedArr(midIdx))) highIdx = midIdx - 1
      } 
    } else {
      while (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        if (ord.equiv(targetElem, sortedArr(midIdx))) return midIdx - startIdx
        if (ord.gt(targetElem, sortedArr(midIdx))) highIdx = midIdx - 1
        if (ord.lt(targetElem, sortedArr(midIdx))) lowIdx = midIdx + 1
      }
    }
    
    /*	Return -1 if target element is not found	*/
    -1
  }
  
  /**
   * 	This is a method to search a specific element in the given array using linear (or sequential) search
   */
  def linearSearch[T](arr: Array[T], targetElem: T)(implicit ord: Ordering[T]): Int = {
    linearSearch(arr, 0, arr.length - 1, targetElem)
  }
  
  /**
   * 	This is a method to search a specific element in the (sub-array of) given array using linear (or sequential) search
   */ 
  def linearSearch[T](arr: Array[T], startIdx: Int, endIdx: Int, targetElem: T)(implicit ord: Ordering[T]): Int = {
    
    /*	Linear search target element and return its index if found	*/
    for (index <- startIdx to endIdx) {
      if (ord.equiv(arr(index), targetElem)) return index - startIdx
    }
    
    /*	Return -1 if target element is not found	*/
    return -1
  }
}
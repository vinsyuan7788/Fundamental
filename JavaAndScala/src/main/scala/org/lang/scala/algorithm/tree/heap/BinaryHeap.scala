package org.lang.scala.algorithm.tree.heap

import org.lang.scala.common.utils.ArrayUtils
import org.lang.scala.common.utils.TreeUtils

/**
 * 	This is a stand-alone object to implement a binary heap
 *  -- Binary heap essentially belongs to binary tree structure
 *  
 *  A 0-based indexed sequence {k(0), k(1), ..., k(n-1)} is a binary heap If and only if below condition is satisfied
 *  -- (k(i) <= k(2i+1) && k(i) <= k(2i+2)) or (k(i) >= k(2i+1) && k(i) >= k(2i+2))
 *  For those satisfying k(i) <= k(2i+1) && k(i) <= k(2i+2), it is min heap
 *  For those satisfying k(i) >= k(2i+1) && k(i) >= k(2i+2), it is max heap
 *  
 *  Features of binary heap (for 0-based index):
 *  -- From index perspective:
 *     -- For a parent node i: its left child index is (2i + 1) and right child index is (2i + 2)
 *     -- For a child node i: its parent index is floor((i - 1) / 2)
 *  -- From size perspective:
 *     -- For a tree (or array) with size N, only the nodes indexed from 0 to floor(N / 2 - 1) have children
 *     
 *  Features of binary heap (for any start index)
 *  -- From index perspective:
 *     -- For a parent node i: 
 *        -- Left child index: 2i + 1 - startIdx (due to 2 * (i - startIdx) + 1 + startIdx)
 *        -- Right child index: 2i + 2 - startIdx (due to  2 * (i - startIdx) + 2 + startIdx)
 *     -- For a child node i:
 *        -- parent index: floor((i + startIdx - 1) / 2)
 *  -- From size perspective:
 *     -- The tree size (or array) N is (endIdx - startIdx + 1)
 *     -- Only the nodes indexed from startIdx to floor(N / 2 - 1 + startIdx) have children
 *        -- MedianIdx = floor(N / 2 - 1 + startIdx)
 * 	
 * 	@author VinceYuan
 */
object BinaryHeap {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {

    /*	Initialize an array	 */
    val arr = Array(5, 1, 4, 2, 8, 6, 9, 7)
    println(s"Input array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the input array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}\n")
    
    /*	Build a max heap	*/
    buildMaxHeap(arr)
    println(s"Max heap:\n${arr.mkString(", ")}")
    println(s"Binary tree for the max-heapified array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}\n")
    
    /*	Build a min heap	*/
    buildMinHeap(arr)
    println(s"Min heap:\n${arr.mkString(", ")}")
    println(s"Binary tree for the min-heapified array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}")
  }
  
  /**
   * 	This is a method to build a max heap from an array
   */
  private def buildMaxHeap(arr: Array[Int]): Unit = {
    
    /*	Construct a max heap from the array	 */
    val medianIdx = arr.length / 2 - 1
    for (parentIdx <- medianIdx to 0 by -1) {
      
      /*	Max-heapify the tree structure as max heap	*/
      maxHeapify(arr, parentIdx)
    }
     
    /*	Max-heapify the sub-tree in the given array for max heap	*/
    def maxHeapify(arr: Array[Int], index: Int): Unit = {
      
      /*	If the node with given index has children	 */
      if (TreeUtils.ifNodeHasChildren(arr, index)) {
       
        /*	Get the indices of parent, left child and right child	 */
        val parentIdx = index
        val leftChildIdx = 2 * parentIdx + 1
        val rightChildIdx = 2 * parentIdx + 2
        val endIdx = arr.length - 1
          
        /*	Max-heapify the sub-tree for max heap	 */
        var maxChildIdx = leftChildIdx
        if (rightChildIdx > endIdx && arr(leftChildIdx) > arr(parentIdx)) {
          ArrayUtils.swap(arr, leftChildIdx, parentIdx)
          maxHeapify(arr, leftChildIdx)
        } 
        if (rightChildIdx <= endIdx && arr(leftChildIdx) < arr(rightChildIdx)) {
          maxChildIdx = rightChildIdx
        }
        if (arr(maxChildIdx) > arr(parentIdx)) {
          ArrayUtils.swap(arr, maxChildIdx, parentIdx)
          maxHeapify(arr, maxChildIdx)
        }
      }
    }
  }
  
  /**
   * 	This is a method to build a min heap from an array
   */
  private def buildMinHeap(arr: Array[Int]): Unit = {
    
    /*	Construct a max heap from the array	 */
    val medianIdx = arr.length / 2 - 1
    for (parentIdx <- medianIdx to 0 by -1) {
           
      /*	Min-heapify the tree structure as min heap	*/
      minHeapify(arr, parentIdx)     
    }
    
    /*	Min-heapify the sub-tree in the given array for min heap	*/
    def minHeapify(arr: Array[Int], index: Int): Unit = {
      
      /*	If the node with given index has children	 */
      if (TreeUtils.ifNodeHasChildren(arr, index)) {
        
        /*	Get the indices of parent, left child and right child	 */
        val parentIdx = index
        val leftChildIdx = 2 * parentIdx + 1
        val rightChildIdx = 2 * parentIdx + 2
        val endIdx = arr.length - 1
          
        /*	Min-heapify the sub-tree for min heap	 */
        var minChildIdx = leftChildIdx
        if (rightChildIdx > endIdx && arr(leftChildIdx) < arr(parentIdx)) {
          ArrayUtils.swap(arr, leftChildIdx, parentIdx)
          minHeapify(arr, leftChildIdx)
        } 
        if (rightChildIdx <= endIdx && arr(leftChildIdx) > arr(rightChildIdx)) {
          minChildIdx = rightChildIdx
        }
        if (arr(minChildIdx) < arr(parentIdx)) {
          ArrayUtils.swap(arr, minChildIdx, parentIdx)
          minHeapify(arr, minChildIdx)
        }
      }
    }
  }
}
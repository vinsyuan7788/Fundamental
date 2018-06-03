package org.lang.scala.common.test

import org.lang.scala.common.utils.HeapUtils
import org.lang.scala.common.utils.TreeUtils

/**
 * 	This is a stand-alone object to test HeapUtils
 * 
 * 	@author VinceYuan
 */
object TestHeapUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testHeapUtils()
  }
  
  /**
   * 	This is a method to test HeapUtils
   */
  private def testHeapUtils(): Unit = {
  
    val arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    println(s"Original array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}")
    
    HeapUtils.buildBinaryMaxHeap(arr, 0, 4)                 // Only max-heapify the first 5 elements
    println(s"\nMax-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr, 0, 4).mkString("\n")}")
    
    HeapUtils.buildBinaryMaxHeap(arr, 3, arr.length - 1)    // Only max-heapify the last 5 elements
    println(s"\nMax-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr, 3, arr.length - 1).mkString("\n")}")
    
    HeapUtils.buildBinaryMaxHeap(arr)
    println(s"\nMax-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}")

    HeapUtils.buildBinaryMinHeap(arr, 0, 4)                 // Only min-heapify the first 5 elements
    println(s"\nMin-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr, 0, 4).mkString("\n")}")
    
    HeapUtils.buildBinaryMinHeap(arr, 3, arr.length - 1)    // Only min-heapify the last 5 elements
    println(s"\nMin-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr, 3, arr.length - 1).mkString("\n")}")
    
    HeapUtils.buildBinaryMinHeap(arr)
    println(s"\nMin-heapified array:\n${arr.mkString(", ")}")
    println(s"Binary tree for the array:\n${TreeUtils.exposeBinaryTree(arr).mkString("\n")}")
  }
}
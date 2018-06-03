package org.lang.scala.common.test

import org.lang.scala.common.utils.TreeUtils

/**
 * 	This is a stand-alone object to test TreeUtils
 * 
 * 	@author VinceYuan
 */
object TestTreeUtils {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testTreeUtils()
  }
  
  /**
   * 	This is a method to test TreeUtils
   */
  private def testTreeUtils(): Unit = {
    
    val arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    println(s"Original array:\n${arr.mkString(", ")}")
    
    val binaryTree = TreeUtils.exposeBinaryTree(arr)
    println(s"\nBinary tree for the array:\n${binaryTree.mkString("\n")}")
    
    println("\nSee which nodes in the tree have children:")
    for (index <- 0 until arr.length) {
      println(s"If node ${arr(index)} has children: ${TreeUtils.ifNodeHasChildren(arr, index)}")
    }

    val nodesWithChildren = TreeUtils.getNodesWithChildren(arr)
    println(s"\nNodes in the tree that have children: ${nodesWithChildren.mkString(", ")}")

    val subBinaryTree = TreeUtils.exposeBinaryTree(arr, 0, 4)
    println(s"\nSub binary tree for the array:\n${subBinaryTree.mkString("\n")}")
    
    println("\nSee which nodes in the sub-tree have children:")
    for (index <- 0 until 5) {
      println(s"If node ${arr(index)} has children: ${TreeUtils.ifNodeHasChildren(arr, index, 0, 4)}")
    }
    
    val nodesWithChildren2 = TreeUtils.getNodesWithChildren(arr, 0, 4)
    println(s"\nNodes in the sub-tree that have children: ${nodesWithChildren2.mkString(", ")}")
  }
}
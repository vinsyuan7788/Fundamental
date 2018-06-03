package org.lang.scala.algorithm.tree.binary

/**
 * 	This is a stand-alone object to implement binary trees
 *  -- A binary tree can be represented by an array 
 *  
 *  Features of binary tree (for 0-based index):
 *  -- From index perspective:
 *     -- For a parent node i: its left child index is (2i + 1) and right child index is (2i + 2)
 *     -- For a child node i: its parent index is floor((i - 1) / 2)
 *  -- From size perspective:
 *     -- For a tree (or array) with size N, only the nodes indexed from 0 to floor(N / 2 - 1) have children
 *     
 *  Features of binary tree (for any start index)
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
 *  Using these features can:
 *  -- Achieve auto-indexed for tree nodes
 *  -- Handle sub-array in-place
 *  -- etc.
 * 
 * 	@author VinceYuan
 */
object BinaryTree {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    buildBinaryTree()
  }
  
  /**
   * 	This is a method to build a binary tree
   * 
   * 	The binary tree is shown below:
   *                
   *               23
   *                |
   *         35 ---------- 12
   *          |             |
   *     65 ------ 31  43 ----- 57   
   *   
   *  This tree is also a full binary tree
   */
  private def buildBinaryTree(): Unit = {
    
    /*	Construct a complete binary tree	*/
    val node1 = new Node("node1", 23)
    val node2 = new Node("node2", 35, node1, true)
    val node3 = new Node("node3", 12, node1, false)
    val node4 = new Node("node4", 65, node2, true)
    val node5 = new Node("node5", 31, node2, false)
    val node6 = new Node("node6", 43, node3, true)
    val node7 = new Node("node7", 57, node3, false)
    
    /*	Put the binary tree nodes into an array	 */
    val arr = Array(node1, node2, node3, node4, node5, node6, node7)
    println(s"Array that store tree nodes:\n${arr.mkString("\n")}")
  }
}
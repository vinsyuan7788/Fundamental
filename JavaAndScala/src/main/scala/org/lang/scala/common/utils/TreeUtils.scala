package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contains tree utility methods
 * 
 * 	@author VinceYuan
 */
object TreeUtils {
  
  /**
   * 	This is a method to expose a binary tree for the given array
   *  
   *  For example: for an array [5, 1, 8, 4, 6, 7, 9, 2], it is organized as below:
   *  
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--
   * 
   * 	In this case, the binary tree would be:
   *  -- parent: 5; leftChild: 1; rightChild: 8
   *  -- parent: 1; leftChild: 4; rightChild: 6
   *  -- parent: 8; leftChild: 7; rightChild: 9
   *  -- parent: 4; leftChild: 2; rightChild: null
   */
  def exposeBinaryTree[T](arr: Array[T]): List[String] = {
    exposeBinaryTree(arr, 0, arr.length - 1)      
  }
  
  /**
   * 	This is a method to expose a binary tree for the (sub-array of) given array
   */
  def exposeBinaryTree[T](arr: Array[T], startIdx: Int, endIdx: Int): List[String] = {
    
    /*	Check sub array indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Initialize a list to contain tree information	 */
    var list = List[String]()
    
    /*	Get the median index of the array	 */
    val arrLen = endIdx - startIdx + 1
    val medianIdx = math.floor(arrLen / 2 - 1 + startIdx).toInt
    
    /*	Expose the tree structure for the array	 */
    for (parentIdx <- startIdx to medianIdx) {
    
      /*	Get the indices of left child and right child	 */
      val leftChildIdx = parentIdx * 2 + 1 - startIdx
      val rightChildIdx = parentIdx * 2 + 2 - startIdx
      
      /*	Get the parent, left child and right child (if there is any)	*/
      val parent = arr(parentIdx)
      val leftChild = if (leftChildIdx <= endIdx) arr(leftChildIdx) else null
      val rightChild = if (rightChildIdx <= endIdx) arr(rightChildIdx) else null
      
      /*	Add the binary tree	information  */
      list = list :+ s"parent: ${parent}; leftChild: ${leftChild}; rightChild: ${rightChild}"
    }
    
    /*	Return the list	 */
    list
  }
  
  /**
   * 	This is a method to predicate if a node with the given index in an array has children
   * 
   *  For example: for an array [5, 1, 8, 4, 6, 7, 9, 2], it is organized as below:
   *  
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--
   * 
   * 	In this case, the nodes that have children would be:
   *  -- array(0) to array(3), namely 5, 1, 8, 4
   */
  def ifNodeHasChildren[T](arr: Array[T], index: Int): Boolean = {
    ifNodeHasChildren(arr, index, 0, arr.length - 1)   
  }
  
  /**
   * 	This is a method to predicate if a node with the given index in (the sub-array of) an array has children
   */
  def ifNodeHasChildren[T](arr: Array[T], index: Int, startIdx: Int, endIdx: Int): Boolean = {

    /*	Check sub array indices	 */
    ExceptionUtils.checkSubArrayIndices(arr, startIdx, endIdx)
    
    /*	Predicate if a node has children	*/
    val treeSize = endIdx - startIdx + 1
    val medianIdx = math.floor(treeSize / 2 - 1 + startIdx)
    if (index >= startIdx && index <= medianIdx) true else false
  }
  
  /**
   * 	This is a method to collect all the nodes that have children in the given array
   * 
   *  For example: for an array [5, 1, 8, 4, 6, 7, 9, 2], it is organized as below:
   *  
   *          5
   *          |
   *      1 ----- 8
   *      |       |
   *    4---6   7---9
   *    |
   * 	2--
   * 
   * 	In this case, the nodes that have children would be:
   *  -- array(0) to array(3), namely 5, 1, 8, 4
   */
  def getNodesWithChildren[T](arr: Array[T]): List[T] = {
    getNodesWithChildren(arr: Array[T], 0, arr.length - 1)
  }
  
  /**
   * 	This is a method to collect all the nodes that have children in the (sub-array of) given array
   */
  def getNodesWithChildren[T](arr: Array[T], startIdx: Int, endIdx: Int): List[T] = {
   
    /*	Initialize a list to contain the nodes with children	*/
    var list = List[T]()
    
    /*	Collect the nodes with children	 */
    val treeSize = endIdx - startIdx + 1
    val medianIdx = math.floor(treeSize / 2 - 1 + startIdx).toInt
    for (index <- startIdx to medianIdx) {
      list = list :+ arr(index)
    }
    
    /*	Return the list	 */
    list
  }
}
package org.lang.scala.algorithm.search.dfs

import scala.collection.mutable.Stack

/**
 * 	This is a stand-alone object to implement DFS (Depth First Search)
 * 	-- The difference between DFS and BFS is using a stack instead of a queue
 *  -- Time complexity: O(|V| + |E|) for the worst
 *     -- O(|E|) can be O(1) to O(|V|^2): O(1) for only 1 edge between vertices and O(|V|^2) for |V|^2 edges (2 in-between and 2 self-directed)
 *        -- E.g., for vertex A and B, 
 *           -- O(1) can be: A ---> B or A <--- B, 
 *           -- O(|V|^2) is O(4), namely: A ---> A, A ---> B, B ---> A, B ---> B 
 * 
 * 	@author VinceYuan
 */
object DepthFirstSearch {
  
  /**
   * 	This is a method to implement BFS (Breadth First Search)
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
  private def dfs(arr: Array[Int], elem: Int): Int = {
    
    /*	Initialize a stack to store the index that will be processed immediately	*/
    val stack = Stack[Int]()
    stack.push(0)
    
    /*	Depth first search the element and return its index if found	*/
    val endIdx = arr.length - 1
    while (stack.size != 0) {
      val currentIdx = stack.pop()
      /*	If the element with current index equals target element, return its index	 */
      if (arr(currentIdx) == elem) {
        return currentIdx
      /*  Otherwise depth first search the next indices to be processed	 */
      } else {
        val medianIdx = math.floor(arr.length / 2 - 1).toInt
        if (currentIdx >= 0 && currentIdx <= medianIdx) {
          val leftChildIdx = 2 * currentIdx + 1
          val rightChildIdx = 2 * currentIdx + 2
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
    
    /*	Return -1 if the element is not found	 */
    -1
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    
    var elem = 6  
    var index = dfs(arr, elem)
    println(s"The index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
    
    elem = 11  
    index = dfs(arr, elem)
    println(s"The index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
  }
}
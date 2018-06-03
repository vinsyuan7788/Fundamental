package org.lang.scala.algorithm.search.bfs

import scala.collection.mutable.Queue

/**
 * 	This is a stand-alone object to implement BFS (Breadth First Search)
 * 	-- The difference between BFS and DFS is using a queue instead of a stack
 *  -- Time complexity: O(|V| + |E|) for the worst
 *     -- O(|E|) can be O(1) to O(|V|^2): O(1) for only 1 edge between vertices and O(|V|^2) for |V|^2 edges (2 in-between and 2 self-directed)
 *        -- E.g., for vertex A and B, 
 *           -- O(1) can be: A ---> B or A <--- B, 
 *           -- O(|V|^2) is O(4), namely: A ---> A, A ---> B, B ---> A, B ---> B 
 *            
 * 	@author VinceYuan
 */
object BreadthFirstSearch {
  
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
  private def bfs(arr: Array[Int], elem: Int): Int = {
    
    /*	Initialize a queue to store the index that will be processed immediately	*/
    val queue = Queue[Int]()
    queue.enqueue(0)
    
    /*	Breadth first search the element and return its index if found	*/
    val endIdx = arr.length - 1
    while (queue.size != 0) {
      val currentIdx = queue.dequeue()
      /*	If the element with current index equals target element, return its index	 */
      if (arr(currentIdx) == elem) {
        return currentIdx
      /*  Otherwise breadth first search the next indices to be processed	 */
      } else {
        val medianIdx = math.floor(arr.length / 2 - 1).toInt
        if (currentIdx >= 0 && currentIdx <= medianIdx) {
          val leftChildIdx = 2 * currentIdx + 1
          val rightChildIdx = 2 * currentIdx + 2
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
    
    /*	Return -1 if the element is not found	 */
    -1
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(5, 1, 8, 4, 6, 7, 9, 2)
    
    var elem = 6  
    var index = bfs(arr, elem)
    println(s"The index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
    
    elem = 11  
    index = bfs(arr, elem)
    println(s"The index of ${elem} in [${arr.mkString(", ")}]:\n${index}")
  }
}
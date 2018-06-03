package org.lang.scala.algorithm.search.linear

/**
 * 	This is a stand-alone object to implement linear (or sequential) search
 *  -- Time complexity: O(1) for best and O(n) for the worst
 *     -- Hence average: O(n)
 *     
 * 	@author VinceYuan
 */
object LinearSearch {
  
  /**
   * 	This is a method to implement linear search
   */
  private def linearSearch(arr: Array[Int], elem: Int): Int = {
    
    /*	Sequential search the element and return its index if found	 */
    for (index <- 0 until arr.length) {
      if (arr(index) == elem) return index
    }
    
    /*	Return -1 if the element is not found	*/
    return - 1
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    
    val arr = Array(4, 1, 6, 3, 9, 5, 7)
    
    var elem = 5    
    var index = linearSearch(arr, elem)
    println(s"The index of element ${elem}:\n${index}")
    
    elem = 11
    index = linearSearch(arr, elem)
    println(s"The index of element ${elem}:\n${index}")
  }
}
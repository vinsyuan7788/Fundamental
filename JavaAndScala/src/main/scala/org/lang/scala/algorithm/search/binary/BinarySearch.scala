package org.lang.scala.algorithm.search.binary

/**
 * 	This is a stand-alone object to implement binary search algorithm
 *  -- Time complexity: O(1) for best and O(log n) for the worst
 *     -- Hence average: O(log n)
 * 
 * 	@author VinceYuan
 */
object BinarySearch {
 
  /**
   * 	This is a method to implement binary search algorithm with traversal (or iteration)
   */
  private def binarySearch(srtArr: Array[Int], isAsc: Boolean, elem: Int): Int = {
    
    /*	Initialize low index, high index and round counter	*/
    var lowIdx = 0
    var highIdx = srtArr.length - 1
    
    /*	Binary search the element and return its index if found	 */
    if (isAsc) {
      /*	While low index <= high index	 */
      while (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        /************************* Core in binary search algorithm *******************************/
        if (elem == srtArr(midIdx)) return midIdx
        if (elem > srtArr(midIdx)) lowIdx = midIdx + 1
        if (elem < srtArr(midIdx)) highIdx = midIdx - 1
        /*****************************************************************************************/
      }      
    } else {
      /*	While low index <= high index	 */
      while (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        /************************* Core in binary search algorithm *******************************/
        if (elem == srtArr(midIdx)) return midIdx
        if (elem > srtArr(midIdx)) highIdx = midIdx - 1
        if (elem < srtArr(midIdx)) lowIdx = midIdx + 1
        /*****************************************************************************************/  
      }
    }

    /*	Return -1 if the element is not found	*/
    return -1
  }
  
  /**
   * 	This is a method to implement binary search algorithm with recursion
   */
  private def binarySearchRecursively(srtArr: Array[Int], isAsc: Boolean, elem: Int)(lowIdx: Int, highIdx: Int)(round: Int): Int = {
    
    /*	If the array is sorted in ascending order	 */
    if (isAsc) {
      /*	If low index <= high index	*/
      if (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        /****************************** Core in binary search ************************************/
        if (elem > srtArr(midIdx)) {
          binarySearchRecursively(srtArr, true, elem)(midIdx + 1, highIdx)(round + 1)
        } else if (elem < srtArr(midIdx)) {
          binarySearchRecursively(srtArr, true, elem)(lowIdx, midIdx - 1)(round + 1)
        } else {
          midIdx
        }
        /*****************************************************************************************/
      /*	If low index > high index	 */
      } else {
        -1
      }
    /*	If the array is sorted in descending order	 */
    } else {
      /*	If low index <= high index	*/
      if (lowIdx <= highIdx) {
        val midIdx = math.floor((highIdx - lowIdx) / 2 + lowIdx).toInt
        /****************************** Core in binary search ************************************/
        if (elem > srtArr(midIdx)) {
          binarySearchRecursively(srtArr, true, elem)(midIdx + 1, highIdx)(round + 1)
        } else if (elem < srtArr(midIdx)) {
          binarySearchRecursively(srtArr, true, elem)(lowIdx, midIdx - 1)(round + 1)
        } else {
          midIdx
        }
        /*****************************************************************************************/
      /*	If low index > high index	 */
      } else {
        -1
      }
    }
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testBinarySearch()
  }
  
  /**
   * 	This is a method to test binary search
   */
  private def testBinarySearch(): Unit = {
    
    println("Here demonstrates binary search on the arrays that contain ODD number of elements:")
    var srtArr = Array(1, 2, 3, 5, 6, 7, 8, 10, 12)
    var elem = 10
    var elemIdx = binarySearch(srtArr, true, elem)
    println(s"The index of $elem is: $elemIdx")
    println("If using binary search recursively can get the same result:")
    println(elemIdx == binarySearchRecursively(srtArr, true, elem)(0, srtArr.length - 1)(0))
    
    println("\nHere demonstrates binary search on the arrays that contain EVEN number of elements:")
    srtArr = Array(0, 5, 13, 19, 22, 41, 55, 68, 72, 81)
    elem = 55
    elemIdx = binarySearch(srtArr, true, elem)
    println(s"The index of $elem is: $elemIdx")
    println("If using binary search recursively can get the same result:")
    println(elemIdx == binarySearchRecursively(srtArr, true, elem)(0, srtArr.length - 1)(0))
    
    println("\nHere demonstrates binary search on the arrays that fail to find the element:")
    elem = 100
    elemIdx = binarySearch(srtArr, true, elem)
    println(s"The index of $elem is: $elemIdx")
    println("If using binary search recursively can get the same result:")
    println(elemIdx == binarySearchRecursively(srtArr, true, elem)(0, srtArr.length - 1)(0))
    elem = -5
    elemIdx = binarySearch(srtArr, true, elem)
    println(s"The index of $elem is: $elemIdx")
    println("If using binary search recursively can get the same result:")
    println(elemIdx == binarySearchRecursively(srtArr, true, elem)(0, srtArr.length - 1)(0))
  }
}
package org.lang.scala.conclusion.oop.method.recursion

/**
 * 	This is a stand-alone object to test recursion
 * 	-- Recursion is an extended version of traversal or iteration
 *     -- Recursion is applied on method-level
 *     -- Iteration is applied on statement-level
 *  
 *  Recursion v.s. traversal (or iteration)
 *  -- Recursion is more resource-consuming, hence if traversal (or iteration) is always preferred if a problem can be resolved by both ways
 *  
 *  When to use recursion:
 *  -- If a problem can be broken into a smaller problem, and the resolution logics is still identical as the original problem
 *  -- If a problem needs to resolved with recursively and it cannot be solved by traversal (or iteration)
 * 
 * 	@author VinceYuan
 */
object TestRecursion {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testBinarySearchRecursively()
    println()
    testFactorialRecursively()
  }
  
  /**
   * 	This is a method to test binary search recursively
   */
  private def testBinarySearchRecursively(): Unit = {
    
    println("Here tests binary search recursively on the arrays that contain ODD number of elements:")
    var srtArr = Array(1, 2, 3, 5, 6, 7, 8, 10, 12)
    var elem = 10
    val lowIdx = 0
    var highIdx = srtArr.length - 1
    val round = 0
    binarySearchRecursively(srtArr, elem)(lowIdx, highIdx)(round)
    
    println("\nHere tests binary search recursively on the arrays that contain EVEN number of elements:")
    srtArr = Array(0, 5, 13, 19, 22, 41, 55, 68, 72, 81)
    elem = 55
    binarySearchRecursively(srtArr, elem)(lowIdx, highIdx)(round)
    
    println("\nHere tests binary search recursively on the arrays that fail to find the element:")
    elem = 100
    binarySearchRecursively(srtArr, elem)(lowIdx, highIdx)(round)
    elem = -5
    binarySearchRecursively(srtArr, elem)(lowIdx, highIdx)(round)
  }
  
  /**
   * 	This is a method to test factorial recursively
   */
  private def testFactorialRecursively(): Unit = {
  
    for (i <- 1 to 10) {
      val result = factorialRecursively(i, 1)
      println(s"Factorial of $i is: $result")
    }
  }
  
  /**
   * 	This is a method to implement binary search recursively
   */
  private def binarySearchRecursively(srtArr: Array[Int], elem: Int)(lowIdx: Int, highIdx: Int)(round: Int): Unit = {
    
    /*	If low index <= high index	*/
    if (lowIdx <= highIdx) {
      val midIdx = (lowIdx + highIdx) / 2
      println(s"Round $round: [lowIdx: $lowIdx, midIdx: $midIdx, highIdx: $highIdx]")
      if (elem > srtArr(midIdx)) {
        binarySearchRecursively(srtArr, elem)(midIdx + 1, highIdx)(round + 1)
      } else if (elem < srtArr(midIdx)) {
        binarySearchRecursively(srtArr, elem)(lowIdx, midIdx - 1)(round + 1)
      } else {
        println(s"The index of $elem is: $midIdx")
      }      
    /*	If low index > high index	 */
    } else {
       println(s"The index of $elem is: -1")
    }
  }
  
  /**
   * 	This is a method to compute factorial recursively
   */
  private def factorialRecursively(num: Int, result: Int): Int = {    
    if(num <= 1) result  
    else factorialRecursively(num - 1, result * num)   
  }
}
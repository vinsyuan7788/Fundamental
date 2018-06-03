package org.lang.scala.conclusion.statement.traversal

/**
 * 	This is a stand-alone object to test traversal
 *  -- Regular for loop
 *  -- Conditional for loop
 *  
 * 	@author VinceYuan
 */
object TestTraversal {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testTraversal()
  }
  
  /**
   * 	This is a method to test traversal
   */
  private def testTraversal(): Unit = {
    
    /*	Initialize a string builder	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    
    /*	Test regular for loop	 */
    println("Regular for loop:")
    for (i <- -5 to 5) {
      stringBuilder.append(i + ", ")
    }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
    stringBuilder.clear()
    for (i <- 5.5 to -4.5 by -3) {
      stringBuilder.append(i + ", ")
    }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
    
    /*	Test conditional for loop	 */
    stringBuilder.clear();
    println("\nConditional for loop:")
    for (i <- 1 to 3; j <- 1 to 3 if i != j) {
      stringBuilder.append(1 * i * j + ", ")
    }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
    
    /*	Test functional operation for loop	 */
    stringBuilder.clear();
    println("\nFunctional operation for loop:")
    1.to(10).map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
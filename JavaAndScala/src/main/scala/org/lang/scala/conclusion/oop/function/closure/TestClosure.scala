package org.lang.scala.conclusion.oop.function.closure

/**
 * 	This is a stand-alone object to test closure
 *  
 *  Closure:
 *  -- inner scope can manipulate the variable values in the outer (or enclosing) scope
 *     -- Can be implemented by high-order functions or methods that return high-order functions
 *  
 *  @author VinceYuan
 */
object TestClosure {
  
  /*	Necessary instance variables	*/
  private val closure1 = (x: Int) => {
    val a = x
    (y: Long) => {
      val b = y
      (z: Float) => {
        a + b + z        // Here can manipulates the value of "a" and "b" in outer scope
      }
    }
  }
  private def closure2(x: Int) = (y: Long) => {
    val a = x
    val b = y
    (z: Float) => {
      a + b + z          // Here can manipulates the value of "a" and "b" in outer scope
    }
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests closure:")
    println(closure1(100)(50)(10))
    println(closure2(100)(50)(10))
  }
}
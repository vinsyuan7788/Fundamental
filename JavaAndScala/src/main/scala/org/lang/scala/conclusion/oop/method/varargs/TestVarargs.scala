package org.lang.scala.conclusion.oop.method.varargs

/**
 * 	This is a method to test varargs (variable arguments)
 *  -- Varargs MUST be put at the END of parameters (or parameter list)
 *  -- Varargs is allowed only ONCE on pararmeters (or parameter list)
 *  -- "_*" is NOT allowed on multiple complex data structures
 *     -- E.g., multiple arrays, lists, etc.
 *  -- When varargs is passed into a method, it becomes an instance (or a whoel argument) "WrappedArray(...)"
 *     -- If this instance need to be passed into another varargs, use "_*": refer to "TestVarargsChain.scala"
 * 
 * 	@author VinceYuan
 */
object TestVarargs {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testVarargs()
  }
  
  /**
   * 	This is a method to test varargs
   */
  private def testVarargs(): Unit = {
    
    /*	Test varargs basics	 */
    passVarargs(1, "ABC", 'U', false)
    passVarargs(Array(1, "ABC", 'U', false): _*)
    passVarargs(List(1, "ABC", 'U', false): _*)
    passVarargs(1, "ABC", 'U', false, 2, "CDE", 'K', true)
    passVarargs(Array(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    passVarargs(List(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    passVarargs(Array(1, "ABC", 'U', false).toBuffer, Array(2, "CDE", 'K', true).toBuffer)
    passVarargs(List(1, "ABC", 'U', false), List(2, "DEF", 'K', true))
    // "_*" is not allowed on multiple complex data structures
//    passVarargs(Array(1, "ABC", 'U', false), Array(2, "CDE", 'K', true): _*)    
//    passVarargs(List(1, "ABC", 'U', false), List(2, "DEF", 'K', true): _*)
  }
  
  /**
   * 	Here are the methods that input varargs
   */
  private def passVarargs(x: Any*) = {
    println("Varargs: " + x) 
    println("Varargs length: " + x.length + "\n")
  }
}
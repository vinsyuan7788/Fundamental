package org.lang.scala.conclusion.datatype

/**
 * 	This is a stand-alone object to test automatic type deduction
 *  -- It works on every object in Scala
 * 
 *  Hence no need to explicitly specify the data type unless necessary
 *  -- Very useful especially the data type is very complex or unknown
 *     -- E.g., currying function or method
 *  
 * 	@author VinceYuan
 */
object TestTypeDeduction {
  
  /**
   * 	This is a main method
   */
  def main(args: Array[String]): Unit = {
    println("Here tests type deduction of variables:")
    testVariableType()
    println("\nHere tests type deduction of method return type:")
    print(testMethodReturnType(3, 4).getClass())
  }
  
   /**
   * 	This is a method to test variable type auto-deduction
   *  -- If the variable type is not explicitly specified, it will be auto-deducted
   */
  private def testVariableType(): Unit = {
    
    /*	Variable declaration and initialization	 */
    val i = 0
    val j = if (i > 0) 1 else -1;      // Block expression
    val k = if (i > 0) {               // Block expression
      1
    } else {
      "error"
    }
    val l = {                          // Block expression
      if (i > 0) {
        1
      }
    }
    
    /*	Output information	*/
    println("if " + i + " is an integer: " + i.isInstanceOf[Int])
    println("if " + j + " is an integer: " + j.isInstanceOf[Int])
    println("if " + k + " is an integer: " + k.isInstanceOf[Int])
    println("if " + l + " is an integer: " + l.isInstanceOf[Int])
  }
  
  /**
   * 	This is a method to test auto-deduct method return type
   * -- If the method return type is not explicitly specified, it will be auto-deducted
   *    -- In this case, no need to use "return" in method body
   */
  private def testMethodReturnType(x: Int, y: Int) = {
    x * y
  }
}
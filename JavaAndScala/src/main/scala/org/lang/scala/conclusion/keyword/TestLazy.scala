package org.lang.scala.conclusion.keyword

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test "lazy" keyword
 *  -- "lazy" variables are executed only when they are accessed the first time
 *  
 *  @author VinceYuan
 */
object TestLazy {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests without \"lazy\" keyword:")
    testWithoutLazy()
    println("\nHere tests \"lazy\" keyword:")
    testLazy()
  }
  
  /**
   * 	This is a method to test without "lazy" keyword (i.e., regular situation)
   */
  private def testWithoutLazy(): Unit = {
    
    val x = { println("x will be executed right away"); 15}
    val y = { println("y will be executed right away"); 150} 
    
    println(s"x has been executed, and its value is ${x}")
    println(s"y has been executed, and its value is ${y}")  
  }
  
  /**
   * 	This is a method to test "lazy" keyword
   */
  private def testLazy(): Unit = {
    
    val x = { println("x will be executed right away"); 15}
    lazy val y = { println("y will be executed right away"); 150}    // (1): There will be no output here, since y will not be executed until accessed
    
    println(s"x has been executed, and its value is ${x}")
    println(s"y has been executed, and its value is ${y}")           // (2): There will be output here since y is accessed here (by ${y}) and hence assigned the value. Since assigned value, (1) will be output first before (2)
  }
}
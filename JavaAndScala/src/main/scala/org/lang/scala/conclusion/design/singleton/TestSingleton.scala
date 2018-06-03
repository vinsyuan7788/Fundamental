package org.lang.scala.conclusion.design.singleton

import org.lang.scala.conclusion.design.singleton.objects.Cart
import org.lang.scala.conclusion.design.singleton.design.Student

/**
 * 	This is a stand-alone object to test (lazy) singleton pattern
 * 
 * 	@author VinceYuan
 */
object TestSingleton {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests singleton with \"object\" keyword:")
    testSingletonWithObjectKeyword()
    println("\nHere tests singleton with design:")
    testSingletonWithDesign()
  }
  
  /**
   * 	This is a method to test (lazy) singleton with "object" keyword
   */
  private def testSingletonWithObjectKeyword(): Unit = {
    
    val cart1 = Cart
    val cart2 = Cart
    println(cart1 == cart2)
  }
  
  /**
   * 	This is a method to test (lazy) singleton with design
   */
  private def testSingletonWithDesign(): Unit = {
    
    val student1 = Student.getInstance()
    val student2 = Student.getInstance()
    println(student1 == student2)
  }
}
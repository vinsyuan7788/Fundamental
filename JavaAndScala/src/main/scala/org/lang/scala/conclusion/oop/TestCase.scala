package org.lang.scala.conclusion.oop

import java.util.UUID

import org.lang.scala.conclusion.oop.cases.Customer
import org.lang.scala.conclusion.oop.cases.Student

/**
 * 	This is a stand-alone object to test case class and case object
 * 	-- Case class is conceptually equivalent to Java bean in Java
 *  -- Instantiation of case class and case object does not need "new" keyword
 *     -- For case class, if using "new" keyword, it will work as well (since case class is still a class)
 *  
 * 	@author VinceYuan
 */
object TestCase {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests case class:")
    testCaseClass()
    println("\nHere tests case object:")
    testCaseObject()
  }
  
  /**
   * 	This is a method to test case class
   */
  private def testCaseClass(): Unit = {
    
    /*	Instantiate a case class	*/
    val student = Student(UUID.randomUUID().toString(), "Vince", 'M', 27, 98.55)
    
    /*	Invoke methods	*/
    student.eat()
    student.sleep()
    student.work { x => x + " is working..." }
    student.study { x => x + " is studying..." }
  }
  
  /**
   * 	This is a method to test case object
   */
  private def testCaseObject(): Unit = {
    
    /*	Instantiate a case object	 */
    val customer = Customer
    
     /*	Invoke methods	*/
    customer.eat()
    customer.sleep()
    customer.work { x => x + " is working..." }
    customer.study { x => x + " is studying..." }   
  }
}
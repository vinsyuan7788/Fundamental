package org.lang.scala.conclusion.oop

import org.lang.scala.conclusion.oop.objects.Student

/**
 * 	This is a stand-alone object to test object
 * 	-- There is 1 way to instantiate an object (i.e., lazy singleton): 
 *     -- Directly use the object, e.g., Student
 *  -- To invoke "apply" function when using the object: 
 *     -- Using "()" or ".apply()", e.g., "Student()" or "Student.apply()"
 *  -- If there is a new instance created from an object
 *     -- The new instance will directly cover the old instance
 *        -- To ensure there is always only ONE instance in JVM
 * 
 * 	@author VinceYuan
 */
object TestObject {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testObject()
  }
  
  /**
   * 	This is a method to test object
   */
  private def testObject(): Unit = {
    
    /*	Test "apply" and see if new instance covers old instance	*/
    println("Here demonstrates new instance will cover old instance:")
    val vince = Student
    println(vince)
    val violet = Student("Violet")
    println(vince)
    println(violet)
    val kelly = Student("123456", "Kelly")
    println(vince)
    println(violet)
    println(kelly) 
    
    /*	See if object is singleton	 */
    println("\nHere demonstrates object is singleton:")
    println(vince == violet)
    println(violet == kelly)
    println(vince == kelly)
    
    /*	Invoke the methods	*/
    println("\nHere invokes methods in the object:")
    vince.eat()
    vince.sleep()
    vince.work { x => x + " is working..." }
    vince.study { x => x + " is studying..." }
  }
}
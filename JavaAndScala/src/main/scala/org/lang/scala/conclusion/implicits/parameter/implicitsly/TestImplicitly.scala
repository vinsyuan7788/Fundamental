package org.lang.scala.conclusion.implicits.parameter.implicitsly

import org.lang.scala.conclusion.implicits.common.parameter.classes.Calculator

/**
 * 	This is a stand-alone object to test "implicitly"
 *  -- The definition of implicitly since Scala 2.8 is: def implicitly[T](implicit e: T): T = e
 *      -- It is commonly used to check if there is an implicit value of type T available and return it if so is the case
 * 
 * 	@author VinceYuan
 */
object TestImplicitly {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests implicitly from Scala predefined variables, functions, methods or objects:")
    testImplicitlyFromPredef()
    println("\nHere tests implicitly from custom variables, functions, methods or objects:")
    testImplicitlyFromCustom()
  }
  
  /**
   * 	This is a method to test implicitly from Scala predefined variables, functions, methods or objects
   */
  private def testImplicitlyFromPredef(): Unit = {
    
    val ord = implicitly[Ordering[Int]]
    println(ord.gt(3, 1))
  }
    
  /**
   * 	This is a method to test implicitly from custom variables, functions, methods or objects
   */
  private def testImplicitlyFromCustom(): Unit = {
  
    /*	Define implicit variables  */
    implicit val str = "Hello Twice"
    implicit val func = (str: String) => println(str)
    implicit def meth(int: Int) = println(int) 
    implicit object IntCalculator extends Calculator[Int] {
      def add(x: Int, y: Int) = x + y
    }   
    
    /*	Get the implicit variables for String type if there is any available	*/
    val string = implicitly[String]
    println(string)
    
    /*	Get the implicit functions for function type if there is any available	*/
    val function = implicitly[String => Unit]
    function("Hello Lovelyz")
    
    /*	Get the implicit methods for function type if there is any available	*/
    val method = implicitly[Int => Unit]
    method(123456)
    
    /*	Get the implicit object for type argument if there is any available	 */
    val intCalculator = implicitly[Calculator[Int]]
    println(intCalculator.add(1, 2))
  }
}
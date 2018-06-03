package org.lang.scala.conclusion.statement.matching

import scala.reflect.runtime.universe
import scala.util.Random

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.statement.matching.cases.classes.DropTask
import org.lang.scala.conclusion.statement.matching.cases.classes.SubmitTask
import org.lang.scala.conclusion.statement.matching.cases.objects.CheckTimeOutTask

/**
 * 	This is a stand-alone object to test pattern matching
 *  -- Mostly pattern matching is used with case class or case object
 *  -- Pattern matching is for VALUE matching, NOT type matching
 *     -- Another way for value matching (typically input value matching) is partial function 
 *        -- Refers to "org/scala/conclusion/oop/function/partial/TestPartialFunction.scala"
 *  -- Pattern matching is an equivalence and a super-set of "switch...case..." statement in other programming language (Java, C#, C/C++, JavaScript, etc.)
 * 
 * 	@author VinceYuan
 */
object TestPatternMatching {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testPatternMatching()
  }
  
  /**
   * 	This is a method to test pattern matching
   */
  private def testPatternMatching(): Unit = {
    
    /*	Pattern matching by value	 */
    println("Here demonstrates pattern matching by value:")
    val arr1 = Array("ABC", 123, true, "Whatever")
    arr1.foreach { elem => {
      elem match {
        case "ABC" => println("Hello ABC")
        case 123 => println("Hello 123")
        case true => println("Hello true")
        case _ => println("Hello whatever")      // Moving this case upwards will cause a warning
      }
    } }
    
    /*	Pattern matching by data type	*/
    println("\nHere demonstrates pattern matching by data type:")
    val arr2 = Array("123", 123, '1', true)
    arr2.foreach { elem => {
      elem match {
        case _: String => println(elem + " is a " + ReflectionUtils.getRuntimeType(elem.asInstanceOf[String]))
        case _: Int => println(elem + " is a " + ReflectionUtils.getRuntimeType(elem.asInstanceOf[Int]))
        case _: Char => println(elem + " is a " + ReflectionUtils.getRuntimeType(elem.asInstanceOf[Char]))
        case _: Boolean => println(elem + " is a " + ReflectionUtils.getRuntimeType(elem.asInstanceOf[Boolean]))
      }
    } }
    
    /*	Pattern matching by data structure	*/
    println("\nHere demonstrates pattern matching by data structure:")
    val arr3 = Array[Any]((1, 2, 3), (3, 4, 5), ("a", 2), (true, 1, '1', "1"))
    arr3.foreach { tuple => {
      tuple match {
        case (1, x, y) => println("Hello tuple3 (1, " + x + ", " + y + ")")
        case (_, z, 5) => println("Hello tuple3 (whatever, " + z + ", 5)")
        case (_, _) => println("Hello tuples2 whatever")
        case _ => println("Hello whatever tuple")
      }
    } }
    val arr4 = Array[List[Any]](List(3, 2, 1), List("123", 123, true), List('A', false, 321), List('A', false))
    arr4.foreach { list => {
      list match {
        case 3 :: 2 :: 1 :: Nil => println("Hello list(3, 2, 1)")
        case Nil :+ x :+ y :+ z => println("Hello 3-element list, whose element is " + x + ", " + y + ", " + z)
        case _ => println("Hello whatever list")
      }
    } }
    
    /*	Pattern matching by condition and range	 */
    println("\nHere demonstrates pattern matching by condition and range:")
    val arr5 = Array(1, 5, 13, 18, 24, 28)
    arr5.foreach { int => {
      int match {
        case int if (0 until 10 contains int) => println(s"$int is in [0, 10)")
        case int if (10 until 20 contains int) => println(s"$int is in [10, 20)") 
        case int if (20 until 30 contains int) => println(s"$int is in [20, 30)") 
        case _ => Unit    // Do nothing if the integer is another value
      }
    } }
    
    /*	Pattern matching by case class or case object	 */
    println("\nHere demonstrates pattern matching by case class or case object:")
    val arr6 = Array[Any](SubmitTask("12345", "FirstTask"), new SubmitTask("54321", "SecondTask"), CheckTimeOutTask, DropTask("67890", "ThirdTask"))
    arr6.foreach { caseClass => {
      caseClass match {
        case SubmitTask(id, name) => println("If the task is submitted: " + SubmitTask(id, name).isSubmitted + ". Task id: " + id + ", name: " + name + ".")
        case CheckTimeOutTask => println("If the task is timeout: " + CheckTimeOutTask.isTimeOut)
        case _ => println("Hello whatever case")
      }
    } }
  }
}
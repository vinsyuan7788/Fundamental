package org.lang.scala.conclusion.statement.predication

/**
 * 	This is a stand-alone object to test predication
 * 
 * 	@author VinceYuan
 */
object TestPredication {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests predicate for assignment:")
    testPredicateForValueAssignment(args)
    testPredicateForValueAssignment(Array("localhost"))
    println("\nHere tests if-else-if predicate statement:")
    testIfElseIf()
  }
  
  /**
   * 	This is a method to test value assignment through predicate statement
   *  -- It is equivalent to "predicate ? value1 : value2" in Java 
   */
  private def testPredicateForValueAssignment(args: Array[String]) = {
    
    // The Java equivalence is: String address = args.length != 0 ? args[0].toString() : "127.0.0.1"
    val address = if (args.length != 0 ) args(0).toString() else "127.0.0.1"
    println(s"Address: ${address}")
  }
  
  /**
   * 	This is a method to test if-else-if predication
   */
  private def testIfElseIf() = {
    
    val string = "I Love You"
    
    if (string.equals("I Love You")) {
      println(string)
    } else if (string.length().equals(10)) {
      println(string.length())
    }
  }
}
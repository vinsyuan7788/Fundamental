package org.lang.scala.conclusion.datatype

import org.lang.scala.conclusion.datatype.common.Person

/**
 * 	This is a stand-alone object to test type comparison
 *  -- In Scala, String-type behaves exactly the same as other primitive types
 *     -- Unlike in Java, String-type behaves differently from other primitive types on comparison using "==" (comparing both reference and value)
 *     
 *  @author VinceYuan
 */
object TestTypeComparison {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests primitive type comparison:")
    testPrimitiveTypeComparison()
    println("\nHere test collection type comparison:")
    testCollectionTypeComparison()
    println("\nHere tests object type comparison:")
    testObjectTypeComparison()
  }
  
  /**
   * 	This is a method to test primitive type comparison
   *  -- Collection type comparison behaves the same as primitive type comparison
   */
  private def testPrimitiveTypeComparison(): Unit = {
    
    /*	Int-type comparison	 */
    val intA = 1
    val intB = new Integer(1).toInt
    println("Int-type comparison:")
    println(s"${intA == intB}; ${intA.equals(intB)}")  // true; true
    
    /*	String-type comparison	*/
    val strA = "Hello Scala"
    val strB = "Hello Scala"
    println("String-type comparison:")
    println(s"${strA == strB}; ${strA.equals(strB)}")  // true; true
    val strC = "Hello Scala"
    val strD = new String("Hello Scala")
    println("String-type comparison:")
    println(s"${strC == strD}; ${strC.equals(strD)}")  // true; true
  }
  
  /**
   * 	This is a method to test collection type comparison
   */
  private def testCollectionTypeComparison(): Unit = {
    
    /*	List comparison	 */
    val listA = List(1, 2, 3, 4, 5)
    val listB = List(1, 2, 3, 4, 5)
    println("List comparison:")
    println(s"${listA == listB}; ${listA.equals(listB)}")  // true; true
  }
  
  /**
   * 	This is a method to test object type comparison
   */
  private def testObjectTypeComparison(): Unit = {
    
    val personA = new Person("ABCD", "Vince", 27)
    val personB = new Person("ABCD", "Vince", 27)
    println("Custom-type comparison:")
    println(s"${personA == personB}; ${personA.equals(personB)}")  // false; false
  }
}
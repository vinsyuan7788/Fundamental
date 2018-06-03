package org.lang.scala.conclusion.datatype

import java.util.UUID

import org.lang.scala.conclusion.datatype.common.Person

/**
 * 	This is a stand-alone object to test type reference
 *  -- For primitive types and collection types: directly reference to the value
 *  -- For object types: reference to the reference (or the variable)
 * 
 * 	@author VinceYuan
 */
object TestTypeReference {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests primitive type reference:")
    testPrmitiveTypeReference()
    println("\nHere tests collection type reference:")
    testCollectionTypeReference()
    println("\nHere tests object type reference:")
    testObjectTypeReference()
  }
  
  /**
   * 	This is a method to test primitive type reference
   */
  private def testPrmitiveTypeReference(): Unit = {
    
    /*	Int-type reference	*/
    var intA = 1                                  // intA = 1
    val intB = intA                               // intB = 1
    println("Int-type reference:")
    println(s"Before: A=${intA}, B=${intB}")      // A=1, B=1
    intA = 2
    println(s"After: A=${intA}, B=${intB}")       // A=2, B=1
    
    /*	String-type reference	 */
    var strA = "Hello Scala"                      // strA = "Hello Scala"
    val strB = strA                               // strB = "Hello Scala"
    println("String-type reference:")
    println(s"Before: A=${strA}, B=${strB}")      // A="Hello Scala", B="Hello Scala"
    strA = "Hello BigData"
    println(s"After: A=${strA}, B=${strB}")       // A="Hello BigData", B="Hello Scala"
    
    /*	String-type reference	 */
    var strC = new StringBuffer("Hello Scala").toString()    // strC = "Hello Scala"
    val strD = strC                               // strD = "Hello Scala"
    println("String-type reference (instantiation through StringBuffer):")
    println(s"Before: A=${strC}, B=${strD}")      // A="Hello Scala", B="Hello Scala"
    strC = "Hello BigData"
    println(s"After: A=${strC}, B=${strD}")       // A="Hello BigData", B="Hello Scala"
  }
  
  /**
   * 	This is a method to test collection type reference
   *  -- Collection type reference behaves the same as primitive type reference
   */
  private def testCollectionTypeReference(): Unit = {
    
    /*	List reference	 */
    var listA = List(1, 2, 3, 4, 5)               // listA = List(1, 2, 3, 4, 5)
    val listB = listA                             // listB = List(1, 2, 3, 4, 5)
    println("List reference:")
    println(s"Before: A=${listA}, B=${listB}")    // A=List(1, 2, 3, 4, 5), B=List(1, 2, 3, 4, 5)
    listA = List(5, 4, 3, 2, 1)
    println(s"After: A=${listA}, B=${listB}")     // A=List(5, 4, 3, 2, 1), B=List(1, 2, 3, 4, 5)
  }
  
  /**
   * 	This is a method to test object type reference
   */
  private def testObjectTypeReference(): Unit = {
    
    /*	Custom type (or class) reference	 */
    var personA = new Person(UUID.randomUUID().toString(), "Vince", 27)  // personA = Person[..., name=Vince, ...]
    val personB = personA                                                // personB = personA
    println("Custom type reference:")
    println(s"Before: A=${personA}, B=${personB}")                       // A=Person[..., name=Vince, ...], B=Person[..., name=Vince, ...]
    personA.name = "Tommy"
    println(s"After: A=${personA}, B=${personB}")                        // A=Person[..., name=Tommy, ...], B=Person[..., name=Tommy, ...]
  }
}
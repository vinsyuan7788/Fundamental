package org.lang.scala.conclusion.implicits.parameter

import org.lang.scala.conclusion.implicits.common.parameter.classes.Monoid

/**
 * 	This is a stand-alone object to test implicit parameter for value auto-assignment to parameter from current scope
 * 	-- Implicit parameter is the parameter that will be assigned values automatically by Scala according to the data type
 *     -- If generics is NOT involved: value assignment according to the matched data type
 *     -- If generics is involved as data type: should specify a concrete data type to the generics
 *        -- Hence the compiler would know which value can be auto-assigned
 *     -- If generics is involved as type argument: value assignment according to the generics type argument
 *        -- The implicit objects for value assignment MUST be put before where the auto-assignment actually happens
 *  -- To achieve auto-value assignment to implicit parameters: 
 *     -- MUST define implicit variables, implicit functions, implicit methods or implicit objects according to the data type of implicit parameter 
 *  -- Once an implicit parameter is used, MUST ensure there is a corresponding implicit variable, function, method or object that can be referred to by the implicit parameter
 *     -- Some commonly-used implicit parameters have been defined in Scala predef, which can be directly referred to by implicit parameter
 *        -- E.g., Ordering[T], etc.
 *     -- For most of data types, make sure define an implicit variable, function, method or object for the implicit parameter
 *        -- Otherwise the compiler cannot pass the check
 *  -- In this case, the compiler searches implicits from current scope
 * 
 * 	@author VinceYuan'
 */
object TestImplicitParameterFromCurrentScope {
  
  /*	
   * 	Implicit variables and objects for value auto-assignment to parameter
   *  -- Using implicit variables to specify the value of a specific data type
   *  -- In this case: 
   * 	   -- Once scope has an implicit Int parameter: its value is the value of "int": 10
   *     -- Once scope has an implicit Char parameter: its value is  the value of "char": 'M'
   *     -- Once scope has an implicit String parameter: its value is  the value of "str": "Lovelyz"
   *     -- Once scope has an implicit "String => Unit" parameter: its value is the value of "confess": (str: String) => println("I love you " + str)
   *     -- Once scope has an implicit "Int => Unit" parameter: its value is method "express"
   *     -- Once scope has an implicit Monoid[T] parameter:
   *        -- If T is "String", then its value is "StringMonoid"
   *        -- If T is "Int", then its value is "IntMonoid"
   *     -- Once scope has an "Teacher" instance: convert the instance to type "Professor"
   *  Note: using implicit function for type conversion is theoretically feasible but NOT RECOMMENDED, since:
   *  -- Must use "[custom_predef_package_name]._" to introduce this file to other files, which will yield erroneous result if sorting the import packages
   *     -- The introduction package path will become "[custom_predef_package_name].[funcName].apply" 
   */
  implicit val int = 10
  implicit val char = 'M'
  implicit val str = "Lovelyz"
  implicit val confess = (str: String) => println("I love you " + str)
  implicit def express(number: Int) = println("Hello " + number)
  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testImplicitParameterDefinedInCurentScope()
  }
  
  /**
   * 	This is a method to test implicit parameter for value auto-assignment
   */
  private def testImplicitParameterDefinedInCurentScope(): Unit = {
    
    sayHello("GFriend")
    sayHello("GFriend")(10, 'F', "Baby")
    sayTo("Pristin")
    sayTo("Pristin")(name => println("Go fighting! " + name))
    sayTowards(486)
    sayTowards(486)(number => println("This is a " + number))
    sayAloha[String]("Lovelyz")        
    sayAloha("Lovelyz")("Livelyz") 
    println(sum(List(1, 2, 3)))  
    println(sum(List("a", "b", "c")))
  }
  
  /**
   * 	Here are the methods to demonstrates value auto-assignment to parameter when there is no generics
   *  -- The implicit value for Int, Char, String, function-typed parameter ("x", "y", "z", "f") refer to "implicits/predef/CustomPredef.scala"
   *  -- The value auto-assigned will be based on the matched data type
   */
  private def sayHello(name: String)(implicit intParameter: Int, charParameter: Char, strParameter: String) = {
    println(s"Hello $name, $int, $char, $str")
  }
  private def sayTo(name: String)(implicit funcParameter: String => Unit) {  // Here can be viewed as an implicit conversion also
    confess(name)
  }
  private def sayTowards(name: Int)(implicit funcParameter: Int => Unit) {   // Here can be viewed sa an implicit conversion also
    express(name)
  }
  
  /**
   * 	Here are the methods to demonstrate value auto-assignment to parameter when there is generics
   *  -- For generics as data type:
   *     -- The value auto-assigned will be up to the generics type
   *  -- For generics as type argument:
   *     -- The implicit value for Monoid[T]-typed parameter ("m") refer to implicit objects "StringMonoid" or "IntMonoid"
   */
  private def sayAloha[T](name: String)(implicit parameter: T) {
    println(s"Hello $name, $parameter")
  }
  private def sum[T](list: List[T])(implicit obj: Monoid[T]): T = {
    if (list.isEmpty) obj.unit
    else obj.add(list.head, sum(list.tail))  
  }
}
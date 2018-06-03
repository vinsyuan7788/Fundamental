package org.lang.scala.conclusion.oop.cases

import org.lang.scala.conclusion.oop.cases.parent.Human
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a case class to test OOP
 *  -- Case class has the characteristics of both case and class
 *  -- For case class, no need to override "toString" method
 *  
 *  From the perspective of case associated with class:
 *  -- Case is a plain and immutable data-holding instance that exclusively depends on its constructor arguments 
 *     -- Hence case instance construction is object-like: just directly use it
 *     -- Must explicitly specify the primary constructor
 *        -- Even there are no constructor parameters, e.g., case class Student() { ... }
 *     -- Case can be used to encapsulate necessary data (or variables) by placing them as constructor parameters (or variables) or inside class body
 *  -- Case is usually used to be decomposed for pattern matching
 *     -- Refer to "statement/matching" package
 *        
 *  From the perspective of class:
 *  -- Case class is a regular class
 *     -- Since it can be instantiated by using "new" keyword as other regular classes
 *  -- Case class is multiton
 *     -- Since each instance constructed from the same case class is different
 *  -- The variables declared without "val" or "var" are "val" by default
 *  -- Can inherited parent classes (regular, abstract, case) and traits
 * 
 * 	@author VinceYuan
 */
case class Student(

    /*	Instance variables	*/
    val id: String,
    val name: String,
    val gender: Char,
    val age: Int,
    val score: Double
    
) extends Human with Envolve with Survive {

  /*	Inherited methods to be overridden	*/
  override def eat(): Unit = println("A " + this.toString() + " is eating...")
  override def sleep(): Unit = println("A " + this.toString() + " is sleeping...")
  override def work(f: String => String): Unit = println(f(name))
  override def study(f: StudyType): Unit = println(f(name))
  
  /*	For readability	 */
  override def toString() = {
    "Student[id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", score=" + score + "]"
  }
}
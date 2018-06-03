package org.lang.scala.conclusion.oop.classes

import org.lang.scala.conclusion.oop.classes.parent.Mammal
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a stand-alone class to test class
 *  -- In Scala, class is a regular class that can have multiple instances when instantiation
 *     -- Hence a class is multiton by default
 * 
 *  For constructor: there are 2 types of constructors in Scala
 *  -- Primary constructor: the class parameters and class body
 *     -- Primary constructor is the only entry of a class
 *     -- If the variable declared without "val" or "var" in primary constructor is "private[this] val" by default
 *  -- Auxiliary constructor: other constructor(s) that can be used for instantiation
 *     -- MUST start by invoking primary constructor or another auxiliary constructor
 *        
 *	For method:
 *  -- If overriding an inherited method
 *     -- Need to add "override" keyword in front of it
 * 	-- For main method: 
 *     -- A class can declare a main method inside it
 *     -- But only the main method in an object can be the entry of a program
 *        -- Since object itself is an instance, which can invoke methods directly, while class is not an instance and need to be instantiated
 *  
 *  For companion class: 
 *  -- If a class have an object that has the same name, then this class is companion class
 *     -- Refer to "oop/companion" package
 *     
 *  @author VinceYuan 
 */
sealed class Businessman(
    
    /*	Instance variables	*/
    var id: String, 
    var name: String, 
    var age: Int, 
    isMarried: Boolean
    
) extends Mammal with Envolve with Survive {
  
  /*	Instance variables	*/
  var gender: Char = _
  var income: Double = _
  
  /*
   * 	Auxiliary constructors
   *  -- Declared by using "this" keyword
   */
  def this() = this("987654", "Vince", 30, false)
  def this(bname: String) = {
    this("987654", bname, 30, false)
    println("\"This(name)\" is executed...")
  }
  def this(bmid: String, bmname: String) = {
    this(bmname)
    println("\"This(id, name)\" is executed...")
    this.id = bmid
  }
  
  /*	Instance methods	*/
  /*	Inherited methods to be overridden	 */
  override def eat(): Unit = {
    println("A " + this.toString() + " is eating...")
  }
  override def sleep(): Unit = {
    println("A " + this.toString() + " is sleeping...")
  }
  override def work(f: String => String): Unit = {
    println(f(name))
  }
  override def study(f: StudyType): Unit = {
    println(f(name))
  }
  /*	Main method	 */
  def main(args: Array[String]): Unit = {}
  
  /*	For readability	 */
  override def toString(): String = {
    "Businessman[id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", income=" + income + "]"
  }
}
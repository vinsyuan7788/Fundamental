package org.lang.scala.conclusion.oop.objects

import org.lang.scala.conclusion.oop.objects.parent.HumanBeing
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a stand-alone object to test object
 *  -- In Scala, object is an (description of a singleton) instance that will be used in the future
 *     -- Hence object will not be instantiated until it is actually used
 *     -- Hence object is LAZY singleton
 *  
 *  For constructor:
 *  -- Object does NOT have constructors since it is a description of an instance for future use
 *     -- To describe an instance, need to specify its members (variables, methods, etc) which are also contained by a class generally
 *        -- This makes an object look similar as a class superficially, but mechanically object is still totally different from class
 *           -- Object not being allowed to have constructors demonstrates the differences against class
 *      
 *	For method:
 *  -- For "apply":
 *     -- It will be automatically invoked when a singleton object is invoked (as a function from FP perspective)
 *        -- E.g., Student() (NOT "Student")
 *     -- Can be used to instantiate instance variables in the object, etc.
 *     -- More details regarding "apply" refer to "oop/function/apply/TestApply.scala"
 *  -- If overriding an inherited method
 *     -- Need to add "override" keyword in front of it
 * 	-- For main method: 
 *     -- A class can declare a main method inside it
 *     -- But only the main method in an object can be the entry of a program
 *        -- Since object being an instance will be instantiated when the program is executed, which can invoke methods directly, while class is not an instance
 *  
 *  For companion object: 
 *  -- If a object have a class that has the same name, then this object is companion object
 *     -- Refer to "oop/companion" package
 * 
 * 	@author VinceYuan
 */
object Student extends HumanBeing with Envolve with Survive {
  
  /*	Instance variables	 */
  var id: String = _
  var name: String = _
  var score: Double = _
  
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
  /*	"apply" methods	 */
  def apply() = Student
  def apply(name: String) = {
    this.name = name
    Student
  }
  def apply(id: String, name: String) = {
    this.id = id
    this.name = name
    Student
  }
  def apply(id: String, name: String, score: Double) = {
    this.id = id
    this.name = name
    this.score = score
    Student
  }
  /*	Main method	 */
  def main(args: Array[String]): Unit = {}
  
  /*	For readability	 */
  override def toString(): String = {
    "Student[id=" + id + ", name=" + name + ", score=" + score + "]"
  }
}
package org.lang.scala.conclusion.oop.companion

import org.lang.scala.conclusion.oop.companion.parent.Human
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a companion class (or Scala bean) to be used to test OOP
 * 	-- In Scala bean, no need to consider getters and setters, refer to "keyword/TestValandVar.scala"
 *  
 * 	Application scenarios of companion classes:
 *  -- If Interactions between Scala and Java are involved, companion classes are mostly necessary
 *     -- Since Java needs companion classes if Java needs to invoke static variables of the classes
 *     -- More details refer to "withJava" package
 *     
 * 	@author VinceYuan
 */
class Developer private () extends Human with Survive with Envolve {
  
  /*	Instance variables	*/
  var id: String = _
  var username: String = _ 
  var gender: Char = _
  var salary: Double = _
    
  /*	Auxiliary constructors	*/
  def this(username: String) = {
    this()
    this.username = username
  }
  
  /*	Inherited methods to be overridden	 */
  override def eat(): Unit = {
    println("A " + this.toString() + " is eating...")
  }
  override def sleep(): Unit = {
    println("A " + this.toString() + " is sleeping...")
  }
  override def work(f: String => String): Unit = {
    println(f(username))
  }
  override def study(f: StudyType): Unit = {
    println(f(username))
  }
    
  /*	For readability	 */
	override def toString(): String = {
		"Developer[ID=" + id + ", username=" + username + ", gender=" + gender + ", salary=" + salary + "]"
	}
}

/**
 * 	This is a companion object of current class
 *  -- Companion object: the object that has the same name with the class
 *  -- Companion object can access (private) variables, methods, constructors (both main and auxiliary) in companion class
 *  -- Companion object is a singleton instance
 *  
 *  Application scenarios of companion objects:
 *  -- Provide utility methods for companion classes
 *  -- Provide implicit conversion for companion classes
 *  
 *  @author VinceYuan
 */
object Developer {

  /*	Utility methods	 */
  def apply(id: String, username: String, gender: Char, salary: Double): Developer = {
    val instance: Developer = new Developer()
    instance.id = id
    instance.username = username
    instance.gender = gender
    instance.salary = salary
    instance
  }
  def compareBySalary(o1: Developer, o2: Developer): String = {
    if (o1.salary < o2.salary) {
      o1.username + " earns less than " + o2.username
    } else if (o1.salary == o2.salary) {
      o1.username + " earns equally with " + o2.username
    } else {
      o1.username + " earns more than " + o2.username
    }
  }
}
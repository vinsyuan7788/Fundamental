package org.lang.scala.conclusion.oop.features

import org.lang.scala.conclusion.oop.features.parent.Human
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a companion class (or Scala bean) to be used to test OOP
 * 	-- In Scala bean, no need to consider getters and setters, refer to "keyword/TestValandVar.scala"
 *     
 * 	@author VinceYuan
 */
class Developer extends Human with Survive with Envolve {
  
  /*	Instance variables	*/
  var id: String = _
  var username: String = _ 
  var gender: Char = _
  var salary: Double = _
    
  /*	Auxiliary constructors	*/
  def this(id: String, username: String, gender: Char, salary: Double) = {
    this()
    this.id = id
    this.username = username
    this.gender = gender
    this.salary = salary
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
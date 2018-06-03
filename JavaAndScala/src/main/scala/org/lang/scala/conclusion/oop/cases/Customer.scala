package org.lang.scala.conclusion.oop.cases

import org.lang.scala.conclusion.oop.cases.parent.Human
import org.lang.scala.conclusion.oop.traits.Envolve
import org.lang.scala.conclusion.oop.traits.Survive

/**
 * 	This is a case object to test OOP
 *  -- Case object has the characteristics of both case and object
 *  -- For case object, no need to override "toString" method
 *  
 *  From the perspective of case associated with object:
 *  -- Case is a plain and immutable data-holding instance
 *     -- Hence case object construction is object-like: just directly use it
 *     -- Case can be used to encapsulate necessary data (or variables) by placing them inside object body
 *  -- Case is usually used to be decomposed for pattern matching
 *     -- Refer to "statement/matching" package
 * 
 * 	@author VinceYuan
 */
object Customer extends Human with Envolve with Survive  {
  
  /*	Instance variables	*/
  val identity = "customer"
  
  /*	Inherited methods to be overridden	*/
  override def eat(): Unit = println("A " + this.toString() + " is eating...")
  override def sleep(): Unit = println("A " + this.toString() + " is sleeping...")
  override def work(f: String => String): Unit = println(f(identity))
  override def study(f: StudyType): Unit = println(f(identity))
  
  /*	For readability	 */
  override def toString() = {
    "Customer[identity=" + identity + "]"
  }
}
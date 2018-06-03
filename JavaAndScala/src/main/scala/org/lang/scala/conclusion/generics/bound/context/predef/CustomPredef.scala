package org.lang.scala.conclusion.generics.bound.context.predef

import org.lang.scala.conclusion.generics.common.bound.classes.Student
import org.lang.scala.conclusion.generics.common.bound.classes.Customer

/**
 * 	This is a stand-alone object to test context-bound
 * 
 * 	@author VinceYuan
 */
object CustomPredef {
  
  /*	Implicit objects for value assignment	 */  
  implicit object CustomerOrdering extends Ordering[Customer] {
    println("Here is an implicit object to assign CustomerOrdering to parameter if Ordering[Customer]...")
    override def compare(x: Customer, y: Customer): Int = {
      x.age - y.age
    }
  }
  implicit object StudentOrdering extends Ordering[Student] {
    println("Here is an implicit object to assign StudentOrdering to parameter if Ordering[Student]...")
    override def compare(x: Student, y: Student): Int = {
      (x.score - y.score).toInt
    }
  }
}
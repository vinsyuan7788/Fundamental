package org.lang.scala.conclusion.generics.bound.view.predef

import org.lang.scala.conclusion.generics.common.bound.classes.Customer
import org.lang.scala.conclusion.generics.common.bound.classes.Student

/**
 * 	This is a stand-alone object to test view-bound
 * 
 * 	@author VinceYuan
 */
object CustomPredef {
  
  /*	Instance methods for implicit conversion	*/
  implicit def customerToOrdered(customer: Customer) = {
    println("Here is an implicit method to convert Customer to Ordered[Customer] for comparison...")
    new Ordered[Customer] {
      override def compare(that: Customer): Int = {
        customer.age - that.age
      }
    }
  }
  implicit def studentToOrdered(studnet: Student) = {
    println("Here is an implicit method to convert Student to Ordered[Student] for comparison...")
    new Ordered[Student] {
      override def compare(that: Student): Int = {
        (studnet.score - studnet.score).toInt
      }
    }
  }
}
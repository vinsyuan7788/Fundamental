package org.lang.scala.conclusion.generics.bound

import java.util.UUID

import org.lang.scala.conclusion.generics.common.bound.classes.Customer
import org.lang.scala.conclusion.generics.common.bound.classes.Student
import org.lang.scala.conclusion.generics.bound.view.ViewBound
import org.lang.scala.conclusion.generics.bound.view.predef.CustomPredef.customerToOrdered
import org.lang.scala.conclusion.generics.bound.view.predef.CustomPredef.studentToOrdered

/**
 * 	This is a stand-alone object to test view-bound
 * 
 * 	@author VinceYuan
 */
object TestViewBound {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testViewBound()
  }
  
  /**
   * 	This is a method to test view bound
   */
  private def testViewBound(): Unit = {
    
    val result1 = ViewBound.compareTo(1, 2)
    val result1_deSugar = ViewBound.compareTo_deSugar(1, 2)
    val result2 = ViewBound.compareTo("Scala", "Java")
    val result2_deSugar = ViewBound.compareTo_deSugar("Scala", "Java")
    println(result1)
    println(result1_deSugar)
    println(result2)
    println(result2_deSugar)
    
    val customer1 = new Customer()
    customer1.id = UUID.randomUUID().toString()
    customer1.name = "Vince"
    customer1.age = 27
    val customer2 = new Customer()
    customer2.id = UUID.randomUUID().toString()
    customer2.name = "Violet"
    customer2.age = 25
    val result3 = ViewBound.compareTo(customer1, customer2)
    val result3_deSugar = ViewBound.compareTo_deSugar(customer1, customer2)
    val result3_orderedToOrdering = ViewBound.compareTo_OrderedToOrdering(customer1, customer2)
    println(result3)
    println(result3_deSugar)
    println(result3_orderedToOrdering)
    val student1 = new Student()
    student1.id = UUID.randomUUID().toString()
    student1.name = "Vince"
    student1.score = 98.56
    val student2 = new Student()
    student2.id = UUID.randomUUID().toString()
    student2.name = "Violet"
    student2.score = 96.89
    val result4 = ViewBound.compareTo(student1, student2)
    val result4_deSugar = ViewBound.compareTo_deSugar(student1, student2)
    val result4_orderedToOrdering = ViewBound.compareTo_OrderedToOrdering(student1, student2)
    println(result4)
    println(result4_deSugar)
    println(result4_orderedToOrdering)
  }
}
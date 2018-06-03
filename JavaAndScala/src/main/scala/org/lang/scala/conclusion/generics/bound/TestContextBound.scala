package org.lang.scala.conclusion.generics.bound

import java.util.UUID

import org.lang.scala.conclusion.generics.common.bound.classes.Customer
import org.lang.scala.conclusion.generics.common.bound.classes.Student
import org.lang.scala.conclusion.generics.bound.context.ContextBound
import org.lang.scala.conclusion.generics.bound.context.predef.CustomPredef.CustomerOrdering
import org.lang.scala.conclusion.generics.bound.context.predef.CustomPredef.StudentOrdering

/**
 * 	This is a stand-alone object to test context-bound
 * 
 * 	@author VinceYuan
 */
object TestContextBound {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testContextBound()
  }
  
  /**
   * 	This is a method to test context-bound
   */
  private def testContextBound(): Unit = {
    
    val result1 = ContextBound.compareTo(1, 2)
    val result1_deSugar = ContextBound.compareTo_deSugar(1, 2)
    val result2 = ContextBound.compareTo("Scala", "Java")
    val result2_deSugar = ContextBound.compareTo_deSugar("Scala", "Java")
    println(result1)
    println(result1_deSugar)
    println(result2)
    println(result2_deSugar)
    println()
    
    val customer1 = new Customer()
    customer1.id = UUID.randomUUID().toString()
    customer1.name = "Vince"
    customer1.age = 27
    val customer2 = new Customer()
    customer2.id = UUID.randomUUID().toString()
    customer2.name = "Violet"
    customer2.age = 25
    val result3 = ContextBound.compareTo(customer1, customer2)
    val result3_deSugar = ContextBound.compareTo_deSugar(customer1, customer2)
    val result3_orderingToOrdered = ContextBound.compareTo_OrderingToOrdered(customer1, customer2)
    println(result3)
    println(result3_deSugar)
    println(result3_orderingToOrdered)
    val student1 = new Student()
    student1.id = UUID.randomUUID().toString()
    student1.name = "Vince"
    student1.score = 98.56
    val student2 = new Student()
    student2.id = UUID.randomUUID().toString()
    student2.name = "Violet"
    student2.score = 96.89
    val result4 = ContextBound.compareTo(student1, student2)
    val result4_deSugar = ContextBound.compareTo_deSugar(student1, student2)
    val result4_orderingToOrdered = ContextBound.compareTo_OrderingToOrdered(student1, student2)
    println(result4)
    println(result4_deSugar)
    println(result4_orderingToOrdered)
  }
}
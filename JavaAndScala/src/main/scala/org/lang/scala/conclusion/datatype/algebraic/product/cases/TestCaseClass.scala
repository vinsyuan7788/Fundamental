package org.lang.scala.conclusion.datatype.algebraic.product.cases

import org.lang.scala.conclusion.datatype.algebraic.product.cases.classes.Professor
import org.lang.scala.conclusion.datatype.algebraic.product.cases.classes.enumeration.Gender
import scala.util.Random

/**
 * 	This is a stand-alone object to test product type implemented by case class
 * 
 * 	@author VinceYuan
 */
object TestCaseClass {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCaseClass()
  }
  
  /**
   * 	This is a method to test product type implemented by case class
   */
  def testCaseClass(): Unit = {
    
    val professor1 = Professor(Gender.M, true)
    val professor2 = Professor(Gender.F, true)
    val professor3 = Professor(Gender.U, false)
    val arr1 = Array(professor1, professor2, professor3)
    val professor = arr1(Random.nextInt(arr1.length))
    println(professor)
    professor match {
      case Professor(Gender.F, true) => println("I love you professor!")
      case Professor(_, true) => println("Morning professor!")
      case Professor(_, false) => println("May you have peace in heaven!")
    }
  }
}
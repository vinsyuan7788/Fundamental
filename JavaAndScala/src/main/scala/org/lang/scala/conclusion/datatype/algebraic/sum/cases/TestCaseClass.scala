package org.lang.scala.conclusion.datatype.algebraic.sum.cases

import scala.reflect.runtime.universe
import scala.util.Random

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.Johnny
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.Kelley
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.Violet
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.enumeration.Gender
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.parent.Doctor

/**
 * 	This is a stand-alone object to test sum type implemented by case class
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
   * 	This is a method to test sum type implemented by case class
   */
  def testCaseClass(): Unit = {
    
    val doctor1: Doctor = Johnny(false)
    val doctor2: Doctor = Kelley(Gender.F, false)
    val doctor3: Doctor = Violet(Gender.F)
    val arr2 = Array(doctor1, doctor2, doctor3)
    val doctor = arr2(Random.nextInt(arr2.length))
    println(doctor)
    println(ReflectionUtils.getRuntimeType(doctor))
    doctor match {
      case Johnny(_) => println("Hello Johnny!")
      case Kelley(_, _) => println("Hello Kelley!")
      case _ => println("Hello Dear Violet")
    }
  }
}
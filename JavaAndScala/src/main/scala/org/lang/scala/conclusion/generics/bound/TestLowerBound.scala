package org.lang.scala.conclusion.generics.bound

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.generics.common.bound.classes.Developer
import org.lang.scala.conclusion.generics.common.bound.classes.ScalaDeveloper
import org.lang.scala.conclusion.generics.common.bound.classes.SparkDeveloper
import org.lang.scala.conclusion.generics.bound.lower.LowerBound

/**
 * 	This is a stand-alone object to test lower-bound
 *  
 *  Lower-bound CANNOT be used to generics type check at compile-time since:
 *  -- "val t: >:T = new T()" cannot be prohibited at compile-time, hence it will always reference the instance to its super-class automatically
 *     -- E.g., "val t: ScalaDeveloper = new SparkDeveloper()" can be accepted at compile-time, hence "new SparkDeveloper()" will always satisfy ">: ScalaDeveloper"
 * 
 * 	@author VinceYuan
 */
object TestLowerBound {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testLowerBound()
  }
  
  /**
   * 	This is a method to test lower bound
   */
  private def testLowerBound(): Unit = {

    val developer = new Developer()
    val scalaDeveloper = new ScalaDeveloper()
    val sparkDeveloper = new SparkDeveloper()
    println(ReflectionUtils.getRuntimeType(developer))
    println(ReflectionUtils.getRuntimeType(scalaDeveloper))
    println(ReflectionUtils.getRuntimeType(sparkDeveloper))
    LowerBound.getInfo(developer)
    LowerBound.getInfo(scalaDeveloper)
    LowerBound.getInfo(sparkDeveloper)
  }
}
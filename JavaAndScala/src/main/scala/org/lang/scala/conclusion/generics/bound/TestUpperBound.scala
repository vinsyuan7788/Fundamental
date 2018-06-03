package org.lang.scala.conclusion.generics.bound

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.generics.common.bound.classes.Developer
import org.lang.scala.conclusion.generics.common.bound.classes.ScalaDeveloper
import org.lang.scala.conclusion.generics.common.bound.classes.SparkDeveloper
import org.lang.scala.conclusion.generics.bound.upper.UpperBound

/**
 * 	This is a stand-alone object to test upper bound
 * 
 *  Upper-bound CAN be used to generics type check at compile-time since:
 *  -- "val t: <:T = new T()" is prohibited at compile-time, hence it will NOT reference the instance to its sub-class
 *     -- E.g., "val t: ScalaDeveloper = new Developer()" is NOT accepted at compile-time, hence "new Developer()" will always NOT satisfy "<: ScalaDeveloper"
 * 
 * 	@author VinceYuan
 */
object TestUpperBound {
 
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testUpperBound()
  }
  
  /**
   * 	This is a method to test upper bound
   */
  private def testUpperBound(): Unit = {
    
    val developer = new Developer()
    val scalaDeveloper = new ScalaDeveloper()
    val sparkDeveloper = new SparkDeveloper()
    println(ReflectionUtils.getRuntimeType(developer))
    println(ReflectionUtils.getRuntimeType(scalaDeveloper))
    println(ReflectionUtils.getRuntimeType(sparkDeveloper))
//    UpperBound.getInfo(developer)
    UpperBound.getInfo(scalaDeveloper)
    UpperBound.getInfo(sparkDeveloper)
    
    val result = UpperBound.compareTo[Integer](2, 1)
    println(result)
  }
}
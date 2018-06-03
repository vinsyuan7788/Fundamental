package org.lang.scala.conclusion.generics.bound.upper

import org.lang.scala.conclusion.generics.common.bound.classes.ScalaDeveloper

/**
 * 	This is a stand-alone object to test upper-bound
 *  -- Upper-bound is a type that must be inherited
 *     -- Using "<:" to specify a upper-bound 
 *     
 * 	@author VinceYuan
 */
object UpperBound {
 
  def getInfo[T <: ScalaDeveloper](t: T) = {
    println(t)
  }
  
  def compareTo[T <: Comparable[T]](instance1: T, instance2: T) = {
    if (instance1.compareTo(instance2) > 0) instance1 else instance2
  }
}
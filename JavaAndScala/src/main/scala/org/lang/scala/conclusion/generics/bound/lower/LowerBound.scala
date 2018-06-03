package org.lang.scala.conclusion.generics.bound.lower

import org.lang.scala.conclusion.generics.common.bound.classes.ScalaDeveloper

/**
 * 	This is a stand-alone object to test lower-bound
 *  -- Lower-bound is a type that must be supered
 *     -- Using ">:" to specify a lower-bound
 * 
 * 	@author VinceYuan
 */
object LowerBound {

  def getInfo[T >: ScalaDeveloper](t: T) = {
    println(t)
  }
}
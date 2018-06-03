package org.lang.scala.conclusion.implicits.common.parameter.classes

/**
 * 	This is an abstract class to test implicit parameter
 * 
 * 	A monoid is a semi-group with a distinguished (or identity) element of T that will not change the element under a specific operation
 *  -- In this case using using an "unit" method to return that distinguished (or identity) element 
 * 
 * 	@author VinceYuan
 */
abstract class Monoid[T] extends SemiGroup[T] {

  def unit: T
}
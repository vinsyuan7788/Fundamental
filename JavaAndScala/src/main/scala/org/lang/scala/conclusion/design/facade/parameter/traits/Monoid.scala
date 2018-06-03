package org.lang.scala.conclusion.design.facade.parameter.traits

/**
 * 	This is an abstract class to test facade pattern on implicit parameters
 * 
 * 	A monoid is a semi-group with a distinguished (or identity) element of T that will not change the element under a specific operation
 *  -- In this case using using an "unit" method to return that distinguished (or identity) element 
 * 
 * 	@author VinceYuan
 */
abstract class Monoid[T] extends SemiGroup[T] {

  def unit: T
}
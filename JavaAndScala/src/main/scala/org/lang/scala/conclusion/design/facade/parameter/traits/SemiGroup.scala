package org.lang.scala.conclusion.design.facade.parameter.traits

/**
 * 	This is an abtract class to test facade pattern on implicit parameters
 * 
 * 	A semi-group is an algebraic structure on a set T with an (associative) operation:
 *  -- A data type for the set: 
 *     -- In this case using a generics T
 *  -- An (associative) operation that does not change the data type: 
 *     -- In this case using an "add" method that combines a pair of T's and returns another T
 * 	
 * 	@author VinceYuan
 */
abstract class SemiGroup[T] {
  
  def add(x: T, y: T): T
}
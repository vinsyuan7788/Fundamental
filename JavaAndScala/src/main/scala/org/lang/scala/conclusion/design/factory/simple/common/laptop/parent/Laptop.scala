package org.lang.scala.conclusion.design.factory.simple.common.laptop.parent

/**
 * 	This is a trait to be used to test the implementation of simple factory pattern
 *  -- This interface must be implemented by its child classes
 *  
 * 	@author VinceYuan
 */
trait Laptop {
 
  def startup(): Unit
  def shutdown(): Unit
}
package org.lang.scala.conclusion.design.factory.abstracts.common

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must inherit a parent abstract class
 *  
 * 	@author VinceYuan
 */
class WindowsBorder extends Border {
  	
  override def scroll() = {
    println("A Windows border is being scrolled...")
  }
}
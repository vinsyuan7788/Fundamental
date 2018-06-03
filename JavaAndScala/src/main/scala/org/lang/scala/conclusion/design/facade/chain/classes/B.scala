package org.lang.scala.conclusion.design.facade.chain.classes

/**
 * 	This is a stand-alone class to test facade pattern on implicit chains
 * 
 * 	@author VinceYuan
 */
class B(val a: Int, val b: Int) {
  
  def getB = (a, b)
}
package org.lang.scala.conclusion.design.facade.chain.classes

/**
 * 	This is a stand-alone class to test facade pattern on implicit chains
 * 
 * 	@author VinceYuan
 */
class C(val a: Int, val b: Int, val c: Int) {
  
  def getC = (a, b, c)
  def sum = a + b + c
}
package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a companion class to test implicit chains
 * 
 * 	@author VinceYuan
 */
class C(val x: Int, val y: Int, val z: Int) {
  
  def getC = (x, y, z)
  def sum = x + y + z
}
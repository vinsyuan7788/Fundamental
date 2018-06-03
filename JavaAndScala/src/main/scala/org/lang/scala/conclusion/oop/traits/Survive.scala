package org.lang.scala.conclusion.oop.traits

/**
 * 	This is a trait to be used to test OOP
 *  -- Details refer to "traits/Envolve.scala"
 * 
 * 	@author VinceYuan
 */
trait Survive {
  
  type WorkType = String => String
  def work(f: WorkType): Unit
}
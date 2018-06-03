package org.lang.scala.conclusion.oop.traits

/**
 * 	This is a trait to be used to test OOP
 *  -- Details refer to "traits/Envolve.scala"
 * 
 * 	@author VinceYuan
 */
trait Improve {

  type StudyType = String => String
  def study(f: StudyType): Unit
}
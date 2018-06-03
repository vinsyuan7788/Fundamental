package org.lang.scala.conclusion.annotation.bean.parent

/**
 * 	This is an abstract class to test annotation
 * 
 * 	@author VinceYuan
 */
abstract class Human {
  
  val race = "Human"
  
  def live(name: String, age: Int, gender: Char, race: String)
}
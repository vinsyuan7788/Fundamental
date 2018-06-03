package org.lang.scala.conclusion.reflection.bean.parent

/**
 * 	This is an abstract class to test reflection
 * 
 * 	@author VinceYuan
 */
abstract class Human {
  
  val race = "Human"
  
  def live(name: String, age: Int, gender: Char, race: String)
}
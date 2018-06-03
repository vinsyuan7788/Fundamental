package org.lang.scala.conclusion.design.factory.abstracts.common

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must be inherited by its child classes
 *  
 * 	@author VinceYuan
 */
abstract class Button {
  
	/*	Instance variables	*/
	var name: String = _
	var brand: String = _
	var color: String = _

	/*	Instance methods	*/
	def click(): Unit = {
	  println("A button is being clicked...")
	}
	
	/*	abstract methods	*/
	def design(): Unit
}
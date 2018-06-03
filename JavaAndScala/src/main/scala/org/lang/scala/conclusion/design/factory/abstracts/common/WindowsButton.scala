package org.lang.scala.conclusion.design.factory.abstracts.common

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must inherit a parent abstract class
 *  
 * 	@author VinceYuan
 */
class WindowsButton extends Button {
	
	override def design() = {
	  println("A Windows button is under design...")
	}
}
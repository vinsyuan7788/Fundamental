package org.lang.scala.conclusion.design.factory.simple.common.vehicle.parent

/**
 * 	This is an abstract class to be used to test the implementation of simple factory pattern
 * 	-- This abstract class must be inherited by its child classes
 * 
 * 	@author VinceYuan
 */
abstract class Vehicle {
  
  /*	Instance variables	*/
	var id: String = _
	var brand: String = _
	var size: Int = _
	
	/*	Instance methods	*/
	def speedup(): Unit = {
	  println("A vehicle is speeding up...")
	}
	def slowdown(): Unit = {
	  println("A vehicle is slowing down...")
	}
	
	/*	Abstract methods	*/
	def turn(): Unit
	def inspect(): Unit
}
package org.lang.scala.conclusion.design.factory.simple.common.vehicle

import org.lang.scala.conclusion.design.factory.simple.common.vehicle.parent.Vehicle

/**
 * 	This is a stand-alone class to be used to test the implementation of simple factory pattern
 *  -- This class must inherit a parent abstract class
 *  
 * 	@author VinceYuan
 */
class Truck extends Vehicle {
  
	override def turn(): Unit = {
		println("A truck is turning left...")
	}

	override def inspect(): Unit = {
		println("A truck is under inspection...")
	}
}
package org.lang.scala.conclusion.design.factory.simple

import org.lang.scala.conclusion.design.factory.simple.common.vehicle.parent.Vehicle
import org.lang.scala.conclusion.design.factory.simple.common.vehicle.Ship
import org.lang.scala.conclusion.design.factory.simple.common.vehicle.Train
import org.lang.scala.conclusion.design.factory.simple.common.vehicle.Truck

/**
 * 	This is a class to implement simple factory pattern
 *  -- Declare a factory method to return an instance of different classes according to different arguments 
 *     -- Make use of polymorphism inside the factory method
 *     
 * 	@author VinceYuan
 */
object VehicleFactory {
 
  /**
   * 	This is a method to get vehicle from a type 
   */
  def getVehicle(`type`: String) = {
 
    /*	Declare an reference of parent interface	*/
    var vehicle: Vehicle = null
    
    /*	Reference to an instance of different child classes according to the argument	 */
    `type`.toUpperCase() match {
      case "SHIP" => vehicle = new Ship()
      case "TRAIN" => vehicle = new Train()
      case "TRUCK" => vehicle = new Truck()
    }
    
    /*	Return the instance  */
    vehicle
  }
}
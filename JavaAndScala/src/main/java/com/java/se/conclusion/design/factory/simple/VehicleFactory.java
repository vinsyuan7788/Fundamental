package com.java.se.conclusion.design.factory.simple;

import com.java.se.conclusion.design.factory.simple.common.vehicle.Ship;
import com.java.se.conclusion.design.factory.simple.common.vehicle.Train;
import com.java.se.conclusion.design.factory.simple.common.vehicle.Truck;
import com.java.se.conclusion.design.factory.simple.common.vehicle.Vehicle;

/**
 * 	This is a class to implement simple factory pattern
 *  -- Declare a public and static factory method to return an instance of different classes according to different arguments 
 *     -- Make use of polymorphism inside the factory method
 * @author VinceYuan
 *
 */
public class VehicleFactory {

	/**
	 * 	This is a public and static factory method
	 *  -- Declare an reference of parent abstract class
	 *  -- Reference to an instance of different child classes according to the argument
	 *  -- Return the instance
	 * @param type
	 * @return
	 */
	public static Vehicle getVehicle(String type) {
		
		/*	Declare an reference of parent abstract class	*/
		Vehicle vehicle;
		
		/*	Reference to an instance of different child classes according to the argument	*/
		switch (type.toUpperCase()) {
		case "SHIP":
			vehicle = new Ship();
			break;
		case "TRAIN":
			vehicle = new Train();
			break;
		case "TRUCK":
			vehicle = new Truck();
			break;
		default:
			vehicle = null;
			break;
		}
		
		/*	Return the instance	 */
		return vehicle;
	}
}

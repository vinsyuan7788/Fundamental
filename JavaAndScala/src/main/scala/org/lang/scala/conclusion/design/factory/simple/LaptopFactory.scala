package org.lang.scala.conclusion.design.factory.simple

import org.lang.scala.conclusion.design.factory.simple.common.laptop.Acer
import org.lang.scala.conclusion.design.factory.simple.common.laptop.Dell
import org.lang.scala.conclusion.design.factory.simple.common.laptop.Lenovo
import org.lang.scala.conclusion.design.factory.simple.common.laptop.parent.Laptop

/**
 * 	This is a class to implement simple factory pattern
 *  -- Declare a factory method to return an instance of different classes according to different arguments 
 *     -- Make use of polymorphism inside the factory method
 *     
 * 	@author VinceYuan
 */
object LaptopFactory {
 
  /**
   * 	This is a method to get lap-top from a brand 
   */
  def getLaptop(brand: String) = {
 
    /*	Declare an reference of parent interface	*/
    var laptop: Laptop = null
    
    /*	Reference to an instance of different child classes according to the argument	 */
    brand.toUpperCase() match {
      case "ACER" => laptop = new Acer()
      case "DELL" => laptop = new Dell()
      case "LENOVO" => laptop = new Lenovo()
    }
    
    /*	Return the instance  */
    laptop
  }
}

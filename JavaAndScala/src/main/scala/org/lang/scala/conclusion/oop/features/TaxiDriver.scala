package org.lang.scala.conclusion.oop.features

import org.lang.scala.conclusion.oop.features.parent.Driver

/**
 * 	This is a stand-alone object to test OOP
 * 	-- The instantiation of this subclass will execute the primary (2-parameter) constructor of superclass
 *     -- In this case, the instantiation of subclass passes name and age to the primary constructor of superclass (since it is parameterless)
 *  -- If sub-class is companion class, MUST use "override" keyword for the instance variables inside sub-class primary constructor
 * 
 * 	@author VinceYuan
 */
class TaxiDriver(

    override val name: String,
    override val age: Int
    
) extends Driver(name, age) {
  
}

object TaxiDriver {
  
  def apply(name: String, age: Int) = new TaxiDriver(name, age)
}
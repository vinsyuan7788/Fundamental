package org.lang.scala.conclusion.oop.features

import org.lang.scala.conclusion.oop.features.parent.Student

/**
 * 	This is a stand-alone object to test OOP
 * 	-- The instantiation of this subclass will execute the auxiliary (3-parameter) constructor of superclass
 *     -- In this case, the instantiation of subclass passes id, name and age to the auxiliary constructor of superclass (since it is parameterless)
 * 
 * 	@author VinceYuan
 */
class Sophomore(

    val _id: String,
    val _name: String,
    val _age: Int
    
) extends Student(_id, _name, _age) {
  
}
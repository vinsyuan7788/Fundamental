package org.lang.scala.conclusion.oop.features

import org.lang.scala.conclusion.oop.features.parent.Student

/**
 * 	This is a stand-alone object to test OOP
 * 	-- The instantiation of this subclass will execute the primary (parameterless) constructor of superclass
 *     -- In this case, the instantiation of subclass passes nothing to the primary constructor of superclass (since it is parameterless)
 * 
 * 	@author VinceYuan
 */
class Graduate(

    val _id: String,
    val _name: String,
    val _age: Int
    
) extends Student() {
  
}
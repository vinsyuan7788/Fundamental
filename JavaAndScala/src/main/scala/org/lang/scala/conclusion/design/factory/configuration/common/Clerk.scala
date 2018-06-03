package org.lang.scala.conclusion.design.factory.configuration.common

/**
 * 	This is a stand-alone class to test the implementation of configuration factory pattern
 * 	-- This stand-alone class must offer a parameterless constructor, which is offered by default
 * 
 * 	@author VinceYuan 
 */
class Clerk extends Serializable {
  
  var id: String = _
  var name: String = _
  var age: Int = _
  var gender: Char = _
  
  /**
   * 	For readability
   */
  override def toString() = {
    s"Clerk[id=${id}, name=${name}, age=${age}, gender=${gender}]"
  }
}
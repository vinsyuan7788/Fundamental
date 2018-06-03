package org.lang.scala.conclusion.design.factory.method.common

/**
 * 	This is a stand-alone class to test the implementation of factory method pattern
 * 	-- This stand-alone class must offer a parameterless constructor, which is offered by default
 * 
 * 	@author VinceYuan 
 */
class Sergeant extends Serializable {
  
  var id: String = _
  var name: String = _
  var age: Int = _
  var gender: Char = _
  
  /**
   * 	For readability
   */
  override def toString() = {
    s"Sergeant[id=${id}, name=${name}, age=${age}, gender=${gender}]"
  }
}
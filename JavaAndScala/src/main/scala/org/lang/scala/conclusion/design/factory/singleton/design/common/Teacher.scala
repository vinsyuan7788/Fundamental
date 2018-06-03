package org.lang.scala.conclusion.design.factory.singleton.design.common

/**
 * 	This is a Java bean to be used to test the implementation of singleton factory pattern
 * 	-- This stand-alone class must offer a parameterless constructor, which is offered by default
 * 
 * 	@author VinceYuan
 */
class Teacher {
  
  var id: String = _
  var name: String = _
  var age: Integer = _
  var gender: Char = _

  /**
   * 	For readability
   */
  override def toString() = {
    s"Teacher[id=${id}, name=${name}, age=${age}, gender=${gender}]"
  }
}
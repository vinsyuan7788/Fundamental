package org.lang.scala.conclusion.design.facade.conversion.classes

/**
 * 	This is a stand-alone class to test facade pattern on implicit conversions
 * 
 * 	@author VinceYuan
 */
class Teacher {
  
  var id: String = _
  var name: String = _
  var gender: Char = _
  
  override def toString() = {
    "Teacher[id=" + id + ", name=" + name + ", gender=" + gender + "]"
  }
}
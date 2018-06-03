package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test implicit conversion
 * 
 * 	@author VinceYuan
 */
class ScalaDeveloper(val developer: Developer) {
  
  def getScalaDeveloperInfo() = {
    "ScalaDeveloper[id=" + developer.id + ", name=" + developer.name + ", gender=" + developer.gender + "]"
  }
}
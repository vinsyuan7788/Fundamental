package org.lang.scala.conclusion.design.facade.conversion.classes

/**
 * 	This is a stand-alone class to test facade pattern on implicit conversions
 * 
 * 	@author VinceYuan
 */
class ScalaDeveloper(val developer: Developer) {
  
  def getInfo() = {
    "ScalaDeveloper[id=" + developer.id + ", name=" + developer.name + ", gender=" + developer.gender + "]"
  }
}
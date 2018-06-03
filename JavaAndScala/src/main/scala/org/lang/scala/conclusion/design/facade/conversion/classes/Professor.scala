package org.lang.scala.conclusion.design.facade.conversion.classes

/**
 * 	This is a stand-alone class to test facade pattern on implicit conversions
 * 
 * 	@author VinceYuan
 */
class Professor(val teacher: Teacher) {
  
  def getInfo() = {
    "Professor[id=" + teacher.id + ", name=" + teacher.name + ", gender=" + teacher.gender + "]"
  }
}
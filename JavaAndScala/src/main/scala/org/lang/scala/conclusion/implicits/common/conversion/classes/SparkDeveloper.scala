package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test implicit conversion
 * 
 * 	@author VinceYuan
 */
class SparkDeveloper(val developer: Developer) {
  
  def getSparkDeveloperInfo() = {
    "SparkDeveloper[id=" + developer.id + ", name=" + developer.name + ", gender=" + developer.gender + "]"
  }
}
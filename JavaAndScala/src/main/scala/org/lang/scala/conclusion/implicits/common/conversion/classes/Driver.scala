package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test self implicit conversion
 * 
 * 	@author VinceYuan
 */
class Driver[T <: DriverInfo](val instance: T) {
  
  def getDriverInfo() = {
    println(s"Driver[id=${instance.id}, name=${instance.name}, age=${instance.age}]")
  }
}
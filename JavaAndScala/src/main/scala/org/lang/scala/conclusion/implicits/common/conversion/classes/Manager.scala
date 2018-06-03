package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test polymorphism of implicit conversion
 * 
 * 	@author VinceYuan
 */
class Manager[T <: ManagerInfo](val managerInfo: T) {
  
  def getManagerInfo() = {
    println(s"Manager[id=${managerInfo.id}, name=${managerInfo.name}, age=${managerInfo.age}]")
  }
}
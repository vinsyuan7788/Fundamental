package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test self implicit conversion
 * 
 * 	@author VinceYuan
 */
class Student {
  
  var id: String = _
  var name: String = _
  var age: Int = _
  
  def this(id: String, name: String, age: Int) = {
    this()
    this.id = id
    this.name = name
    this.age = age
  }
  
  def getStudentInfo() = {
    println(s"Student[id=${id}, name=${name}, age=${age}]")
  }
}
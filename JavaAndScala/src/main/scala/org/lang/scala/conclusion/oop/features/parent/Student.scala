package org.lang.scala.conclusion.oop.features.parent

import java.util.UUID

/**
 * 	This is a stand-alone object to test OOP
 * 	-- There are 1 primary constructor and 2 auxiliary constructors
 *     -- The primary constructor is parameterless
 *     -- The auxiliary constructors have parameter list (name, age) and (id, name, age)
 * 
 * 	@author VinceYuan
 */
class Student {
  
  var id: String = _
  var name: String = _
  var age: Int = _
  
  /*	Auxiliary constructors	*/  
  def this(name: String, age: Int) = {
    this()
    this.name = name
    this.age = age
  }
  def this(id: String, name: String, age: Int) = {
    this()
    this.id = id
    this.name = name
    this.age = age    
  }
  
  def getInfo() = {
    println(s"Student[id=${id}, name=${name}, age=${age}]")
  }
}
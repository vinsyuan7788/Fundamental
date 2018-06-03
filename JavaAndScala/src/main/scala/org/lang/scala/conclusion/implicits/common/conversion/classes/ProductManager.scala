package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a stand-alone class to test polymorphism of implicit conversion
 * 
 * 	@author VinceYuan
 */
class ProductManager extends ManagerInfo {
  
  def this(id: String, name: String, age: Int) = {
    this()
    this.id = id
    this.name = name
    this.age = age
  }
}
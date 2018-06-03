package org.lang.scala.conclusion.generics.common.bound.classes

/**
 * 	This is a stand-alone class to test bound
 * 
 * 	@author VinceYuan
 */
class Customer {

  var id: String = _
  var name: String = _
  var age: Int = _
  
  override def toString() = {
    "Customer[id=" + id + ", name=" + name + ", age=" + age + "]"
  }
}
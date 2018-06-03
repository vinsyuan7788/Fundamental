package org.lang.scala.conclusion.generics.common.bound.classes

/**
 * 	This is a stand-alone class to test bound
 * 
 * 	@author VinceYuan
 */
class Student {

  var id: String = _
  var name: String = _
  var score: Double = _
  
  override def toString() = {
    "Student[id=" + id + ", name=" + name + ", score=" + score + "]"
  }
}
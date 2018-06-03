package org.lang.scala.conclusion.oop.features

import org.lang.scala.conclusion.oop.features.parent.Mammal

/**
 * 	This is a stand-alone object to test OOP
 * 
 * 	@author VinceYuan
 */
object Educator extends Mammal {
  
  /*	Instance variables	*/
  var id: String = _
  var username: String = _ 
  var gender: Char = _
  var salary: Double = _
  
  /*	Instance methods	*/
  def apply() = {
    Educator
  }
  def apply(id: String, username: String, gender: Char, salary: Double) = {
    this.id = id
    this.username = username
    this.gender = gender
    this.salary = salary
    Educator
  }
}
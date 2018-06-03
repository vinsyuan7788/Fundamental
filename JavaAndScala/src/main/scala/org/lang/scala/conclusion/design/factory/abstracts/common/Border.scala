package org.lang.scala.conclusion.design.factory.abstracts.common

/**
 * 	This is an abstract class to be used to test the implementation of abstract factory pattern
 *  -- This class must be inherited by its child classes
 *  
 * 	@author VinceYuan
 */
abstract class Border {
  
  /*	Instance variables	*/
  var name: String = _
  var brand: String = _
  var color: String = _
  
  /*	Instance methods	*/
  def flash(): Unit = {
    println("A border is flashing...")
  }
  
  /*	Abstract methods	*/
  def scroll(): Unit
}
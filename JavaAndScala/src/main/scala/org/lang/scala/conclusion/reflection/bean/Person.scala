package org.lang.scala.conclusion.reflection.bean

import java.util.UUID

import org.lang.scala.conclusion.reflection.bean.parent.Human
import org.lang.scala.conclusion.reflection.bean.parent.Survive
import org.lang.scala.conclusion.reflection.annotation.GetClassName
import org.lang.scala.conclusion.reflection.annotation.IsSingleton
import org.lang.scala.conclusion.reflection.annotation.GetMethodName
import org.lang.scala.conclusion.reflection.annotation.SetFieldValue
import org.lang.scala.conclusion.reflection.annotation.GetObjectName

/**
 * 	This is a companion class to test reflection
 * 	-- Companion class can be reflected through reflection
 * 
 * 	@author VinceYuan
 */
@GetClassName(true, "PersonClass")
@IsSingleton(false)
class Person extends Human with Survive {
  
  /*	Instance variables	*/
  @SetFieldValue(UUID.randomUUID().toString()) var id: String = _
  @SetFieldValue("Vince") var name: String = _
  @SetFieldValue(27) var age: Int = _
  @SetFieldValue('M') var gender: Char = _
  
  /*	Inherited methods to be overridden	*/
  @GetMethodName(true)
  override def live(name: String, age: Int, gender: Char, race: String): Unit = {
    println("A Person[name=" + name + ", age=" + age + ", gender=" + gender + ", race=" + race + "] is living happily...")
  }
  @GetMethodName(false)
  override def study(id: String, name: String): Unit = {
    println("A Person[id=" + id + ", name=" + name + "] is studying new technologies...")
  }
  
  /*	For readability	 */
  override def toString(): String = {
    "Person[id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", race=" + race + "]"
  }
}

/**
 * 	This is a companion object to test reflection
 *  -- Companion object can be reflected through reflection
 * 
 * 	@author VinceYuan
 */
@GetObjectName(true, "PersonObject")
@IsSingleton(true)
object Person extends Human with Survive {
  
  /*	Instance variables	*/
  @SetFieldValue("CHN")
  var location: String = _
  
  /*	Inherited methods to be overridden	*/
  @GetMethodName(false)
  override def live(name: String,age: Int,gender: Char,race: String): Unit = {
    println("A Person[name=" + name + ", age=" + age + ", gender=" + gender + ", race=" + race + "] is living happily...")
  }
  @GetMethodName(true)
  override def study(id: String,name: String): Unit = {
    println("A Person[id=" + id + ", name=" + name + "] is studying new technologies...")
  }
  
  /*	For readability	 */
  override def toString(): String = {
    "Person[location=" + location + ", race=" + race + "]"
  }
}
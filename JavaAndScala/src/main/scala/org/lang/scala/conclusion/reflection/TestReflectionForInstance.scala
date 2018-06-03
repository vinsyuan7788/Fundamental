package org.lang.scala.conclusion.reflection

import java.util.UUID

import scala.reflect.runtime.universe._
import scala.reflect.runtime.universe.typeOf

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.reflection.bean.Person
import org.lang.scala.conclusion.reflection.bean.Customer

/**
 * 	This is a stand-alone object to test reflection for instance
 *  -- It includes instantiation, which includes setting and getting fields, invoking methods
 * 	-- If using reflection to get an instance from a stand-alone or companion object, the instance type is "Any", which is NOT desirable
 * 		 -- This is a problem for Scala reflection: how to get the type of an object
 * 
 * 	@author VinceYuan
 */
object TestReflectionForInstance {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests reflection for isntance of class:")
    testReflectionForInstanceOfClass()
    println("\nHere tests reflection for instance of companion object:")
    testReflectionForInstanceOfCompanionObject()
    println("\nHere tests reflection for instance of stand-alone object:")
    testReflectionForInstanceOfStandaloneObject()
  }
  
  /**
   * 	This is a method to test reflection for instance of a class
   */
  private def testReflectionForInstanceOfClass(): Unit = {
  
    /*	Using reflection to get an instance from a class	*/
    println("Using reflection to get an instance from a class:")
    val person = ReflectionUtils.getInstanceFromClass[Person]
    println(person)
    println(ReflectionUtils.getRuntimeType(person))
    val person1 = ReflectionUtils.getInstanceFromClass[Person]("org.lang.scala.conclusion.reflection.bean.Person")
    println(person)
    println(ReflectionUtils.getRuntimeType(person))
    
    /*	Using reflection to set and get field values	*/
    println("\nUsing reflection to set and get field values:")
    ReflectionUtils.setField(person)("id")(UUID.randomUUID().toString())
    ReflectionUtils.setField(person)("name")("Vince")
    ReflectionUtils.setField(person)("age")(27)
    ReflectionUtils.setField(person)("gender")('M')
    println(ReflectionUtils.getField(person)("id"))
    println(ReflectionUtils.getField(person)("name"))
    println(ReflectionUtils.getField(person)("age"))
    println(ReflectionUtils.getField(person)("gender"))
    println(person)
    
    /*	Using reflection to invoke methods	*/
    println("\nUsing reflection to invoke methods:")
    ReflectionUtils.invokeMethod(person)("live")(person.name, person.age, person.gender, person.race)
    ReflectionUtils.invokeMethod(person)("study")(person.id, person.name)
    ReflectionUtils.invokeMethod(person)("id_$eq")(UUID.randomUUID().toString())
    ReflectionUtils.invokeMethod(person)("name_$eq")("Violet")
    ReflectionUtils.invokeMethod(person)("age_$eq")(25)
    ReflectionUtils.invokeMethod(person)("gender_$eq")('F')
    println(ReflectionUtils.invokeMethod(person)("toString")(null))
  }
  
  /**
   * 	This is a method to test reflection for instance of a companion object
   */
  private def testReflectionForInstanceOfCompanionObject(): Unit = {
    
    /*	
     * 	Using reflection to get an instance from a companion object
     * 	-- Using this way, the instance type is "Any", which is NOT desirable
     */
    println("Using reflection to get an intance from a companion object:")
    val person = ReflectionUtils.getInstanceFromCompanionObject[Person]
    println(person)
    println(ReflectionUtils.getRuntimeType(person))      // "Any", which is NOT desirable
    val person1 = ReflectionUtils.getInstanceFromObejct("org.lang.scala.conclusion.reflection.bean.Person");
    println(person1)
    println(ReflectionUtils.getRuntimeType(person1))     // "Any", which is NOT desirable
    val person2 = Person
    println(person2)
    println(ReflectionUtils.getRuntimeType(person2))
    println(typeOf[Person].companion)

    /*	Using reflection to set and get field values	*/
    println("\nUsing reflection to set and get field values:")
    ReflectionUtils.setField(person2)("location")("USA")
    println(ReflectionUtils.getField(person2)("location"))
    println(person2)
    
    /*	Using reflection to invoke methods	*/
    println("\nUsing reflection to invoke methods:")
    ReflectionUtils.invokeMethod(person2)("live")("Johnny", 27, 'M', person2.race)
    ReflectionUtils.invokeMethod(person2)("study")(UUID.randomUUID().toString(), "Kelly")
    ReflectionUtils.invokeMethod(person2)("location_$eq")("CHN")
    println(ReflectionUtils.invokeMethod(person2)("toString")(null))
  }
  
  /**
   * 	This is a method to test reflection for instance of a stand-alone object
   */
  private def testReflectionForInstanceOfStandaloneObject(): Unit = {
    
    /*	
     * 	Using reflection to get an instance from a companion object
     * 	-- Using this way, the instance type is "Any", which is NOT desirable
     */
    println("Using reflection to get an intance from a stand-alone object:")
    val customer = ReflectionUtils.getInstanceFromObejct("org.lang.scala.conclusion.reflection.bean.Customer");
    println(customer)
    println(ReflectionUtils.getRuntimeType(customer))     // "Any", which is NOT desirable
    val customer2 = Customer
    println(customer2)
    println(ReflectionUtils.getRuntimeType(customer2))

    /*	Using reflection to set and get field values	*/
    println("\nUsing reflection to set and get field values:")
    ReflectionUtils.setField(customer2)("location")("USA")
    println(ReflectionUtils.getField(customer2)("location"))
    println(customer2)
    
    /*	Using reflection to invoke methods	*/
    println("\nUsing reflection to invoke methods:")
    ReflectionUtils.invokeMethod(customer2)("live")("Johnny", 27, 'M', customer2.race)
    ReflectionUtils.invokeMethod(customer2)("study")(UUID.randomUUID().toString(), "Kelly")
    ReflectionUtils.invokeMethod(customer2)("location_$eq")("CHN")
    println(ReflectionUtils.invokeMethod(customer2)("toString")(null))
  }
}
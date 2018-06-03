package org.lang.scala.conclusion.implicits.common.conversion.classes

import scala.reflect.runtime.universe._

/**
 * 	This is a companion class to test self implicit conversion
 * 
 * 	@author VinceYuan
 */
class UberDriver extends DriverInfo {
  
  def this(id: String, name: String, age: Int) = {
    this()
    this.id = id
    this.name = name
    this.age = age
  }
}

/**
 * 	This is a companion object to test self implicit conversion
 * 
 * 	@author VinceYuan
 */
object UberDriver {
  
  /**
   * 	After creating a Graduate instance, "implicit f: T => UberDriver" refers to "UberDriver => UberDriver"
   *  -- Namely instantiation of UberDriver is actually a self implicit conversion "UberDriver => UberDriver"
   */
  implicit def toDriver[T <: DriverInfo : TypeTag](instance: T)(implicit conversion: T => UberDriver) = {
    println(s"""When impliclit conversion, \"T\" in \"implicit conversion: T => UberDriver\" refers to ${typeTag[T].tpe}""")
    new Driver(instance)
  }
  // Above implicit method is equivalent to below implicit method (without involving self implicit conversion)
//  implicit def toDriver(instance: UberDriver) = new Driver(instance)
}
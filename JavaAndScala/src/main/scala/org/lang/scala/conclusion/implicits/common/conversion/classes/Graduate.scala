package org.lang.scala.conclusion.implicits.common.conversion.classes

import scala.reflect.runtime.universe._

/**
 * 	This is a companion class to test self implicit conversion
 * 
 * 	@author VinceYuan
 */
class Graduate {
  
  var id: String = _
  var name: String = _
  var age: Int = _
  
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
object Graduate {
  
  /**
   * 	After creating a Graduate instance, "implicit f: T => Graduate" refers to "Graduate => Graduate"
   *  -- Namely instantiation of Graduate is actually a self implicit conversion "Graduate => Graduate"
   */
  implicit def toStudent[T : TypeTag](instance: T)(implicit conversion: T => Graduate) = {
    println(s"""When impliclit conversion, \"T\" in \"implicit conversion: T => Gradudate\" refers to ${typeTag[T].tpe}""")
    new Student(instance.id, instance.name, instance.age)
  }
  // Above implicit method is equivalent to below implicit method (without involving self implicit conversion)
//  implicit def toStudent(instance: Graduate) = new Student(instance.id, instance.name, instance.age)
}
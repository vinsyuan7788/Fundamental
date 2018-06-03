package org.lang.scala.conclusion.implicits.common.conversion.classes

import scala.reflect.runtime.universe._

/**
 * 	This is a companion class to test polymorphism of implicit conversion
 * 
 * 	@author VinceYuan
 */
class Daughter extends FamilyMemberInfo {
  
  def this(id: String, name: String, age: Int) = {
    this()
    this.id = id
    this.name = name
    this.age = age
  }
}

/**
 * 	This is a companion object to test polymorphism of implicit conversion
 * 
 * 	@author VinceYuan
 */
object Daughter {
  
  /**
   * 	This is an implicit method to convert Daughter instance to a FamilyMember instance with self implicit conversion
   */
  implicit def toFamilyMember[T <: FamilyMemberInfo : TypeTag](instance: T)(implicit conversion: T => Daughter) = {
    println(s"""When impliclit conversion, \"T\" in \"implicit conversion: T => Daughter\" refers to ${typeTag[T].tpe}""")
    new FamilyMember(instance)
  }
  // Above implicit method is equivalent to below implicit method (without involving self implicit conversion)
//  implicit def toFamilyMember(instance: Daughter) = new FamilyMember(instance)
}
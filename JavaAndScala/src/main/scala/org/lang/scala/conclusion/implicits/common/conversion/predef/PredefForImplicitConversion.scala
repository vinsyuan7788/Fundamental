package org.lang.scala.conclusion.implicits.common.conversion.predef

import scala.reflect.runtime.universe._
import org.lang.scala.conclusion.implicits.common.conversion.classes.ManagerInfo
import org.lang.scala.conclusion.implicits.common.conversion.classes.Manager

/**
 * 	This is a stand-alone object to test implicit conversion
 * 
 * 	@author VinceYuan
 */
object PredefForImplicitConversion {
  
  /**
   * 	This is a method to implicitly convert any class T inheriting a parent class (ManagerInfo) to a specific new class (Manager)
   *  -- With involving self implicit conversion
   */
  implicit def toManager[T <: ManagerInfo : TypeTag, C : TypeTag](instance: T)(implicit conversion: T => C) = {
    println(s""""When impliclit conversion, \"T\" in \"implicit conversion: T => C\" refers to ${typeTag[T].tpe} and \"C\" refers to ${typeTag[C].tpe}""")
    new Manager(instance)
  }
  // Above implicit method is equivalent to below implicit method (without involving self implicit conversion)
//  implicit def toManager[T <: ManagerInfo](instance: T) = new Manager(instance)
}
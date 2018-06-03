package org.lang.scala.conclusion.design.factory.method

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

/**
 * 	This is a trait to be used to implement factory method pattern
 *  -- This trait must be implemented by its child classes
 *  
 *  @author VinceYuan
 */
trait ConfigurationFactory {
  
  def getInstanceByJavaReflection(configFileName: String): Any
  def getInstanceByScalaReflection[T : TypeTag : ClassTag](configFileName: String): Any
}
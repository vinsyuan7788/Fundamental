package org.lang.scala.conclusion.generics.variance

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.generics.common.variance.classes.Developer
import org.lang.scala.conclusion.generics.common.variance.classes.ScalaDeveloper
import org.lang.scala.conclusion.generics.common.variance.classes.SparkDeveloper
import org.lang.scala.conclusion.generics.variance.contravariance.Factory

/**
 * 	This is a stand-alone object to test contravariance
 *  -- Generics type (T) and container type (C[T]) are different bounds: one upper one lower, or one lower one upper
 *     
 * 	Contravariance application scenario:
 *  -- Usually used to restrict the INPUT container type for methods or functions at compile-time
 *     -- The generics argument of INPUT container type Must be lower-bound (*****)
 *     -- If the restriction is violated, it will pop out a "type mismatch" error at compile-time
 *  -- To restrict the output container type from a method or function at compile-time
 *     -- The generics argument of output container type MUST be upper-bound
 *     -- If the restriction is violated, it will pop out a "type mismatch" error at compile-time
 *     -- Conventionally this job is done by covariance
 *     
 * 	@author VinceYuan
 */
object TestContravariance {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here demonstrates contravariance basics:")
    testContravarianceBasics()
    println("\nHere demonstrates contravariance application:")
    testContravarianceApplication()
  }
  
  /**
   * 	This is a method to test contravariance basics
   */
  private def testContravarianceBasics(): Unit = {
    
    /*	
     * 	Contravariance basics
     *  -- Generics type (T) and container type (C[T]) are different bounds: one upper one lower, or one lower one upper
     *     -- E.g., SparkDeveloper <: ScalaDeveloper ---> Factory[ScalaDeveloper] <: Factory[SparkDeveloper]
     */
    val scalaDeveloper = new ScalaDeveloper()
    val sparkDeveloper = new SparkDeveloper()
    val scalaDeveloperFactory = new Factory[ScalaDeveloper]
    val sparkDeveloperFactory = new Factory[SparkDeveloper]
    println("Factory[ScalaDeveloper] type: " + ReflectionUtils.getRuntimeType(scalaDeveloperFactory))
    println("Factory[SparkDeveloper] type: " + ReflectionUtils.getRuntimeType(sparkDeveloperFactory))
    println("If SparkDeveloper <: ScalaDeveloper? " + (ReflectionUtils.getRuntimeType(sparkDeveloper) <:< ReflectionUtils.getRuntimeType(scalaDeveloper)))
    println("If Facotry[ScalaDeveloper] <: Factory[SparkDeveloper]? " + (ReflectionUtils.getRuntimeType(scalaDeveloperFactory) <:< ReflectionUtils.getRuntimeType(sparkDeveloperFactory)))
  }
  
  /**
   * 	This is a method to test contravariance application scenario
   */
  private def testContravarianceApplication(): Unit = {
        
    /*	For INPUT type restriction	*/
    Factory.install(new Factory[Developer]())   
    Factory.install(new Factory[ScalaDeveloper]())
//    Factory.install(new Factory[SparkDeveloper]())    // Here will pop out an error
//    Factory.installAny(new Factory[Developer]())    
//    Factory.installAny(new Factory[ScalaDeveloper]())
//    Factory.installAny(new Factory[SparkDeveloper]())
    Factory.installNull(new Factory[Developer]())    
    Factory.installNull(new Factory[ScalaDeveloper]())
    Factory.installNull(new Factory[SparkDeveloper]())
    
    /*	For output type restriction	 */
//    val developerFactory: Factory[Developer] = Factory.uninstall()    // Here will pop out an error
    val scalaDeveloperFactory: Factory[ScalaDeveloper] = Factory.uninstall()
    val sparkDeveloperFactory: Factory[SparkDeveloper] = Factory.uninstall()
    val developerFactory_Any: Factory[Developer] = Factory.uninstallAny()    
    val scalaDeveloperFactory_Any: Factory[ScalaDeveloper] = Factory.uninstallAny()
    val sparkDeveloperFactory_Any: Factory[SparkDeveloper] = Factory.uninstallAny()
//    val developerFactory_Null: Factory[Developer] = Factory.uninstallNull()    
//    val scalaDeveloperFactory_Null: Factory[ScalaDeveloper] = Factory.uninstallNull()
//    val sparkDeveloperFactory_Null: Factory[SparkDeveloper] = Factory.uninstallNull()
  }
}
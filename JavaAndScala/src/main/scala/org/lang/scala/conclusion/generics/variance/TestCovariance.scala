package org.lang.scala.conclusion.generics.variance

import scala.reflect.runtime.universe

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.generics.common.variance.classes.Developer
import org.lang.scala.conclusion.generics.common.variance.classes.ScalaDeveloper
import org.lang.scala.conclusion.generics.common.variance.classes.SparkDeveloper
import org.lang.scala.conclusion.generics.variance.covariance.Factory

/**
 * 	This is a stand-alone object to test covariance
 *  -- Generics type (T) and container type (C[T]) are the same bound: both upper or lower
 * 
 * 	Covariance application scenario:
 *  -- Usually used to restrict the OUTPUT container type from a method or function at compile-time
 *     -- The generics argument of OUTPUT container type MUST be lower-bound (*****)
 *     -- If the restriction is violated, it will pop out a "type mismatch" error at compile-time
 *  -- To restrict the input container type for methods or functions at compile-time
 *     -- The generics argument of input container type MUST be upper-bound
 *     -- If the restriction is violated, it will pop out a "type mismatch" error at compile-time
 *     -- Conventionally this job is done by contravariance
 * 
 * 	@author VinceYuan
 */
object TestCovariance {
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here demonstrates covariance basics:")
    testCovarianceBasics()
    println("\nHere demonstrates covariance application:")
    testCovarianceApplication()
  }
  
  /**
   * 	This is a method to test covariance basics
   */
  private def testCovarianceBasics(): Unit = {
    
    /*	
     * 	Covariance basics	
     *  -- Generics type (T) and container type (C[T]) are the same bound: both upper or lower
     *     -- E.g., SparkDeveloper <: ScalaDeveloper ---> Factory[SparkDeveloper] <: Factory[ScalaDeveloper]
     */
    val scalaDeveloper = new ScalaDeveloper()
    val sparkDeveloper = new SparkDeveloper()
    val scalaDeveloperFactory = new Factory[ScalaDeveloper]
    val sparkDeveloperFactory = new Factory[SparkDeveloper]
    println("Factory[ScalaDeveloper] type: " + ReflectionUtils.getRuntimeType(scalaDeveloperFactory))
    println("Factory[SparkDeveloper] type: " + ReflectionUtils.getRuntimeType(sparkDeveloperFactory))
    println("If SparkDeveloper <: ScalaDeveloper? " + (ReflectionUtils.getRuntimeType(sparkDeveloper) <:< ReflectionUtils.getRuntimeType(scalaDeveloper)))
    println("If Facotry[SparkDeveloper] <: Factory[ScalaDeveloper]? " + (ReflectionUtils.getRuntimeType(sparkDeveloperFactory) <:< ReflectionUtils.getRuntimeType(scalaDeveloperFactory)))
  }
  
  /**
   * 	This is a method to test covariance application scenario
   */
  private def testCovarianceApplication(): Unit = {
    
    /*	For input type restriction	*/
//    Factory.install(new Factory[Developer]())    // Here will pop out an error
    Factory.install(new Factory[ScalaDeveloper]())
    Factory.install(new Factory[SparkDeveloper]())
    Factory.installAny(new Factory[Developer]())    
    Factory.installAny(new Factory[ScalaDeveloper]())
    Factory.installAny(new Factory[SparkDeveloper]())
//    Factory.installNull(new Factory[Developer]())    
//    Factory.installNull(new Factory[ScalaDeveloper]())
//    Factory.installNull(new Factory[SparkDeveloper]())
    
    /*	For OUTPUT type restriction	 */
    val developerFactory: Factory[Developer] = Factory.uninstall()    
    val scalaDeveloperFactory: Factory[ScalaDeveloper] = Factory.uninstall()
//    val sparkDeveloperFactory: Factory[SparkDeveloper] = Factory.uninstall()    // Here will pop out an error
//    val developerFactory_Any: Factory[Developer] = Factory.uninstallAny()    
//    val scalaDeveloperFactory_Any: Factory[ScalaDeveloper] = Factory.uninstallAny()
//    val sparkDeveloperFactory_Any: Factory[SparkDeveloper] = Factory.uninstallAny()
    val developerFactory_Null: Factory[Developer] = Factory.uninstallNull()    
    val scalaDeveloperFactory_Null: Factory[ScalaDeveloper] = Factory.uninstallNull()
    val sparkDeveloperFactory_Null: Factory[SparkDeveloper] = Factory.uninstallNull()
  }
}
package org.lang.scala.conclusion.generics.variance.covariance

import org.lang.scala.conclusion.generics.common.variance.classes.ScalaDeveloper

/**
 * 	This is a companion class to test covariance
 *  -- If container type (C[T]) and generics type (T) should be the same bound (both lower or upper)
 *     -- Using covariance (namely "+") 
 * 	
 * 	@author VinceYuan
 */
class Factory[+T] {
  
}

/**
 * 	This is a companion object to test covariance
 * 
 * 	@author VinceYuan
 */
object Factory {
  
  /**
   * 	As input container type, Factory[ScalaDeveloper] (or C[T]) is upper-bound (*****), because:
   *  -- All input container types must be compatible with "Factory[ScalaDeveloper]"
   *     -- Hence all input container types must be the sub-types of "Factory[ScalaDeveloper]" according to OOP polymorphism
   *  Since:
   *  -- Expected input container type: Factory[SparkDeveloper], Factory[ScalaDeveloper], ...
   *  -- Generics argument "ScalaDevloper" (or T) is upper-bound in [SparkDeveloper, ScalaDeveloper, ...]
   *  Hence can use covariance
   */
  def install(factory: Factory[ScalaDeveloper]) = {
    println("The factory has been installed...")
  }
  
  /**
   * 	This method demonstrates covariance can restrict NO container types on input at compile-time
   */
  def installAny(factory: Factory[Any]) = {
    println("The factory has been installed...")
  }
  
  /**
   * 	This method demonstrates covariance can restrict ALL container types on input at compile-time
   */
  def installNull(factory: Factory[Null]) = {
    println("The factory has been installed...")
  }
  
  /**
   * 	As output container type, Factory[ScalaDeveloper] (or C[T]) is lower-bound (*****), because
   *  -- All output container types must be compatible with "Factory[ScalaDeveloper]"
   *     -- Hence all output container types must be the super-types of "Factory[ScalaDeveloper]" according to OOP polymorphism
   *  Since:
   *  -- Expected output container type: Factory[Developer], Factory[ScalaDeveloper], ...
   *  -- Generics argument "ScalaDevloper" (or T) is lower-bound in [Developer, ScalaDeveloper, ...]
   *  Hence can use covariance
   * 
   *  Generally the specified generic argument is lower-bound (*****)
   *  -- Hence conventionally covariance is used on output
   */
  def uninstall() = {
    println("The factory has been uninstalled...")
    new Factory[ScalaDeveloper]
  }
  
  /**
   * 	This method demonstrates covariance can restrict ALL container types on output at compile-time
   */
  def uninstallAny() = {
    println("The factory has been uninstalled...")
    new Factory[Any]
  }

  /**
   * 	This method demonstrates covariance can restrict NO container types on output at compile-time
   */
  def uninstallNull() = {
    println("The factory has been uninstalled...")
    new Factory[Null]
  }
}
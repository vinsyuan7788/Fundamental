package org.lang.scala.conclusion.generics.variance.contravariance

import org.lang.scala.conclusion.generics.common.variance.classes.ScalaDeveloper

/**
 * 	This is a companion class to test contravariance
 *  -- If container type (C[T]) and generics type (T) should be different bounds (one lower one upper, or one upper one lower)
 *     -- Using contravariance (namely "-") 
 * 
 * 	@author VinceYuan
 */
class Factory[-T] {

}

/**
 * 	This is a companion object to test contravariance
 * 
 * 	@author VinceYuan
 */
object Factory {
  
  /**
   * 	As input container type, Factory[ScalaDeveloper] (or C[T]) is upper-bound (*****), because:
   *  -- All input container types must be compatible with "Factory[ScalaDeveloper]"
   *     -- Hence all input container types must be the sub-types of "Factory[ScalaDeveloper]" according to OOP polymorphism
   *  Since:
   *  -- Expected input container type: Factory[Developer], Factory[ScalaDeveloper], ...
   *  -- Generics argument "ScalaDevloper" (or T) is lower-bound in [Developer, ScalaDeveloper, ...]
   *  Hence can use contravariance
   *  
   *  Generally the specified generic argument is lower-bound (*****)
   *  -- Hence conventionally contravariance is used on input
   */
  def install(factory: Factory[ScalaDeveloper]) = {
    println("The factory has been installed...")
  }
  
  /**
   * 	This method demonstrates contravariance can restrict ALL container types on input at compile-time
   */
  def installAny(factory: Factory[Any]) = {
    println("The Factory[Any] has been installed...")
  }
  
  /**
   * 	This method demonstrates contravariance can restrict NO container types on input at compile-time
   */
  def installNull(factory: Factory[Null]) = {
    println("The factory has been installed...")
  }
  
  /**
   * 	As output container type, Factory[ScalaDeveloper] (or C[T]) is lower-bound (*****), because
   *  -- All output container types must be compatible with "Factory[ScalaDeveloper]"
   *     -- Hence all output container types must be the super-types of "Factory[ScalaDeveloper]" according to OOP polymorphism
   *  Since:
   *  -- Expected container data type: Factory[SparkDeveloper], Factory[ScalaDeveloper], ...
   *  -- Generics argument "ScalaDevloper" (or T) is upper-bound in [SparkDeveloper, ScalaDeveloper, ...]
   *  Hence can use contravariance
   */
  def uninstall() = {
    println("The factory has been uninstalled...")
    new Factory[ScalaDeveloper]
  }
  
  /**
   * 	This method demonstrates contravariance can restrict NO container types on output at compile-time
   */
  def uninstallAny() = {
    println("The factory has been uninstalled...")
    new Factory[Any]
  }

  /**
   * 	This method demonstrates contravariance can restrict ALL container types on output at compile-time
   */
  def uninstallNull() = {
    println("The factory has been uninstalled...")
    new Factory[Null]
  }
}
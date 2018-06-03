package org.lang.scala.conclusion.generics.common.bound.classes

/**
 * 	This is a stand-alone class to test bound
 * 	-- SparkDeveloper <: ScalaDeveloper <: Developer
 * 
 * 	@author VinceYuan
 */
class SparkDeveloper extends ScalaDeveloper {

  override def toString() = {
    "SparkDeveloper"
  }
}
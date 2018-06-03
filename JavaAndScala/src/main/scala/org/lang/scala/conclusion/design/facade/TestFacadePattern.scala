package org.lang.scala.conclusion.design.facade

import org.lang.scala.conclusion.design.facade.chain.TestFacadeOnImplicitChains
import org.lang.scala.conclusion.design.facade.conversion.TestFacadeOnImplicitConversions
import org.lang.scala.conclusion.design.facade.parameter.TestFacadeOnImplicitParameters

/**
 * 	This is a stand-alone object to test facade pattern
 * 
 * 	@author VinceYuan
 */
object TestFacadePattern {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here demonstrates facade pattern on implicit parameters:")
    TestFacadeOnImplicitParameters.main(args)
    println("\nHere demonstrates facade pattern on implicits conversions:")
    TestFacadeOnImplicitConversions.main(args)
    println("\nHere demonstrates facade pattern on implicit chains:")
    TestFacadeOnImplicitChains.main(args)
  }
}
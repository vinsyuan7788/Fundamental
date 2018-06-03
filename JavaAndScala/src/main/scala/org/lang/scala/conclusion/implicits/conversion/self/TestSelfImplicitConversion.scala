package org.lang.scala.conclusion.implicits.conversion.self

import java.util.UUID

import scala.reflect.runtime.universe

import org.lang.scala.conclusion.implicits.common.conversion.classes.Graduate
import org.lang.scala.conclusion.implicits.common.conversion.classes.Graduate.toStudent
import org.lang.scala.conclusion.implicits.common.conversion.classes.UberDriver
import org.lang.scala.conclusion.implicits.common.conversion.classes.UberDriver.toDriver

/**
 * 	This is a stand-alone object to test self implicit conversion
 *  -- Instantiation of a class C is a self implicit conversion C => C
 *     -- Namely "implicit conversion: T => C" can refer to "C => C", which means T is C in this case
 *  -- Using self implicit conversion always involves the use of generics
 * 
 * 	@author VinceYuan
 */
object TestSelfImplicitConversion {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSelfImplicitConversion()
  }
  
  /**
   * 	This is a method to test self implicit conversion
   */
  private def testSelfImplicitConversion(): Unit = {
    
    val vince = new Graduate(UUID.randomUUID().toString(), "Vince", 26)
    val violet = new Graduate(UUID.randomUUID().toString(), "Violet", 25)
    vince.getStudentInfo()
    violet.getStudentInfo()
    println()
    
    val johnny = new UberDriver(UUID.randomUUID().toString(), "Johnny", 24)
    val tony = new UberDriver(UUID.randomUUID().toString(), "Tony", 25)
    johnny.getDriverInfo()
    tony.getDriverInfo()
  }
}
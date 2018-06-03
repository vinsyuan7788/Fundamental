package org.lang.scala.conclusion.implicits.conversion

import java.util.UUID

import scala.reflect.runtime.universe

import org.lang.scala.conclusion.implicits.common.conversion.classes.ProductManager
import org.lang.scala.conclusion.implicits.common.conversion.classes.ProjectManager
import org.lang.scala.conclusion.implicits.common.conversion.classes.TechniqueManager
import org.lang.scala.conclusion.implicits.common.conversion.predef.PredefForImplicitConversion.toManager

/**
 * 	This is a stand-alone object to test implicit conversion from associated types
 *  -- Implicit conversion is a type auto-conversion by Scala, so that:
 *     -- A class (or type) can use the methods defined in another class (or type), etc.
 * 	-- To achieve implicit conversion: MUST define implicit methods or implicit functions, so that:
 *     -- The compiler is able to be aware of which class (or type) needs to be converted to which at compile-time
 *     -- Otherwise the compiler fails the check at compile-time when, e.g, using methods defined in another class (or type), etc.
 *  -- The implicit conversion is done whenever it is necessary
 *  -- Where the compiler searches implicits to be aware of type conversion:
 *     -- In this case, the compiler searches implicits from current scope
 *  
 * 	@author VinceYuan
 */
object TestImplicitConversionFromCurrentScope {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testImplicitConversionFromCurrentScope()
  }
  
  /**
   * 	This is a method to test implicit conversion from current scope
   */
  private def testImplicitConversionFromCurrentScope(): Unit = {

    val vince = new ProductManager(UUID.randomUUID().toString(), "Vince", 27)
    val violet = new ProjectManager(UUID.randomUUID().toString(), "Violet", 25)
    val johnny = new TechniqueManager(UUID.randomUUID().toString(), "Johnny", 29)
    vince.getManagerInfo()
    violet.getManagerInfo()
    johnny.getManagerInfo()
  }
}
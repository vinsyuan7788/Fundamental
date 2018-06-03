package org.lang.scala.conclusion.implicits.conversion

import java.util.UUID

import org.lang.scala.conclusion.implicits.common.conversion.classes.Developer
import org.lang.scala.conclusion.implicits.common.conversion.classes.Developer.toScalaDeveloper
import org.lang.scala.conclusion.implicits.common.conversion.classes.Developer.toSparkDeveloper.apply
import org.lang.scala.conclusion.implicits.common.conversion.classes.Money

/**
 * 	This is a stand-alone object to test implicit conversion from associated types
 *  -- Implicit conversion is a automatic type conversion by Scala, so that:
 *     -- A class (or type) can use the methods defined in another class (or type), etc.
 * 	-- To achieve implicit conversion: MUST define implicit methods or implicit functions, so that:
 *     -- The compiler is able to be aware of which class (or type) needs to be converted to which at compile-time
 *     -- Otherwise the compiler fails the check at compile-time when, e.g, using methods defined in another class (or type), etc.
 *  -- The implicit conversion is done whenever it is necessary
 *  -- Where the compiler searches implicits to be aware of type conversion:
 *     -- In this case, the compiler searches implicits from associated types
 *  
 * 	@author VinceYuan
 */
object TestImplicitConversionFromAssociatedType {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests implicit conversion from the companion object of current class:")
    testImplicitConversionFromCompanionObjectOfCurrentClass()
    println("\nHere tests implicit conversion from the companion object of argument's class:")
    testImplicitConversionFromCompanionObjectOfArgumentClass()
  }
  
  /**
   * 	This is a method to test implicit conversion for type auto-conversion from companion object of current class
   */
  private def testImplicitConversionFromCompanionObjectOfCurrentClass(): Unit = {
    
    val developer = new Developer()
    developer.id = UUID.randomUUID().toString()
    developer.name = "Vince"
    developer.gender = 'M'
    println(developer.getScalaDeveloperInfo())
    println(developer.getSparkDeveloperInfo())
  }

  /**
   * 	This is a method to test implicit conversion for type auto-conversion from companion object of argument class
   */
  private def testImplicitConversionFromCompanionObjectOfArgumentClass(): Unit = {
    
    val m1 = new Money(1)
    val m2 = 2
    val m3 = 3d
    val m4 = new Money(4)
    
    val sum1 = m1 + m2
    val sum2 = m3 + m4
    println(s"Sum of ${m1} and ${m2}: ${sum1}")
    println(s"Sum of ${m3} and ${m4}: ${sum2}")
  }
}
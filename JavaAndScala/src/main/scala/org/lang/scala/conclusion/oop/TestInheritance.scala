package org.lang.scala.conclusion.oop

import java.util.UUID

import org.lang.scala.conclusion.oop.features.Developer
import org.lang.scala.conclusion.oop.features.Educator
import org.lang.scala.conclusion.oop.features.Graduate
import org.lang.scala.conclusion.oop.features.PhD
import org.lang.scala.conclusion.oop.features.Sophomore
import org.lang.scala.conclusion.oop.features.TaxiDriver
import org.lang.scala.conclusion.oop.features.TruckDriver
import org.lang.scala.conclusion.oop.features.UberDriver

/**
 * 	This is a stand-alone object to test inheritance
 * 	-- Classes and objects can inherit classes (regular, abstract, case) and traits
 *  -- Only the primary constructor of the subclass can control the (primary and auxiliary) constructors of superclass
 *  -- Objects CANNOT be inherited
 * 
 * 	@author VinceYuan
 */
object TestInheritance {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests inheritance from abstract class:")
    testInheritanceFromAbstractClass()
    println("\nHere tests inheritance from case classes:")
    testInheritanceFromCaseClass()
    println("\nHere tests constructor inheritance of stand-alone class from super-class:")
    testConstructorInheritanceOfStandaloneClassFromSuperClass()
    println("\nHere tests constructor inheritance of companion class from super-class:")
    testConstructorInheritanceOfCompanionClassFromSuperClass()
  } 
  
  /**
   * 	This is a method to test inheritance from abstract class
   */
  private def testInheritanceFromAbstractClass(): Unit = {
    
    /*	Initialize 2 instances	*/
    val vince = new Developer(UUID.randomUUID().toString(), "Vince", 'M', 200000)
    val violet = new Developer(UUID.randomUUID().toString(), "Violet", 'F', 200000)
    
    /*	Invoke inherited variables, methods and utility methods	 */
    println(vince.race)
    println(violet.race)
    vince.eat()
    violet.eat()
    vince.sleep()
    violet.sleep()
    vince.work { x => x + " is working..." }
    violet.work { x => x + " is working too..." }
    vince.study { x => x + " is studying..." }
    vince.study { x => x + " is studying too..." }
    vince.learn()
    violet.learn()
  }
  
  /**
   * 	This is a method to test inheritance from case class
   */
  private def testInheritanceFromCaseClass(): Unit = {
    
    /*	Initialize an instance	*/
    val vince = Educator(UUID.randomUUID().toString(), "Vince", 'M', 200000)

    /*	Invoke inherited members	*/
    println(vince.race)
    vince.eat()
    vince.sleep()
  }
  
  /**
   * 	This is a method to test constructor inheritance of stand-alone sub-class from super-class
   */
  private def testConstructorInheritanceOfStandaloneClassFromSuperClass(): Unit = {
    
    /*	Instantiation of subclass will execute the primary constructor of superclass	*/
    val vince = new Graduate(UUID.randomUUID().toString(), "Vince", 27)
    vince.getInfo()
    
    /*	Instantiation of subclass will execute the 2-parameter auxiliary constructor of superclass	*/
    val violet = new PhD(UUID.randomUUID().toString(), "Violet", 25)
    violet.getInfo()
    
    /*	Instantiation of subclass will execute the 3-parameter auxiliary constructor of superclass	*/
    val johnny = new Sophomore(UUID.randomUUID().toString(), "Johnny", 20)
    johnny.getInfo()
  }
  
  /**
   * 	This is a method to test constructor inheritance of companion sub-class from super-class
   */
  private def testConstructorInheritanceOfCompanionClassFromSuperClass(): Unit = {
    
    /*	Instantiation of subclass will execute the primary constructor of superclass	*/
    val vince = TaxiDriver("Vince", 27)
    vince.getInfo()
    
    /*	Instantiation of subclass will execute the primary constructor of superclass	*/
    val violet = TruckDriver("Violet", 25)
    violet.getInfo()
    
    /*	Instantiation of subclass will execute the primary constructor of superclass	*/
    val johnny = UberDriver("Johnny", 20)
    johnny.getInfo()
  }
}
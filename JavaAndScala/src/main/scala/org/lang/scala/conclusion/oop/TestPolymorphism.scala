package org.lang.scala.conclusion.oop

import java.util.UUID

import org.lang.scala.conclusion.oop.features.Clerk
import org.lang.scala.conclusion.oop.features.Developer
import org.lang.scala.conclusion.oop.features.parent.Human

/**
 * 	This is a stand-alone object to test polymorphism
 * 
 * 	@author VinceYuan
 */
object TestPolymorphism {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testInstancePolymorphism()
  }
  
  /**
   * 	This is a method to test instance polymorphism
   */
  private def testInstancePolymorphism(): Unit = {
    
    /*	Initialize 2 instances	*/
    var vince: Human = new Developer(UUID.randomUUID().toString(), "Vince", 'M', 200000)
    var violet: Human = new Clerk(UUID.randomUUID().toString(), "Violet", 'F', 200000)
    
    /*	Invoke the inherited variables and methods	*/
    println(vince.race)
    println(vince.race)
    vince.eat()
    violet.eat()
    vince.sleep()
    violet.sleep()
  }
}
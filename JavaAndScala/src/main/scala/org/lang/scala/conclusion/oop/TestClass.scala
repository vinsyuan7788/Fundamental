package org.lang.scala.conclusion.oop

import org.lang.scala.conclusion.oop.classes.Businessman
import org.lang.scala.conclusion.oop.classes.parent.Mammal

/**
 * 	This is a stand-alone object to test class
 *  -- There are 2 ways of constructing instances from a class mechanically
 *     -- Using primary constructor
 *     -- Using auxiliary constructor
 *  
 *  For abstract class:
 *  -- Abstract class can have instance members to be inherited and instantiated
 *     -- Instance members include variables and methods
 *  -- Abstract class itself CANNOT be instantiated directly
 *     -- Unless implement unimplemented methods during instantiation
 * 
 * 	@author VinceYuan
 */
object TestClass {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests constructor:")
    testConstructor()
    println("\nHere test abstract class:")
    testAbstractClass()
  }
  
  /**
   * 	This is a method to test constructor
   */
  private def testConstructor(): Unit = {
    
    /*	Test primary constructors	 */
    println("Here demonstrates primary constructors:")
    val busiman1 = new Businessman("123456", "VinceYuan", 27, false)
    busiman1.gender = 'M'
    busiman1.income = 2000000d
    println(busiman1.race)
    println(busiman1)
    busiman1.eat()
    busiman1.sleep()
    busiman1.work { x => x + " is working..." }
    busiman1.study { x => x + " is studying..." }
    
    /*	Test auxiliary constructors	 */
    println("\nHere demonstrates auxiliary constructors:")
    val busiman2 = new Businessman()
    busiman2.gender = 'M'
    busiman2.income = 2000000d
    val busiman3 = new Businessman("Violet")
    busiman3.gender = 'F'
    busiman3.income = 2000000d
    val busiman4 = new Businessman("321654", "Johnny")
    busiman4.gender = 'M'
    busiman4.income = 2000000d
    println(busiman2)
    println(busiman3)
    println(busiman4)
  }
  
  /**
   * 	This is a method to test abstract class
   */
  private def testAbstractClass(): Unit = {
    
    /*	Instantiate an abstract class by implementing unimplemented methods	 */
    val mammal = new Mammal() {
      override def eat(): Unit = println("A mammal is eating...")
      override def sleep(): Unit = println("A mammal is sleeping...")
    }
    
    /*	Invoke methods	*/
    mammal.eat()
    mammal.sleep()
  }
}
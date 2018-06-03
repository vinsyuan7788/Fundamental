package org.lang.scala.conclusion.oop.traits

/**
 * 	This is a trait to be used to test OOP
 *  -- A trait that has implemented methods is a mixin
 *     -- Originally a mixin is a class that contains methods for use by other classes without having to be the parent class of those other classes
 *     -- But compiler using "class" to support mixin will cause the issue "multiple inheritance of state"
 *        -- Regarding "multiple inheritance of state" refers to "https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html"
 *     -- Hence generally PL (Programming Language) introduces another keyword to achieve the same effect that mixin brings
 *        -- E.g., "trait" in Scala, "interface" in Java and C#, etc. 
 * 
 * 	For method:
 *  -- Trait CAN have implemented methods inside it
 * 
 * 	@author VinceYuan
 */
trait Envolve extends Improve {
  
  def learn(): Unit = {
    println("Learning to envolve...")
  }
}
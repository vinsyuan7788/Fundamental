package org.lang.scala.conclusion.oop.function.iife

/**
 * 	This is a stand-alone object to test IIFE (Immediately-Invoked Function Expression)
 * 	-- Scala does NOT support IIFE so far
 * 
 * 	@author VinceYuan
 */
object TestIIFE {
  
  /*	Necessary instance variables	*/
  private type AddInt = (Int, Int) => Int
//  val iife: Int => AddInt = {
//    x => {
//      var a = x
//      var addOne: AddInt = {
//        (x, y) => x + 1
//      }
//      addOne
//    }
//  }(100)
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests closure:")
//    println(iife(100)(100, 10))
  }
}
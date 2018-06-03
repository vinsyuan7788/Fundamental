package org.scala.conclusion.structure.addableonly

import scala.Vector

/**
 * 	This is a stand-alone object to test Vector commonly-used operators
 *  -- Add: ":+"
 *  -- Add flatten: "++"
 *  -- Prepend: "+:"
 *  -- Prepend flatten: "++:"
 *   	
 * 	@author VinceYuan
 */
object TestVectorOperators {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testVectorOperators()
  }
  
  /**
   * 	This is a method to test Vector commonly-used operators
   */
  private def testVectorOperators(): Unit = {
    
    /*	This is a vector to store elements	*/
    var vector = Vector[Any]()
    
    /*
     * 	Append an element into a vector: ":+"
     * 	-- vector = vector + element
     *  -- vector += element
     */
    println("Append using \":+\"")
    vector = vector :+ "Hello Scala"
    println(vector)
    vector :+= "Hello Spark!"
    println(vector)
    vector = vector :+ Vector("GFriend", "FingerTip")
    println(vector)
    
    /*
     * 	Append a flatten element into a vector: "++"
     * 	-- vector = vector ++ element
     *  -- vector ++= element
     */
    println("Append using \"++\"")
    vector = vector ++ Vector("BlackPink", "Burn baby burn")
    println(vector)
    vector ++= Vector(321, 654)
    println(vector)
    
    /*
     * 	Prepend an element into an vector: "+:"
     *  -- vector = element +: vector 
     *  -- vector +:= (element) 
     */
    println("Prepend using \"+:\"")
    vector = "My Darling" +: vector
    println(vector)  
    vector +:= Vector(123)
    println(vector)  
    
    
    /*
     * 	Prepend a flatten element into a vector: "++:"
     *  -- vector = element ++: vector 
     *  -- vector ++:= (element) 
     */
    println("Prepend using \"++:\"")
    vector = Vector(456, 789) ++: vector
    println(vector)
    vector ++:= Vector("Lovelyz", "Wow")
    println(vector)
  }
}
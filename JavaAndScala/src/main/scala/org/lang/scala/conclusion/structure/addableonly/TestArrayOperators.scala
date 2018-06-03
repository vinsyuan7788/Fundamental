package org.scala.conclusion.structure.addableonly

/**
 * 	This is a stand-alone to test Array commonly-used operators
 *  -- Add: ":+"
 *  -- Add flatten: "++"
 *  -- Prepend: "+:"
 *  -- Prepend flatten: "++:"
 * 
 * 	@author VinceYuan
 */
object TestArrayOperators {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testArrayOperators()
  }
  
  /**
   * 	This is a method to test Array commonly-used operators
   */
  private def testArrayOperators(): Unit = {
    
    /*	This is an array to store elements	*/
    var array = Array[Any]()
    
    /*
     * 	Append an element into an array: ":+"
     * 	-- array = array :+ element
     *  -- array :+= element
     */
    println("Append using \":+\"")
    array = array :+ "Hello Scala"
    println(array.toBuffer)
    array :+= "Hello Spark!"
    println(array.toBuffer)
    array = array :+ Array("GFriend", "FingerTip").toBuffer
    println(array.toBuffer)
    
    /*
     * 	Append a flatten element into an array: "++"
     * 	-- array = array ++ element
     *  -- array ++= element
     */
    println("Append using \"++\"")
    array = array ++ Array("BlackPink", "Burn baby burn")
    println(array.toBuffer)
    array ++= List(321, 654)
    println(array)

    /*
     * 	Prepend an element into an array: "+:"
     *  -- array = element +: array 
     *  -- array +:= (element) 
     */
    println("Prepend using \"+:\"")
    array = "My Darling" +: array
    println(array.toBuffer)  
    array +:= Array(123).toBuffer
    println(array.toBuffer)  
    
    /*
     * 	Prepend a flatten element into an array: "++:"
     *  -- array = element ++: array 
     *  -- array ++:= (element) 
     */
    println("Prepend using \"++:\"")
    array = Array(456, 789) ++: array
    println(array.toBuffer)
    array ++:= Array("Lovelyz", "Wow")
    println(array.toBuffer)
  }
}
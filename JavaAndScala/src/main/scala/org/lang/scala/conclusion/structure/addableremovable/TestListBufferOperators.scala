package org.scala.conclusion.structure.addableremovable

import scala.collection.mutable.ListBuffer

/**
 * 	This is a stand-alone object to test ListBuffer commonly-used operators
 * 	-- Add: "+="
 *  -- Add flatten: "++="
 *  -- Prepend: "+:="
 *  -- Prepend flatten: "++:="
 *  -- Remove: "-="
 *  -- Remove flatten: "--="
 * 
 * 	@author VinceYuan
 */
object TestListBufferOperators {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testListBufferOperators()
  }
  
  /**
   * 	This is a method to test ListBuffer commonly-used operators
   */
  private def testListBufferOperators(): Unit = {
    
    /*	This is a list buffer to store elements	*/
    var listBuffer = ListBuffer[Any]()
    
    /*
     * 	Append an element into a list buffer: "+="
     *  -- listBuffer += element
     */
    println("Append using \"+=\"")
    listBuffer += "Hello Scala"
    println(listBuffer)
    listBuffer += "Hello Spark!"
    println(listBuffer)
    listBuffer += ListBuffer("GFriend", "FingerTip")
    println(listBuffer)
    listBuffer += "Hi Scala"
    println(listBuffer)
    
    /*
     * 	Append a flatten element into a list buffer: "++="
     *  -- listBuffer ++= element
     */
    println("Append using \"++=\"")
    listBuffer ++= ListBuffer("BlackPink", "Burn baby burn")
    println(listBuffer)
    listBuffer ++= ListBuffer(321, 654)
    println(listBuffer)
    
    /*
     * 	Prepend an element into a list buffer: "+:="
     *  -- listBuffer = element +: listBuffer 
     *  -- listBuffer +:= (element) 
     */
    println("Prepend using \"+:=\"")
    listBuffer = "My Darling" +: listBuffer
    println(listBuffer)  
    listBuffer +:= ListBuffer(123)
    println(listBuffer)  
    
    /*
     * 	Prepend a flatten element into a list buffer: "++:="
     *  -- listBuffer = element ++: listBuffer 
     *  -- listBuffer ++:= (element) 
     */
    println("Prepend using \"++:=\"")
    listBuffer = Array(456, 789) ++: listBuffer
    println(listBuffer)
    listBuffer ++:= ListBuffer("Lovelyz", "Wow")
    println(listBuffer)
    
    /*
     * 	Remove an element from a list buffer: "-="
     *  -- listBuffer -= element
     */
    println("Remove using \"-=\"")
    listBuffer -= "Lovelyz"
    println(listBuffer)
    listBuffer -= "Wow"
    println(listBuffer)
    listBuffer -= ListBuffer(123)
    println(listBuffer)
    
    /*
     * 	Remove a flatten element from a list buffer: "--="
     *  -- listBuffer --= element
     */
    println("Remove using \"--=\"")
    listBuffer --= ListBuffer(456, 789)
    println(listBuffer)
    listBuffer --= ListBuffer("My Darling", "Hello Scala", "Hello Spark!")
    println(listBuffer)
  }
}
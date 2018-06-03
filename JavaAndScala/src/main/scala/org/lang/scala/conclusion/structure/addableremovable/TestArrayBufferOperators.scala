package org.scala.conclusion.structure.addableremovable

import scala.collection.mutable.ArrayBuffer

/**
 * 	This is a stand-alone object to test ArrayBuffer operators
 * 	-- Add: "+=" 
 *  -- Add flatten: "++="
 *  -- Prepend: "+:"
 *  -- Prepend flatten: "++:"
 *  -- Remove: "-="
 *  -- Remove flatten: "--="
 * 
 * 	@author VinceYuan
 */
object TestArrayBufferOperators {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testArrayBufferOperators()
  }
  
  /**
   * 	This is a method to test ArrayBuffer commonly-used operators
   */
  private def testArrayBufferOperators(): Unit = {
    
    /*	This is an array buffer to store elements	*/
    var arrayBuffer = ArrayBuffer[Any]()
    
    /*
     * 	Append an element into an array buffer: "+="
     *  -- arrayBuffer += element
     */
    println("Append using \"+=\"")
    arrayBuffer += "Hello Scala"
    println(arrayBuffer)
    arrayBuffer += "Hello Spark!"
    println(arrayBuffer)
    arrayBuffer += ArrayBuffer("GFriend", "FingerTip")
    println(arrayBuffer)
    arrayBuffer += "Hi Scala"
    println(arrayBuffer)
    
    /*
     * 	Append a flatten element into an array buffer: "++="
     *  -- arrayBuffer ++= element
     */
    println("Append using \"++=\"")
    arrayBuffer = arrayBuffer ++ ArrayBuffer("BlackPink", "Burn baby burn")
    println(arrayBuffer)
    arrayBuffer ++= ArrayBuffer(321, 654)
    println(arrayBuffer)
    
    /*
     * 	Prepend an element into an array buffer: "+:="
     *  -- arrayBuffer = element +: arrayBuffer 
     *  -- arrayBuffer +:= (element) 
     */
    println("Prepend using \"+:=\"")
    arrayBuffer = "My Darling" +: arrayBuffer
    println(arrayBuffer)  
    arrayBuffer +:= ArrayBuffer(123)
    println(arrayBuffer)  
    
    /*
     * 	Prepend a flatten element into an array buffer: "++:="
     *  -- arrayBuffer = element ++: arrayBuffer 
     *  -- arrayBuffer ++:= (element) 
     */
    println("Prepend using \"++:=\"")
    arrayBuffer = Array(456, 789) ++: arrayBuffer
    println(arrayBuffer)
    arrayBuffer ++:= ArrayBuffer("Lovelyz", "Wow")
    println(arrayBuffer)
    
    /*
     * 	Remove an element from an array buffer: "-="
     *  -- arrayBuffer -= element
     */
    println("Remove using \"-=\"")
    arrayBuffer -= "Lovelyz"
    println(arrayBuffer)
    arrayBuffer -= "Wow"
    println(arrayBuffer)
    arrayBuffer -= ArrayBuffer(123)
    println(arrayBuffer)
    
    /*
     * 	Remove a flatten element from an array: "--="
     *  -- arrayBuffer --= element
     */
    println("Remove using \"--=\"")
    arrayBuffer --= ArrayBuffer(456, 789)
    println(arrayBuffer)
    arrayBuffer --= ArrayBuffer("My Darling", "Hello Scala", "Hello Spark!")
    println(arrayBuffer)
  }
}
package org.scala.conclusion.structure.addableremovable

import scala.collection.mutable.ArrayBuffer
import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test array
 *  -- ArrayBuffer is variable-length
 *  -- ArrayBuffer is mutable
 *   
 * 	@author VinceYuan
 */
object TestArrayBuffer {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testArrayBuffer()
  }
  
  /**
   * 	This is a method to test ArrayBuffer
   */
  private def testArrayBuffer(): Unit = {
    
    /*	This is a list to store array buffers	 */
    val arrayBuffer: ArrayBuffer[Any] = ArrayBuffer()
    
    /*	Initialize two arrays	 */
    val arrayBuffer1 = new ArrayBuffer[String]() 
    arrayBuffer1 += "China"
    arrayBuffer1 += ("Korea", "Chili")
    arrayBuffer1 ++= Array("India", "Yemen")
    arrayBuffer += arrayBuffer1
    val arrayBuffer2 = ArrayBuffer[Int](3, 5, 7, 2, 3)
    arrayBuffer2.+=:(10)
    arrayBuffer2.++=:(ArrayBuffer(8, 9))
    arrayBuffer2.insert(1, 6, 7)
    arrayBuffer2.remove(1, 2)
    arrayBuffer += arrayBuffer2

    /*	Output information	*/
    println("If " + arrayBuffer(0) + " and " + arrayBuffer(1) + " are the same: " + arrayBuffer(0).equals(arrayBuffer(1)))
    println("arrayBuffer(0) data type is: " + ReflectionUtils.getRuntimeType(arrayBuffer(0)))
    println("arrayBuffer1 data type is: " + ReflectionUtils.getRuntimeType(arrayBuffer1))
    println("arrayBuffer(1) data type is: " + ReflectionUtils.getRuntimeType(arrayBuffer(1)))
    println("arrayBuffer2 data type is: " + ReflectionUtils.getRuntimeType(arrayBuffer2))
    println("If arrayBuffer1 is string-arrayBuffer: " + arrayBuffer1.isInstanceOf[ArrayBuffer[String]])
    println("If arrayBuffer2 is int-arrayBuffer: " + arrayBuffer2.isInstanceOf[ArrayBuffer[Int]])
    
    /*	Traverse an array buffer using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse an array buffer using for loop:")
    for (i <- 0 until arrayBuffer1.size) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(arrayBuffer1(i))
    }
    println(stringBuilder);
    
    /*	Traverse an array buffer using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse an array buffer using functional operation:")
    arrayBuffer2.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
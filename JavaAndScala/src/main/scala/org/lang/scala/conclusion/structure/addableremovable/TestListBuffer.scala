package org.scala.conclusion.structure.addableremovable

import scala.collection.mutable.ListBuffer
import scala.reflect.runtime.universe
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to test ListBuffer
 *  -- ListBuffer is mutable
 *  
 *  @author VinceYuan
 */
object TestListBuffer {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testListBuffer()
  }
  
  /**
   * 	This is a method to test ListBuffer
   */
  private def testListBuffer(): Unit = {
    
    /*	This is a list buffer to store list buffers	 */
    val listBuffer: ListBuffer[Any] = ListBuffer()
    
    /*	Initialize two ranges	 */
    val listBuffer1 = ListBuffer[Int]()
    listBuffer1 += 1
    listBuffer1 ++= List(2, 3, 4, 5)
    listBuffer1 ++= Array(6, 7, 8, 9)
    listBuffer += listBuffer1
    val listBuffer2 = ListBuffer[String]("USA", "KOR")
    listBuffer2.+=:("JPN")
    listBuffer2.++=:(List("CHN", "BRA"))
    listBuffer += listBuffer2
    println(listBuffer)
    
    /*	Output information	*/
    println("If " + listBuffer(0) + " and " + listBuffer(1) + " are the same: " + listBuffer(0).equals(listBuffer(1)))
    println("listBuffer(0) data type is: " + ReflectionUtils.getRuntimeType(listBuffer(0)))
    println("listBuffer1 data type is: " + ReflectionUtils.getRuntimeType(listBuffer1))
    println("listBuffer(1) data type is: " + ReflectionUtils.getRuntimeType(listBuffer(1)))
    println("listBuffer2 data type is: " + ReflectionUtils.getRuntimeType(listBuffer2))
    println("If listBuffer1 is int-listBuffer: " + listBuffer1.isInstanceOf[ListBuffer[Int]])
    println("If listBuffer2 is string-listBuffer: " + listBuffer2.isInstanceOf[ListBuffer[String]])
    
    /*	Traverse a list buffer using for loop	*/
    val stringBuilder: StringBuilder = new StringBuilder()
    println("\nNow traverse a list buffer using for loop:")
    for (i <- 0 until listBuffer1.size) {
      if (i > 0) stringBuilder.append(", ")
      stringBuilder.append(listBuffer1(i))
    }
    println(stringBuilder)
    
    /*	Traverse a list buffer using functional operation	 */
    stringBuilder.clear()
    println("\nNow traverse a list buffer using functional operation:")
    listBuffer2.map { x => stringBuilder.append(x + ", ") }
    println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")))
  }
}
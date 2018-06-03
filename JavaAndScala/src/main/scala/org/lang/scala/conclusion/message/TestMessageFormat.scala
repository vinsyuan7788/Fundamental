package org.lang.scala.conclusion.message

import java.text.MessageFormat

/**
 * 	This is a stand-alone object to test MessageFormat class
 * 	-- MessageFormat class is used to concatenate a message
 * 
 * 	@author VinceYuan
 */
object TestMessageFormat {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testMessageFormat()
  }
  
  /**
   * 	This is a method to test MessageFormat class
   */
  private def testMessageFormat(): Unit = {
    
    val messageFormat = new MessageFormat("{0}, {1} and {2} come from the same university.")
    val args = Array("Vince", "Violet", "Larry")
    val message = messageFormat.format(args)
    println(s"The complete message: ${message}")
  }
}
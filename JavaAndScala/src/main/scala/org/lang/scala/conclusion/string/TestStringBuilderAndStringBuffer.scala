package org.lang.scala.conclusion.string

import scala.io.Source
import java.io.BufferedReader
import java.io.InputStreamReader
import scala.util.control.Breaks._

/**
 * 	This is a stand-alone object to test StringBuilder and StringBuffer 
 *  -- StringBuffer v.s. StringBuilder:
 *     -- StringBuffer is synchronized or thread-safe, while StringBuilder is not
 *     -- StringBuffer is not as efficient as StringBuilder (due to the synchronization of StringBuffer methods (or APIs))
 *     -- Hence:
 *        -- For single-threaded: StringBuilder > StringBuffer
 *        -- For multi-threaded: StringBuffer > StringBuilder; StringBuilder + synchronized block or methods
 *  
 * 	@author VinceYuan
 */
object TestStringBuilderAndStringBuffer {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testStringBuilderAndStringBufferMutability()
  }
  
  /**
	 * 	Test the StringBuilder & StringBuffer mutability: using a loop concatenation case
	 * 	-- In this case, StringBuilder or StringBuffer is more efficient
   */
  private def testStringBuilderAndStringBufferMutability(): Unit = {
    			
  	/*	If the input is acceptable, then output and break the loop	*/
  	println("Please input an integer greater than 0: (Recommendation: 10000)");
  	val inputInt = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())
		
  	/*	Test mutability and time efficiency of StringBuilder, StringBuffer and String	 */
    def testMutabilityAndTimeEfficiency(inputInt: Int) {
      
      /*	If input number is less than or equal to 0: re-input	*/
      if (inputInt <= 0) {
        println("The input integer MUST be greater than 0")
        val inputInt = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())
        testMutabilityAndTimeEfficiency(inputInt)
        
      /*	Otherwise test the mutability and time efficiency of StringBuffer, StringBuilder and String  */
    	} else {
    	  
        /*	Create a StringBuffer, StringBuilder and String object respectively	*/
    		val stringBuffer = new StringBuffer()
    		val stringBuilder = new StringBuilder()
    		var string: String = ""
  		
    		/*	Test the mutability and time efficiency for StringBuffer	 */
    	  val startTimeForStringBuffer = System.nanoTime()
    		for (i <- 0 until inputInt) {
    			if (i > 0) stringBuffer.append(", ")
    			stringBuffer.append("a");
    		}
    		val endTimeForStringBuffer = System.nanoTime()
    		
    		/*	Test the mutability and time efficiency for StringBuilder  */
    		val startTimeForStringBuilder = System.nanoTime()
    		for (i <- 0 until inputInt) {
    			if (i > 0) stringBuilder.append(", ")
    			stringBuilder.append("a")
    		}
    		val endTimeForStringBuilder = System.nanoTime()
    		
    		/*	Test the mutability and time efficiency for String  */
    		val startTimeForString = System.nanoTime()
    		for (i <- 0 until inputInt) {
    			if (i > 0) string = string.concat(", ")
    			string = string.concat("a")
    		}
    		val endTimeForString = System.nanoTime()
    		
    		/*	Output the information to console 	*/
    		println("The string from StringBuffer: " + stringBuffer.toString())
    		println("The string length: " + stringBuffer.toString().length())
    		println("The elapse time: " + (endTimeForStringBuffer - startTimeForStringBuffer) + " ns")
    		println("The order of maginitude of elapse time: " + String.valueOf(endTimeForStringBuffer - startTimeForStringBuffer).length())
    		println("\nThe string from StringBuilder: " + stringBuilder.toString())
    		println("The string length: " + stringBuilder.toString().length())
    		println("The elapse time: " + (endTimeForStringBuilder - startTimeForStringBuilder) + " ns")
    		println("The order of maginitude of elapse time: " + String.valueOf(endTimeForStringBuilder - startTimeForStringBuilder).length())
    		println("\nThe string from String: " + string)
    		println("The string length: " + string.length())
    		println("The elapse time: " + (endTimeForString - startTimeForString) + " ns")
    		println("The order of maginitude of elapse time: " + String.valueOf(endTimeForString - startTimeForString).length())
    	}
    }
  	testMutabilityAndTimeEfficiency(inputInt)
  }
}
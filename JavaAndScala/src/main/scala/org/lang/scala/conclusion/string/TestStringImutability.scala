package org.lang.scala.conclusion.string

/**
 * 	This is a stand-alone object to test String immutability
 * 	-- String is immutable, while StringBuilder or StringBuffer is not
 *     -- Pros: Can be applied in Java synchronization
 *     -- Cons: String is more stack-memory-consuming and less time-efficient in some situation
 *        -- Refer to "testStringBufferAndStringBuilderMutability" method in "TestStringBuilderAndStringBuffer.scala"
 *        
 * 	@author VinceYuan
 */
object TestStringImmutability {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testStringImmutability()
  }
  
  /**
   * 	This is a method to test String immutability
   * 	-- Once a String object is instantiated, it is unchanged
   */
  private def testStringImmutability(): Unit = {
    
    /*	Create a String object & concatenate a string	*/
		val originalString = new String("abc");
		originalString.concat("d");
		
		/*	The original string is unchanged	*/
		println("The original string: " + originalString);
		
		/*	Need another reference to receive the change of string	*/ 
		val newString = originalString.concat("e");
		System.out.println("The new string: " + newString);
  }
}
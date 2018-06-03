package org.lang.scala.conclusion.string

import java.util.StringTokenizer

/**
 * 	This is a stand-alone object to test StringTokenizer
 * 	-- Can be used to parse a string (customized by programmer or read from a text file, etc.)
 * 
 * 	Exemplary application scenario:
 * 	-- Count the word in a text file
 * 
 * 	@author VinceYuan
 */
object TestStringTokenizer {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testStringTokenizer()
  }
  
  /**
   * 	This is a method to test StringTokenizer
   */
  private def testStringTokenizer(): Unit = {

    /*	Get a string & parse the string using " " with StringTokenizer	*/
		val line = "I love China & I love the world!"
		val stringTokenizer = new StringTokenizer(line, " ")
		
		/*	Count the total remaining tokens after current position: current position is 0 by default & can move to next position by "nextToken()"	 */
		println("The total of words: " + stringTokenizer.countTokens())
		
		/*	See if there is at least one token after current position: current position is 0 by default & can move to next position by "nextToken()"	*/
		println("At least one token after current position? " + stringTokenizer.hasMoreTokens() + "\n")
		
		/*	Get the parsed words in the string	 */
		while (stringTokenizer.hasMoreTokens()) {
			val nextWord = stringTokenizer.nextToken()
			System.out.println("The parsed word in the string: " + nextWord)
			System.out.println("The total remaining words: " + stringTokenizer.countTokens())
			System.out.println("At least one word after current position? " + stringTokenizer.hasMoreTokens())
		}    
  }
}
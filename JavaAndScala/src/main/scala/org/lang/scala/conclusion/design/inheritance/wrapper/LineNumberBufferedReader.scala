package org.lang.scala.conclusion.design.inheritance.wrapper

import java.io.BufferedReader
import java.io.Reader

/**
 * 	This is a stand-alone class to implement inheritance (to enhance a class)
 *  -- Typically this class is to enhance a method of a class
 * 	
 * 	To enhance a method of a class using inheritance: 
 *  -- Inherits the class & override the method that needs to be enhanced
 *  
 * 	@author VinceYuan
 */
class LineNumberBufferedReader(

    val reader: Reader
    
) extends BufferedReader(reader) {
  
  /*	This is the line number with initial value 1 for enhancement	 */
  private var lineNumber = 1
  
	/**
	 * 	Override the method that needs to be enhanced
	 */
	override def readLine() = {
	  
	  /*	Use decorated class to read a line	*/
	  var line = super.readLine()
	  
	  /*	Match line with different cases	 */
	  line match {
	    /*	If line is null, then return null directly	*/
	    case null => null
	    /*	If line is not null, then add a line number in front of a line and return	 */
	    case _ => {
	      line = lineNumber + " " + line
				lineNumber += 1
				line
	    }
	  }
	}
}
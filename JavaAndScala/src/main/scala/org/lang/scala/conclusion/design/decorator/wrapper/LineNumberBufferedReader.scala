package org.lang.scala.conclusion.design.decorator.wrapper

import java.io.BufferedReader

/**
 * 	This is a stand-alone class to implement decorator pattern
 *  -- Decorator class inherits decorated class (i.e., BufferedReader) or interface
 *     -- Must declare an explicit constructor
 *        -- Need a "super" statement to make sure the compilation is not erroneous (the "super" statement is not actually working)
 * 	-- Maintain a reference of decorated class (i.e., BufferedReeader) inside decorator class (i.e., LineNumberDecorator)
 * 	   -- Use the explicit constructor to assign the decorated class instance to the reference: polymorphism
 * 	-- Override the method that needs to enhanced
 * 
 * 	@author VinceYuan
 */
class LineNumberBufferedReader(
    
    val bufferedReader: BufferedReader
    
) extends BufferedReader(bufferedReader) {
  
	/*	This is the line number with initial value 1 for enhancement	 */
	private var lineNumber = 1
	
	/**
	 * 	Override the method that needs to be enhanced
	 */
	override def readLine() = {
	  
	  /*	Use decorated class to read a line	*/
	  var line = bufferedReader.readLine()
	  
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
package org.lang.scala.conclusion.design.decorator

import java.io.BufferedReader
import java.io.FileReader

import org.lang.scala.common.utils.CharacterStreamUtils
import org.lang.scala.common.utils.FileUtils
import org.lang.scala.conclusion.design.decorator.wrapper.LineNumberBufferedReader
import org.lang.scala.conclusion.design.decorator.wrapper.SemicolonBufferedReader
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test decorator pattern for class enhancement
 * 
 * 	Using decorator pattern for class enhancement
 * 	-- The enhancement content is hard-coded
 *  -- The decorated class is variable or changeable:
 *     -- Can be the decorated class
 *     -- Can be one of the decorator classes
 *  -- Decorator class inherits the decorated class: mutual decoration & inheritance (*****)
 * 
 * 	Application scenario:
 * 	-- Typically applied in some java.io packages (e.g., BufferedReader, etc.)
 * 
 * 	@author VinceYuan
 */
object TestDecorator {
  
  /*	Necessary instance variables	*/
  private var filePath: String = _
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testPreparation()
    testDecorator()
  }
  
  /**
   * 	This is a method to prepare for testing
   */
  private def testPreparation(): Unit = {
  
		/*	Initialize the file path and create the file	*/
		filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_DECORATOR
		FileUtils.createFileIfNotExists(filePath)
		
		/*	Write data to the file	*/
		val data = "We are the champions.\nToday is the lucky day!!\nOoh-ahh like!"
		CharacterStreamUtils.writeToFile(filePath, data)
  }
  
  /**
   * 	This is a method to test decorator
   */
  private def testDecorator(): Unit = {
    
    /*	Declare null references for all enhanced decorators	 */
    var lineNumberBufferedReader: LineNumberBufferedReader = null
    var semicolonBufferedReader: SemicolonBufferedReader = null
    var lineNumberSemicolonBufferedReader: LineNumberBufferedReader = null
    
    try {
      
      /*	Initiate all enhanced decorators to read a file	 */
      lineNumberBufferedReader = new LineNumberBufferedReader(new BufferedReader(new FileReader(filePath)))
      semicolonBufferedReader = new SemicolonBufferedReader(new BufferedReader(new FileReader(filePath)))
      lineNumberSemicolonBufferedReader = new LineNumberBufferedReader(new SemicolonBufferedReader(new BufferedReader(new FileReader(filePath)))) 
    
      /*	Output the reading outcome to console	 */
      var line = lineNumberBufferedReader.readLine()
  		println("This is the output from LineNumberDecorator:")
  		while (line != null) {
  			println(line)
  			line = lineNumberBufferedReader.readLine()
  		}
      line = semicolonBufferedReader.readLine()
      println("\nThis is the output from SemicolonBufferedReader:")
      while (line != null) {
        println(line)
        line = semicolonBufferedReader.readLine()
      }
      line = lineNumberSemicolonBufferedReader.readLine()
      println("\nThis is the output from LineNumberSemicolonBufferedReader:")
      while (line != null) {
        println(line)
        line = lineNumberSemicolonBufferedReader.readLine()
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {   
      
      /*	Close all enhanced decorators	 */
      if (lineNumberBufferedReader != null) lineNumberBufferedReader.close()
      if (semicolonBufferedReader != null) semicolonBufferedReader.close()
      if (lineNumberSemicolonBufferedReader != null) lineNumberSemicolonBufferedReader.close()
    }
  }
}
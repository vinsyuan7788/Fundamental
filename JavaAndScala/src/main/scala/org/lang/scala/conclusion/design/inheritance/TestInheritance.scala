package org.lang.scala.conclusion.design.inheritance

import java.io.FileReader

import org.lang.scala.common.utils.CharacterStreamUtils
import org.lang.scala.common.utils.FileUtils
import org.lang.scala.conclusion.design.inheritance.wrapper.LineNumberBufferedReader
import org.lang.scala.conclusion.design.inheritance.wrapper.LineNumberSemicolonBufferedReader
import org.lang.scala.conclusion.design.inheritance.wrapper.SemicolonBufferedReader
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test inheritance for class enhancement
 *  -- Typically to enhance a method of a class
 *  
 *  Using inheritance for class enhancement:
 *  -- Simple but inflexible
 *     -- The enhanced content is hard-coded
 *     -- The decorated classes are invariable or unchangeable
 *     -- May bring a large inheritance hierarchy if there is a lot of demands
 *  -- Better ways for class enhancement:
 *     -- Decorator pattern
 *     -- Proxy pattern
 *     
 * 	@author VinceYuan
 */
object TestInheritance {
  
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
		filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_INHERITANCE
		FileUtils.createFileIfNotExists(filePath)
		
		/*	Write data to the file	*/
		val data = "We are the champions.\nToday is the lucky day!!\nOoh-ahh like!"
		CharacterStreamUtils.writeToFile(filePath, data)
  }
  
  /**
   * 	This is a method to test decorator
   */
  private def testDecorator(): Unit = {
    
    /*	Declare null references for all enhances decorators	 */
    var lineNumberBufferedReader: LineNumberBufferedReader = null
    var semicolonBufferedReader: SemicolonBufferedReader = null
    var lineNumberSemicolonBufferedReader: LineNumberSemicolonBufferedReader = null
    
    try {
      
      /*	Initiate all enhanced decorators to read a file	 */
      lineNumberBufferedReader = new LineNumberBufferedReader(new FileReader(filePath))
      semicolonBufferedReader = new SemicolonBufferedReader(new FileReader(filePath))
      lineNumberSemicolonBufferedReader = new LineNumberSemicolonBufferedReader(new FileReader(filePath))
      
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
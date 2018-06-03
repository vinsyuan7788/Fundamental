package org.lang.scala.conclusion.fio.source

import scala.io.Source
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test source
 * 
 * 	@author VinceYuan
 */
object TestSource {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testReadFromFile()
  }
  
  /**
   * 	This is a method to read contents from a file
   */
  def testReadFromFile() = {
    
    /*	Get a buffered source from Source	 */
    val bufferedSrc = Source.fromFile(Configuration.Conclusion.FILE_PATH_TO_TEST_SOURCE)
    
    /*	Get all lines from buffered source	*/
    val lines = bufferedSrc.getLines()
    
    /*	Print all lines	 */
    lines.foreach { line => println(line) }
  }
}
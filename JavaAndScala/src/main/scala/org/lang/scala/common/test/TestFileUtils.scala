package org.lang.scala.common.test

import org.lang.scala.common.utils.FileUtils
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test FileUtils
 * 
 * 	@author VinceYuan
 */
object TestFileUtils {

  /*	Necessary instance variables	*/
  private val filePath = Configuration.Common.FILE_PATH_TO_TEST_FILE_UTILS
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFileUtils()
  }
  
  /**
   * 	This is a method to test FileUtils class
   */
  private def testFileUtils(): Unit = {
    
    /*	Create a file if it does not exist	*/
    FileUtils.createFileIfNotExists(filePath)
    
    /*	Delete a file if it exists	*/
    FileUtils.deleteFileIfExists(filePath)
  }
}
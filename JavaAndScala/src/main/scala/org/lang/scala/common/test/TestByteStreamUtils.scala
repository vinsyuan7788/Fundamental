package org.lang.scala.common.test

import org.lang.scala.common.utils.ByteStreamUtils
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test byte stream utility
 * 
 * 	@author VinceYuan
 */
object TestByteStreamUtils {
  
/*	Necessary instance variables	*/
  private val filePath = Configuration.Common.FILE_PATH_TO_TEST_BYTE_STREAM_UTILS
  private val filePath_copy = Configuration.Common.FILE_PATH_TO_TEST_BYTE_STREAM_UTILS_COPY
  private val data = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~\t\r"
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testByteStreamUtils()
  }
  
  /**
   * 	This is a method to test ByteStreamUtils
   */
  private def testByteStreamUtils(): Unit = {
    
    ByteStreamUtils.writeToFile(filePath, data)
    println("Writing data successfully!")
    
    ByteStreamUtils.appendToFile(filePath, data)
    println("Appending data successfully!")
    
    val readData = ByteStreamUtils.readFromFile(filePath)
    println(s"Reading data successfully!\n${readData.mkString("")}")
    
    ByteStreamUtils.copyFile(filePath, filePath_copy)
    println(s"Copying file successfully!")
    
    val readDataFromCopyFile = ByteStreamUtils.readFromFile(filePath_copy)
    println(s"Reading data from copied file successfully!\n${readDataFromCopyFile.mkString("")}")
  }
}
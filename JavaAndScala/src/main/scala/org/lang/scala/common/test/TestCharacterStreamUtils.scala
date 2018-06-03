package org.lang.scala.common.test

import org.lang.scala.common.utils.CharacterStreamUtils
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test character stream utility
 * 
 * 	@author VinceYuan
 */
object TestCharacterStreamUtils {
  
  /*	Necessary instance variables	*/
  private val filePath = Configuration.Common.FILE_PATH_TO_TEST_CHARACTER_STREAM_UTILS
  private val filePath_copy = Configuration.Common.FILE_PATH_TO_TEST_CHARACTER_STREAM_UTILS_COPY
  private val data = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~\t\r"
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCharacterStreamUtils()
  }
  
  /**
   * 	This is a method to test CharacterStreamUtils
   */
  private def testCharacterStreamUtils(): Unit = {
    
    CharacterStreamUtils.writeToFile(filePath, data)
    println("Writing data successfully!")
    
    CharacterStreamUtils.appendToFile(filePath, data)
    println("Appending data successfully!")
    
    val readData = CharacterStreamUtils.readFromFile(filePath)
    println(s"Reading data successfully!\n${readData.mkString("")}")
    
    CharacterStreamUtils.copyFile(filePath, filePath_copy)
    println(s"Copying file successfully!")
    
    val readDataFromCopyFile = CharacterStreamUtils.readFromFile(filePath_copy)
    println(s"Reading data from copied file successfully!\n${readDataFromCopyFile.mkString("")}")
  }
}
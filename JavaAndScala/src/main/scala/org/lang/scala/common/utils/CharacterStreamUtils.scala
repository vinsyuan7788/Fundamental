package org.lang.scala.common.utils

import scala.reflect.io.File
import scala.reflect.io.Path

/**
 * 	This is a stand-alone object to implement utility methods regarding character stream
 * 
 * 	@author VinceYuan
 */
object CharacterStreamUtils {
  
  /**
   * 	This is a method to write data to a file
   */
  def writeToFile(filePath: String, data: String) {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Get a writer	*/
    val writer = file.bufferedWriter(false)

    /*	Write data to a file	*/
    writer.write(data)
    
    /*	Close writer	*/
    writer.close() 
  }
  
  /**
   * 	This is a method to append data to a file
   */
  def appendToFile(filePath: String, data: String) = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Get a writer	*/
    val writer = file.bufferedWriter(true)

    /*	Write data to a file	*/
    writer.write(data)
    
    /*	Close writer	*/
    writer.close() 
  }
  
  /**
   * 	This is a method to read data from a file
   */
  def readFromFile(filePath: String) = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Initialize a string array	 */
    var strArr = Array[String]()
    
    /*	Get reader from a file	*/
    val reader = file.bufferedReader()

    /*	Read data from a file	 */
    var data = reader.readLine()
    while (data != null) {
      strArr :+= data
      data = reader.readLine()
    }
    
    /*	Close reader	*/
    reader.close() 
    
    /*	Return the string array	 */
    strArr
  }
  
  /**
   * 	This is a method to copy a file
   */
  def copyFile(originalFilePath: String, newFilePath: String) = {
    
    /*	Get file instances	*/
    val originalFile = File(Path(originalFilePath))
    val copyFile = File(Path(newFilePath))
    
    /*	Get a reader and writer	 */
    val reader = originalFile.bufferedReader()
    val writer = copyFile.bufferedWriter()
    
    /*	Copy data from a file to another file	 */
    var data = reader.readLine()
    while (data != null) {
      writer.write(data)
      data = reader.readLine()
    }
    
    /*	Close reader and writer	 */
    reader.close()
    writer.close()
  }
}
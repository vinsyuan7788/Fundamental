package org.lang.scala.conclusion.fio.file.stream.character

import scala.reflect.io.File
import scala.reflect.io.Path
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test character stream
 * 
 * 	@author VinceYuan
 */
object TestCharacterStream {
  
  /*	Necessary instance variables	*/
  private val filePathForCharacterStream = Configuration.Conclusion.FILE_PATH_TO_TEST_CHARACTER_STREAM
  private val filePathForCharacterStream_copy = Configuration.Conclusion.FILE_PATH_TO_TEST_CHARACTER_STREAM_COPY
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testWriteCharactersToFile()
    testAppendCharactersToFile()
    testReadCharactersFromFile()
    testCopyCharacters()    
  }
  
  /**
   * 	This is a method to write characters to a file
   */
  private def testWriteCharactersToFile() = {

    /*	Get a file instance	 */
    val file = File(Path(filePathForCharacterStream))
    
    /*	Initialize a line	 */
    val line = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~\t\r"
    
    /*	Get a writer	*/
    val writer = file.bufferedWriter(false)
    
    /*	Write characters to a file	*/
    writer.write(line)
    
    /*	Close writer	*/
    writer.close()
    
    /*	Print a message	 */
    println("Writing characters to a file successfully...")
  }
  
  /**
   * 	This is a method to append characters to a file
   */
  private def testAppendCharactersToFile() = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePathForCharacterStream))
    
    /*	Initialize a line	 */
    val line = "大家好大家好，哇哈哈哈哈哈哈 Howdy Hello~~~"
    
    /*	Get a writer	*/
    val writer = file.bufferedWriter(true)
    
    /*	Write characters to a file	*/
    writer.write(line)
    
    /*	Close writer	*/
    writer.close()
    
    /*	Print a message	 */
    println("Appending characters to a file successfully...")
  }
  
  /**
   * 	This is a method to read characters from a file
   */
  private def testReadCharactersFromFile() = {
    
    /*	Get a file instance	 */
    val file = File(Path(filePathForCharacterStream))
    
    /*	Get a reader	*/
    val reader = file.bufferedReader()
    
    /*	Read characters from a file	 */
    var line = reader.readLine()
    while (line != null) {
      println(line)
      line = reader.readLine()
    }
    
    /*	Close reader	*/
    reader.close()   
    
    /*	Print a message	 */
    println("Reading characters from a file successfully...")
  }
  
  /**
   * 	This is a method to copy a file of characters
   */
  private def testCopyCharacters() = {
    
    /*	Get file instances	*/
    val originalFile = File(Path(filePathForCharacterStream))
    val copyFile = File(Path(filePathForCharacterStream_copy))
    
    /*	Get a reader and a writer	 */
    val reader = originalFile.bufferedReader()
    val writer = copyFile.bufferedWriter(false)
    
    /*	Copy characters from a file to another file	 */
    var line = reader.readLine()
    while (line != null) {
      writer.write(line)
      line = reader.readLine()
    }
    
    /*	Close reader and writer	 */
    reader.close()
    writer.close()
    
    /*	Print a message	 */
    println("Copying a file of characters successfully...")
  }
}
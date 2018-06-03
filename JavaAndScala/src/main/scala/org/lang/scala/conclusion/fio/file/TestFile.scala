package org.lang.scala.conclusion.fio.file

import scala.reflect.io.File
import scala.reflect.io.Path
import org.lang.scala.configuration.Configuration

/**
 * 	This is a stand-alone object to test File
 *     
 * 	@author VinceYuan
 */
object TestFile {
  
  /*	Necessary instance variables	*/
  private val filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    createFileIfNotExists()
    deleteFileIfExists()
  }
  
  /**
   * 	This is a method to create a file if the file does not exist
   */
  private def createFileIfNotExists(): Unit = {

    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Create a file if the file does not exist	*/
    if (!file.exists) {
      file.parent.createDirectory(true, false)
      file.createFile(false)
    }
    
    /*	Print a message	 */
    println("Creating a file successfully...")
  }
  
  /**
   * 	This is a method to delete a file if the file exists
   */
  private def deleteFileIfExists(): Unit = {

    /*	Get a file instance	 */
    val file = File(Path(filePath))
    
    /*	Delete a file if the file exists	*/
    if (file.exists) file.deleteRecursively()
    
    /*	Print a message	 */
    println("Deleting a file successfully...")
  }
}
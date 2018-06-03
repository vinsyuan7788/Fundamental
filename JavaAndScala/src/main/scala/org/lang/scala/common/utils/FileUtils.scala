package org.lang.scala.common.utils

import scala.reflect.io.File
import scala.reflect.io.Path

/**
 * 	This is a stand-alone object that contains file utility methods
 * 
 * 	@author VinceYuan
 */
object FileUtils {
  
  /**
   * 	This is a method to create a file if the file does not exist
   */
  def createFileIfNotExists(filePath: String) = {

    try {
      /*	Get a file instance	 */
      val file = File(Path(filePath))
      
      /*	Create a file if the file does not exist	*/
      if (!file.exists) {
        file.parent.createDirectory(true, false)
        file.createFile(false)
      }
      
      /*	Return true	 */
      true
    } catch {
      case t: Throwable => {
        /*	Return false	*/
        false
      }
    }
  }
  
  /**
   * 	This is a method to delete a file if the file exists
   */
  def deleteFileIfExists(filePath: String) = {
    
    try {
      /*	Get a file instance	 */
      val file = File(Path(filePath))
      
      /*	Delete a file if the file exists	*/
      if (file.exists) file.deleteRecursively()
      
      /*	Return true	 */
      true
    } catch {
      case t: Throwable => {
        /*	Return false	*/
        false
      }
    }
  }
}
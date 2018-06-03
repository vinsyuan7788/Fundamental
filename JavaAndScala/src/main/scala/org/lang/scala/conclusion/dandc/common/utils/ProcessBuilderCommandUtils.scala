package org.lang.scala.conclusion.dandc.common.utils

import org.lang.scala.conclusion.dandc.common.cases.JavaCommand
import org.lang.scala.conclusion.dandc.common.classes.ProcessBuilderConfiguration
import scala.collection.mutable.ListBuffer
import org.lang.scala.conclusion.dandc.common.cases.OSCommand
import org.lang.scala.conclusion.dandc.common.enumeration.ProcessBuilderSetting
import org.lang.scala.conclusion.dandc.common.classes.GenericCommand

/**
 * 	This is a stand-alone object that contains command utility methods for ProcessBuilder class
 * 
 * 	@author VinceYuan
 */
object ProcessBuilderCommandUtils {
  
  /**
   * 	This is a method to build a Java command
   */
  def buildJavaCommand(config: ProcessBuilderConfiguration) = {
    buildListCommand(JavaCommand("java", List("-jar"), config.get(ProcessBuilderSetting.JAR_PATH), List("--threadName", "randomInteger", "--iterations", "5")))
  }
  
  /**
   * 	This is a method to build a non-Java command
   */
  def buildNonJavaCommand(config: ProcessBuilderConfiguration) = {
    buildListCommand(OSCommand("notepad.exe", List(config.get(ProcessBuilderSetting.REDIRECT_OUTPUT_PATH))))
  }
  
  /**
   * 	This is a method to build generic commands into List type
   */
  private def buildListCommand(command: GenericCommand) = {
    
    val listBufCmd = ListBuffer[String]()
    
    if (command.isInstanceOf[JavaCommand]) {
      val javaCmd = command.asInstanceOf[JavaCommand]
      listBufCmd += javaCmd.javaCmd
      listBufCmd ++= javaCmd.javaOpt
      listBufCmd += javaCmd.jarPath
      listBufCmd ++= javaCmd.userOpt
    } else {
      val osCmd = command.asInstanceOf[OSCommand]
      listBufCmd += osCmd.osCmd
      listBufCmd ++= osCmd.osOpt
    }
    
    listBufCmd.toList
  }
}
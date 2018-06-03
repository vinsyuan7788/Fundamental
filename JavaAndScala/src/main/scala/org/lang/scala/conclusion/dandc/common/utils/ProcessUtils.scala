package org.lang.scala.conclusion.dandc.common.utils

import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.dandc.common.classes.ProcessRef
import org.lang.scala.conclusion.dandc.common.classes.ProcessBuilderConfiguration
import java.io.File
import org.lang.scala.conclusion.dandc.common.enumeration.ProcessBuilderSetting

/**
 * 	This is a stand-alone object that contains Process utility methods
 * 
 * 	@author VinceYuan
 */
object ProcessUtils {
  
  /**
   * 	This is a method to check the exit code of a process
   */
  def checkExitCode(exitCode: Int) = {
    if (exitCode != 0) throw new Exception("Created operating system process cannot exit normally!")
  }
  
  /**
   * 	This is a method to create a process builder
   */
  def createProcessBuilder(commands: String*) = new ProcessBuilder(commands: _*)
  def createProcessBuilder(commands: List[String]) = new ProcessBuilder(commands)
  def createProcessBuilder(commands: List[String], config: ProcessBuilderConfiguration) = {
    val builder = new ProcessBuilder(commands)
    builder.redirectOutput(new File(config.get(ProcessBuilderSetting.REDIRECT_OUTPUT_PATH)))
    builder
  }
  
  /**
   * 	This is a method to start a process from corresponding process builder and return its reference
   */
  def startProcessFrom(processBuilder: ProcessBuilder) = new ProcessRef(processBuilder.start())
}
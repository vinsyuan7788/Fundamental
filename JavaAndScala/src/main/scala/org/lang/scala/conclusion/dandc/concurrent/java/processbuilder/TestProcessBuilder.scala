package org.lang.scala.conclusion.dandc.concurrent.java.processbuilder

import java.io.File
import java.util.concurrent.TimeUnit

import scala.collection.JavaConversions.mapAsScalaMap

import org.lang.scala.conclusion.dandc.common.classes.ProcessBuilderConfiguration
import org.lang.scala.conclusion.dandc.common.utils.ProcessBuilderCommandUtils
import org.lang.scala.conclusion.dandc.common.utils.ProcessUtils
import org.lang.scala.conclusion.dandc.common.utils.Utils

/**
 * 	This is a stand-alone object to test ProcessBuilder class
 * 	-- This class is commonly used to start a new (Java) process
 * 
 * 	@author VinceYuan
 */
object TestProcessBuilder {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests ProcessBuilder class:")
    testProcessBuilder()
    println("\nHere tests starting a process:")
    testStartProcess()
    println("\nHere tests starting a process using wrappers and utils:")
    testStartProcessWithWrapperAndUtil()
  }
  
  /**
   * 	This is a method to test ProcessBuilder class
   */
  private def testProcessBuilder(): Unit = {
    
    val builder = new ProcessBuilder("notepad.exe");
    val builderDir = builder.directory()
    val builderEnv = builder.environment()
    println(s"Builder's directory:\n${builderDir}")
    println(s"Builder's environment:\n${builderEnv.mkString("\n")}")
  }
  
  /**
   * 	This is a method to start a process
   *  -- To check the effect, use "jps" command in the terminal while waiting the completion of custom process
   *     -- It will show 2 Java processes: "TestProcessBuilder" and "generateTenRandomIntegers.jar"
   */
  private def testStartProcess(): Unit = {
    
    val javaProcessBuilder = new ProcessBuilder("java", "-jar", Utils.jarFile, "--threadName", "randomInteger", "--iterations", "5")
    javaProcessBuilder.redirectOutput(new File(Utils.outputPath))    // Redirect the output for the about-to-be-created thread so the output can be checked
    val javaProcessRef = javaProcessBuilder.start()
    println("Java process started, and can be checked by using \"jps\" command. Now wait for its completion...")
    val exitCode = javaProcessRef.waitFor()
    ProcessUtils.checkExitCode(exitCode)
    javaProcessRef.destroy()
    println("Java process closed successfully.")
    
    val notePadProcessBuilder = new ProcessBuilder("notepad.exe", Utils.outputPath);
    val notePadProcessRef = notePadProcessBuilder.start()
    println("NotePad started, and the result produced by the Java process can be viewed. Now Wait for 5 seconds...")
    notePadProcessRef.waitFor(5, TimeUnit.SECONDS)
    notePadProcessRef.destroy()
    println("NotePad closed successfully.")
  }
  
  /**
   * 	This is a method to test start a process with a couple of wrapper and utility classes
   *  -- Can use either custom or existing Wrapper and utility classes
   *  -- In practical development, usually use this way to wrap out theses bottom classes, due to
   *     -- Good for code scalability
   *     -- Improve consistency between type and its practical meaning
   *        -- e.g. processBuilder.start() actually returns a reference of the started process, but it is Process type. Hence by wrapping it can return ProcessRef type
   *     -- Can hide Java codes behind Scala codes by wrapping to a higher-level class (especially for Scala development)
   */
  private def testStartProcessWithWrapperAndUtil(): Unit = {

    val config = ProcessBuilderConfiguration.getOrCreate()

    val javaCommands = ProcessBuilderCommandUtils.buildJavaCommand(config)
    val javaProcessBuilder = ProcessUtils.createProcessBuilder(javaCommands, config)   
    val javaProcessRef = ProcessUtils.startProcessFrom(javaProcessBuilder)
    println("Java process started, and can be checked by using \"jps\" command. Now wait for its completion...")
    val exitCode = javaProcessRef.process.waitFor()
    ProcessUtils.checkExitCode(exitCode)
    javaProcessRef.process.destroy()
    println("Java process closed successfully.")
    
    val nonJavaCommands = ProcessBuilderCommandUtils.buildNonJavaCommand(config)
    val notePadProcessBuilder = ProcessUtils.createProcessBuilder(nonJavaCommands);
    val notePadProcessRef = ProcessUtils.startProcessFrom(notePadProcessBuilder)
    println("NotePad started, and the result produced by the Java process can be viewed. Now wait for 5 seconds...")
    notePadProcessRef.process.waitFor(5, TimeUnit.SECONDS)
    notePadProcessRef.process.destroy()
    println("NotePad closed successfully.")
    
    System.exit(exitCode)
  }
}
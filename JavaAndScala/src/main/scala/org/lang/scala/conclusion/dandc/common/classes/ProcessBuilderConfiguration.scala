package org.lang.scala.conclusion.dandc.common.classes

import java.util.concurrent.ConcurrentHashMap

import org.lang.scala.conclusion.dandc.common.enumeration.ProcessBuilderSetting
import org.lang.scala.conclusion.dandc.common.utils.Utils

/**
 * 	This is a companion class to represent the configuration to test ProcessBuilder class
 * 
 * 	@author VinceYuan
 */
class ProcessBuilderConfiguration private() {
  
  /*	Necessary instance variables	*/
  private val settings = new ConcurrentHashMap[ProcessBuilderSetting.Value, String]()
  
  /**
   * 	This is a method to set configuration settings
   */
  def set(key: ProcessBuilderSetting.Value, value: String) = {
    settings.put(key, value)
    this
  }
  
  /**
   * 	This is a method to get the value corresponding to the key
   */
  def get(key: ProcessBuilderSetting.Value) = {
    settings.get(key)
  }
}

/**
 * 	This is a companion object to represent the configuration to test ProcessBuilder class
 * 
 * 	@author VinceYuan
 */
object ProcessBuilderConfiguration {
  
  /*	Necessary instance variables	 */
  private var configuration: ProcessBuilderConfiguration = _
  
  /**
   * 	This is a method to get or create an instance of ProcessBuilderConfiguration
   */
  def getOrCreate() = {
    if (exist(configuration)) {
      configuration
    } else {
      configuration = new ProcessBuilderConfiguration()
        .set(ProcessBuilderSetting.JAR_PATH, Utils.jarFile)
        .set(ProcessBuilderSetting.REDIRECT_OUTPUT_PATH, Utils.outputPath)
      configuration
    }
  }
  
  /**
   * 	This is a method to predicate if ProcessBuilderConfiguration instance exists
   */
  private def exist(instance: Any) = {
    if (instance == null || instance.equals(null)) false
    else true
  }
}
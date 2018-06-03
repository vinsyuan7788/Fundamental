package org.lang.scala.conclusion.design.factory.configuration

import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

import org.lang.scala.common.utils.ByteStreamUtils
import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone object to implement text configuration factory pattern
 * 
 * 	Assuming the text configuration file follows the following rules:
 * 	-- The 1st line: provide the full class name of the class that needs to be instantiated
 * 	-- The following line: provide the field value for each field of the class that needs to be instantiated
 * 
 * 	@author VinceYuan
 */
object TxtConfigurationFactory {
  
  /**
	 * 	This is a method to get the instance from a specific text configuration file by Java reflection
	 *  -- Read the text configuration file by a character stream reader
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the 1st line of the text configuration file
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by reading the rest of the text configuration file
	 *  -- Close the reader and return the instance
   */
  def getInstanceByJavaReflection(configFileName: String) = {
    
    val configFilePath = "src/main/scala/org/lang/scala/conclusion/design/factory/configuration/config/" + configFileName + ".txt"
    
    val configFileData = ByteStreamUtils.readFromFile(configFilePath)
    
    val configFile = new String(configFileData)
  
    val configs = configFile.split("\r\n")
    
    val fullClassName = configs(0)
    
    val clazz = Class.forName(fullClassName)
    val constructor = clazz.getDeclaredConstructor()      // Set to allow to access private constructors
    constructor.setAccessible(true)
    val instance = constructor.newInstance()
    
    for (i <- 1 until configs.length) {
      val fieldInfo = configs(i).split("=")
      val fieldName = fieldInfo(0)
      val fieldValue = fieldInfo(1)
      val field = clazz.getDeclaredField(fieldName)
      field.setAccessible(true)
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Int]) {
  			field.set(instance, fieldValue.toInt)
  		} 
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Char]) {
  			field.set(instance, fieldValue.toCharArray()(0))
  		}
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[String]) {
  			field.set(instance, fieldValue)
  		}
    }
    
    instance
  }
  
  /**
	 * 	This is a method to get the instance from a specific text configuration file by Scala reflection
	 *  -- Read the text configuration file by a character stream reader
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the 1st line of the text configuration file
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by reading the rest of the text configuration file
	 *  -- Close the reader and return the instance
   */
  def getInstanceByScalaReflection[T : TypeTag : ClassTag](configFileName: String) = {
    
    val configFilePath = "src/main/scala/org/lang/scala/conclusion/design/factory/configuration/config/" + configFileName + ".txt"
      
    val configFileData = ByteStreamUtils.readFromFile(configFilePath)
    
    val configFile = new String(configFileData)

    val configs = configFile.split("\r\n")
    
    val fullClassName = configs(0)
    
    val instance = ReflectionUtils.getInstanceFromClass[T](fullClassName)
    
    for (i <- 1 until configs.length) {
      val fieldInfo = configs(i).split("=")
      val fieldName = fieldInfo(0)
      val fieldValue = fieldInfo(1)
      val fieldType = ReflectionUtils.getTypeOfDeclaredMemberOfClass(fieldName)
      if (fieldType == ReflectionUtils.INT) {
  			ReflectionUtils.setField(instance)(fieldName)(fieldValue.toInt)
  		} 
  		if (fieldType == ReflectionUtils.CHAR) {
  			ReflectionUtils.setField(instance)(fieldName)(fieldValue.toCharArray()(0))
  		}
  		if (fieldType == ReflectionUtils.STRING) {
  			ReflectionUtils.setField(instance)(fieldName)(fieldValue)
  		}
    }
      
    instance
  }
}
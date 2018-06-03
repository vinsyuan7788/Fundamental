package org.lang.scala.conclusion.design.factory.method

import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.Properties

import scala.collection.JavaConversions.asScalaSet
import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

import org.lang.scala.common.utils.ReflectionUtils

/**
 * 	This is a stand-alone class to implement factory method pattern
 *  -- This class must implement a parent interface
 *  
 * 	Assuming the properties configuration file follows the following rules:
 * 	-- For the class: property name is "class" and value is the full class name of the class that needs to be instantiated
 * 	-- For the field: property name is the field name and value is the field value for the field of the class that needs to be instantiated
 *  
 * 	@author VinceYuan
 */
class PropConfigurationFactory extends ConfigurationFactory {
  
  /**
	 * 	Override the factory method to get an instance from a specific properties file by Java reflection
	 *  -- Read the properties configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the value of "class" property
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the rest of the property names
	 *  -- Return the instance
   */
  override def getInstanceByJavaReflection(configFileName: String) = {
    
		val properties = new Properties()
		properties.load(new BufferedInputStream(new FileInputStream("src/main/scala/org/lang/scala/conclusion/design/factory/method/config/" + configFileName + ".properties")))
		
		val fullClassName = properties.getProperty("class")
		
		val clazz = Class.forName(fullClassName)
		val constructor = clazz.getDeclaredConstructor()
		constructor.setAccessible(true)			  // Set to allow to access private constructors
		val instance = constructor.newInstance()
		
		val stringPropertyNames = properties.stringPropertyNames()
		stringPropertyNames.foreach(propertyName => {
		  if (propertyName != "class" && !propertyName.equals("class")) {
		    val fieldName = propertyName
		    val fieldValue = properties.getProperty(fieldName)
				val field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);				// Set to allow to access private fields		
				if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Int]) {
					field.set(instance, fieldValue.toInt);
				} 
				if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Char]) {
					field.set(instance, fieldValue.charAt(0));
				}
				if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[String]) {
					field.set(instance, fieldValue);
				}
			}
		})
		
		/*	Return the instance	 */
		instance
  }
  
  /**
	 * 	Override the factory method to get an instance from a specific properties file by Scala reflection
	 *  -- Read the properties configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the Class object from the value of "class" property
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the rest of the property names
	 *  -- Return the instance
   */
  override def getInstanceByScalaReflection[T : TypeTag : ClassTag](configFileName: String) = {
    
		val properties = new Properties()
		properties.load(new BufferedInputStream(new FileInputStream("src/main/scala/org/lang/scala/conclusion/design/factory/method/config/" + configFileName + ".properties")))
		
		val fullClassName = properties.getProperty("class")
		
		val instance = ReflectionUtils.getInstanceFromClass[T](fullClassName)
		
		val stringPropertyNames = properties.stringPropertyNames()
		stringPropertyNames.foreach(propertyName => {
		  if (propertyName != "class" && !propertyName.equals("class")) {
		    val fieldName = propertyName
				val fieldValue = properties.getProperty(fieldName)
				val fieldType = ReflectionUtils.getTypeOfDeclaredMemberOfClass(fieldName)
				if (fieldType == ReflectionUtils.INT) {
    			ReflectionUtils.setField(instance)(fieldName)(fieldValue.toInt)
    		} 
    		if (fieldType == ReflectionUtils.CHAR) {
    			ReflectionUtils.setField(instance)(fieldName)(fieldValue.charAt(0))
    		}
    		if (fieldType == ReflectionUtils.STRING) {
    			ReflectionUtils.setField(instance)(fieldName)(fieldValue)
    		}
			}
		})
		
		/*	Return the instance	 */
		instance
  }
}
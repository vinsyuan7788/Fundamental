package org.lang.scala.conclusion.design.factory.method

import scala.collection.JavaConversions.asScalaBuffer
import scala.reflect.ClassTag
import scala.reflect.runtime.universe.TypeTag

import org.dom4j.Element
import org.dom4j.io.SAXReader
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
class XmlConfigurationFactory extends ConfigurationFactory {
  
  /**
	 * 	Override the factory method to get an instance from a specific XML file by Java reflection
	 *  -- Read the XML configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the <bean> element with "class" attribute
	 *     -- Get the Class object from the full class name from "class" attribute
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the <bean>'s child elements
	 *  -- Return the instance
   */
  override def getInstanceByJavaReflection(configFileName: String) = {
    
		val document = new SAXReader().read("src/main/scala/org/lang/scala/conclusion/design/factory/method/config/" + configFileName + ".xml")
    
    val beanElement = document.getRootElement().elements("bean").get(0).asInstanceOf[Element]
    
    val fullClassName = beanElement.attributeValue("class")
    
    val clazz = Class.forName(fullClassName)
    val constructor = clazz.getDeclaredConstructor()      // Set to allow to access private constructors
    constructor.setAccessible(true)
    val instance = constructor.newInstance()
    
    val fieldElements = beanElement.elements()
    fieldElements.foreach(fieldElement => {
      val element = fieldElement.asInstanceOf[Element]
      val fieldName = element.getName
      val fieldValue = element.getTextTrim
      val field = clazz.getDeclaredField(fieldName)
      field.setAccessible(true)
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Int]) {
  			field.set(instance, fieldValue.toInt)
  		} 
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[Char]) {
  			field.set(instance, fieldValue.charAt(0))
  		}
  		if (field.getType() == ReflectionUtils.getJavaClassFromScalaType[String]) {
  			field.set(instance, fieldValue)
  		}      
    })
    
    instance
  }
  
  /**
	 * 	Override the factory method to get an instance from a specific XML file by Scala reflection
	 *  -- Read the XML configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the <bean> element with "class" attribute
	 *     -- Get the Class object from the full class name from "class" attribute
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the <bean>'s child elements
	 *  -- Return the instance
   */
  override def getInstanceByScalaReflection[T : TypeTag : ClassTag](configFileName: String) = {
    
    val document = new SAXReader().read("src/main/scala/org/lang/scala/conclusion/design/factory/method/config/" + configFileName + ".xml")
    
    val beanElement = document.getRootElement().elements("bean").get(0).asInstanceOf[Element]
    
    val fullClassName = beanElement.attributeValue("class")
    
    val instance = ReflectionUtils.getInstanceFromClass[T](fullClassName)
    
    val fieldElements = beanElement.elements()
    fieldElements.foreach(fieldElement => {
      val element = fieldElement.asInstanceOf[Element]
      val fieldName = element.getName
      val fieldValue = element.getTextTrim
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
    })
      
    instance
  }
}
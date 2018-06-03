package com.java.se.conclusion.design.factory.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	This is a class to implement factory method pattern
 *  -- This class must implement a parent interface
 *  
 * 	Assuming the XML configuration file follows the following rules:
 * 	-- For the class: "class" attribute of <bean> element stores the full class name of the class that needs to be instantiated
 * 	-- For the field: <bean>'s child elements are the field names and their texts are the values for the fields of the class that needs to be instantiated
 * 
 * @author VinceYuan
 *
 */
public class XmlConfigurationFactory implements ConfigurationFactory {

	/**
	 * 	Override the factory method to get an instance from a specific XML file
	 *  -- Read the XML configuration file
	 *  -- Get the instance and inject the field values according to read contents
	 *     -- Get the <bean> element with "class" attribute
	 *     -- Get the Class object from the full class name from "class" attribute
	 *     -- Get the instance from the Class object
	 *     -- Inject the values to the fields by iterating the <bean>'s child elements
	 *  -- Return the instance
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getInstance(String configFileName) {
		 
		try {
			/*	Read the XML file	*/ 
			Document document = new SAXReader().read("src/main/java/com/java/se/conclusion/design/factory/method/config/" + configFileName + ".xml");

			/*	Get the <bean> element with "class" attribute	*/
			Element beanElement = (Element) document.getRootElement().elements("bean").get(0);
			
			/*	Get the Class object from the full class name from "class" attribute	*/
			Class<?> clazz = Class.forName(beanElement.attributeValue("class"));
			
			/*	Get the instance from the Class object	*/
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);			// Set to allow to access private constructors
			Object object = constructor.newInstance();
			
			/*	Iterate the <bean>'s child elements to set the value for each field	 */
			List<Element> fieldElements = beanElement.elements();
			for (Element fieldElement : fieldElements) {
				Field field = clazz.getDeclaredField(fieldElement.getName());
				field.setAccessible(true);				// Set to allow to access private fields
				if (field.getType() == int.class || field.getType() == Integer.class) {
					field.set(object, Integer.parseInt(fieldElement.getTextTrim()));
				} 
				if (field.getType() == char.class || field.getType() == Character.class) {
					field.set(object, fieldElement.getTextTrim().charAt(0));
				}
				if (field.getType() == String.class) {
					field.set(object, fieldElement.getTextTrim());
				}
			}
			
			/*	Return the instance	 */
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}

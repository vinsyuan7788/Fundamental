package com.java.se.conclusion.properties;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.java.se.common.utils.FileUtils;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test Properties class
 * 	-- Properties is a sub-class of Map: since it implements "hashTable"
 *     -- Hence it is unordered when creating property file
 *  
 *  Exemplary application scenario:
 *  -- Store (create) property file for configuration
 *  -- Load (read) property file for configuration
 *  
 * @author VinceYuan
 *
 */
public class TestProperties {

	/*	Necessary instance variables	*/
	private String filePath_Properties_ENG;
	private String filePath_Properties_CHN;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestProperties testProperties = new TestProperties();
		testProperties.testPreparation();
		System.out.println("Here tests basics of properties:");
		testProperties.testBasicsOfProperties();
		System.out.println("\nHere tests storing properties:");
		testProperties.testStorePropertyFile();
		System.out.println("\nHere tests loading properties:");
		testProperties.testLoadPropertyFile();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		filePath_Properties_ENG = Configuration.Conclusion.FILE_PATH_TO_TEST_PROPERTIES_ENG;
		filePath_Properties_CHN = Configuration.Conclusion.FILE_PATH_TO_TEST_PROPERTIES_CHN;
	}
	/**
	 * 	Test the basics of properties 
	 */
	private void testBasicsOfProperties() {
		
		/*	Instantiate a Properties object & set necessary properties	*/
		Properties properties = new Properties();
		properties.setProperty("host", "gmail.com");
		properties.setProperty("username", "456");
		properties.setProperty("password", "uio");
		
		/*	Get the properties	*/
		System.out.println("The properties:");
		System.out.println(properties.getProperty("host"));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
		System.out.println();
		
		/*	Traverse the properties through entry set	 */
		Set<Entry<Object, Object>> entrySet = properties.entrySet();
		System.out.println("The entry set:");
		for (Entry<Object, Object> entry : entrySet) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();
		
		/*	Traverse the properties through property names	*/
		Set<String> propertyNames = properties.stringPropertyNames();
		System.out.println("The entry set:");
		for (String propertyName : propertyNames) {
			System.out.println(propertyName + ": " + properties.getProperty(propertyName));
		};
	}
	
	/**
	 * 	Test store properties into a file
	 * 	-- since it implements "hashTable", it is unordered when storing (creating) property files
	 * 	-- If Chinese is involved, then MUST use character stream: FileWriter()
	 */
	private void testStorePropertyFile() {
		
		try {
			/*	Instantiate Properties objects & set necessary properties	*/
			Properties properties_eng = new Properties();
			properties_eng.setProperty("host", "gmail.com");
			properties_eng.setProperty("username", "456");
			properties_eng.setProperty("password", "uio");
			Properties properties_chn = new Properties();
			properties_chn.setProperty("host", "gmail.com");
			properties_chn.setProperty("username", "456");
			properties_chn.setProperty("password", "uio");
			properties_chn.setProperty("地点", "旧金山");
			
			/*	Create 2 files to store the properties if the file does not exist	*/
			List<String> filePaths_Properties = new ArrayList<String>();
			filePaths_Properties.add(filePath_Properties_ENG);
			filePaths_Properties.add(filePath_Properties_CHN);
			for (String filePath_Properties : filePaths_Properties) {
				FileUtils.createFileIfNotExists(filePath_Properties);	
			}
			
			/*	Store properties into the files	 */
			properties_eng.store(new BufferedOutputStream(new FileOutputStream(filePath_Properties_ENG)), "This is the testing property file");
			properties_chn.store(new BufferedWriter(new FileWriter(filePath_Properties_CHN)), "This is the testing property file");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test load (or read) properties files
	 * 	-- since it implements "hashTable", it is unordered when loading (reading) property files
	 * 	-- If Chinese is involved, then MUST use character stream: FileReader()
	 */
	private void testLoadPropertyFile() {
		
		try {
			/*	Instantiate Properties objects & load necessary property files	*/
			Properties properties_eng = new Properties();
			properties_eng.load(new BufferedInputStream(new FileInputStream(filePath_Properties_ENG)));
			Properties properties_chn = new Properties();
			properties_chn.load(new BufferedReader(new FileReader(filePath_Properties_CHN)));
			
			/*	See the result	*/
			System.out.println("The properties_eng:");
			System.out.println(properties_eng.getProperty("host"));
			System.out.println(properties_eng.getProperty("username"));
			System.out.println(properties_eng.getProperty("password"));
			System.out.println("\nThe properties_chn:");
			System.out.println(properties_chn.getProperty("host"));
			System.out.println(properties_chn.getProperty("username"));
			System.out.println(properties_chn.getProperty("password"));
			System.out.println(properties_chn.getProperty("地点"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

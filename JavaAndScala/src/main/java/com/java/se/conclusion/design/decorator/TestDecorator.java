package com.java.se.conclusion.design.decorator;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.se.common.utils.FileUtils;
import com.java.se.conclusion.design.decorator.wrapper.LineNumberDecorator;
import com.java.se.conclusion.design.decorator.wrapper.SemicolonDecorator;
import com.java.se.conclusion.iostream.character.stream.FileReaderWriter;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test decorator pattern for class enhancement
 * 
 * 	Using decorator pattern for class enhancement
 * 	-- The enhancement content is hard-coded
 *  -- The decorated class is variable or changeable:
 *     -- Can be the decorated class
 *     -- Can be one of the decorator classes
 *  -- Decorator class inherits the decorated class: mutual decoration & inheritance (*****)
 * 
 * 	Application scenario:
 * 	-- Typically applied in some java.io packages (e.g., BufferedReader, etc.)
 * 
 * @author VinceYuan
 *
 */
public class TestDecorator {

	/*	Necessary instance variables	*/
	private String filePath;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestDecorator testDecorator = new TestDecorator();
		testDecorator.testPreparation();
		testDecorator.testDecorator();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Initialize the file path and create the file	*/
		filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_DECORATOR;
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Write data to the file	*/
		String data = "We are the champions.\nToday is the lucky day!!\nOoh-ahh like!";
		FileReaderWriter.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test decorator pattern
	 */
	private void testDecorator() {
		
		/*	Initiate all enhanced decorators to read a file	 */
		try (LineNumberDecorator lnd = new LineNumberDecorator(new BufferedReader(new FileReader(filePath)));
				SemicolonDecorator sd = new SemicolonDecorator(new BufferedReader(new FileReader(filePath)));
				LineNumberDecorator lnsd = new LineNumberDecorator(new SemicolonDecorator(new BufferedReader(new FileReader(filePath))));) {
			
			/*	Output the reading outcome to console	*/
			String line = null;
			System.out.println("This is the output from LineNumberDecorator:");
			while ((line = lnd.readLine()) != null) {
				System.out.println(line);
			}
			line = null;
			System.out.println("\nThis is the output from SemicolonDecorator:");
			while ((line = sd.readLine()) != null) {
				System.out.println(line);
			}
			line = null;
			System.out.println("\nThis is the output from LineNumberDecorator and SemicolonDecorator:");
			while ((line = lnsd.readLine()) != null) {
				System.out.println(line);
			}
			
			/*	Close all enhanced decorators	*/
//			if (lnd != null) lnd.close();
//			if (sd != null) sd.close();
//			if (lnsd != null) lnsd.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

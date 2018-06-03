package com.java.se.conclusion.design.inheritance;

import java.io.FileReader;

import com.java.se.common.utils.FileUtils;
import com.java.se.conclusion.design.inheritance.wrapper.LineNumberBufferedReader;
import com.java.se.conclusion.design.inheritance.wrapper.LineNumberSemicolonBufferedReader;
import com.java.se.conclusion.design.inheritance.wrapper.SemicolonBufferedReader;
import com.java.se.conclusion.iostream.character.stream.FileReaderWriter;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test inheritance for class enhancement
 *  -- Typically to enhance a method of a class
 *  
 *  Using inheritance for class enhancement:
 *  -- Simple but inflexible
 *     -- The enhanced content is hard-coded
 *     -- The decorated classes are invariable or unchangeable
 *     -- May bring a large inheritance hierarchy if there is a lot of demands
 *  -- Better ways for class enhancement:
 *     -- Decorator pattern
 *     -- Proxy pattern
 *     
 * @author VinceYuan
 *
 */
public class TestInheritance {

	/*	Necessary instance variables	*/
	private String filePath;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestInheritance testInheritance = new TestInheritance();
		testInheritance.testPreparation();
		testInheritance.testInheritance();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/*	Initialize the file path and create the file	*/
		filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_INHERITANCE;
		FileUtils.createFileIfNotExists(filePath);
		
		/*	Write data to the file	*/
		String data = "We are the champions.\nToday is the lucky day!!\nOoh-ahh like!";
		FileReaderWriter.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test inheritance (for class enhancement)
	 */
	private void testInheritance() {
		
		/*	Initiate all enhanced buffered readers to read a file	*/
		try (LineNumberBufferedReader lnbr = new LineNumberBufferedReader(new FileReader(filePath));
				SemicolonBufferedReader sbr = new SemicolonBufferedReader(new FileReader(filePath));
				LineNumberSemicolonBufferedReader lnsbr = new LineNumberSemicolonBufferedReader(new FileReader(filePath))) {
			
			/*	Output the reading outcome to console	*/
			String line = null;
			System.out.println("This is the output from LineNumberBufferedReader:");
			while ((line = lnbr.readLine()) != null) {
				System.out.println(line);
			}
			line = null;
			System.out.println("\nThis is the output from SemicolonBufferedReader:");
			while ((line = sbr.readLine()) != null) {
				System.out.println(line);
			}
			line = null;
			System.out.println("\nThis is the output from LineNumberSemicolonBufferedReader:");
			while ((line = lnsbr.readLine()) != null) {
				System.out.println(line);
			}	
			
			/*	Close all enhanced buffer readers	*/
//			lnbr.close();
//			sbr.close();
//			lnsbr.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

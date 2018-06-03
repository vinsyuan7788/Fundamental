package com.java.se.conclusion.design.inheritance.wrapper;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * 	This is a class to implement inheritance (to enhance a class)
 *  -- Typically this class is to enhance a method of a class
 * 	
 * 	To enhance a method of a class using inheritance: 
 *  -- Inherits the class & override the method that needs to be enhanced
 *  
 * @author VinceYuan
 *
 */
public class LineNumberBufferedReader extends BufferedReader {

	/*	This is the line number with initial value 1 for enhancement	 */
	private int lineNumber = 1;
	
	/*	Here inherits one of the parent constructors	*/
	public LineNumberBufferedReader(Reader in) {
		super(in);
	}
	
	/**
	 * 	Override the "readLine()" method for enhancement: 
	 * 	-- Aims to add the line number at the beginning of each line	
	 */
	@Override
	public String readLine() {
		
		try {
			/*	If the line is null (i.e., read nothing from the file), then return null	*/
			String line = super.readLine();
			if (line == null) {
				return null;
				
			/*	Otherwise add the line number at the beginning of what is read from reader	*/
			} else {
				line = lineNumber + " " + line;
				lineNumber++;
				return line;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}

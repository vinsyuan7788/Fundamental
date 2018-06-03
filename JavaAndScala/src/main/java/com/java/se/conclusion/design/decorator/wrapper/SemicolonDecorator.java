package com.java.se.conclusion.design.decorator.wrapper;

import java.io.BufferedReader;

/**
 * 	This is a class to implement decorator pattern
 *  -- Decorator class inherits decorated class (i.e., BufferedReader) or interface
 *     -- Must declare an explicit constructor
 *        -- Need a "super" statement to make sure the compilation is not erroneous (the "super" statement is not actually working)
 * 	-- Maintain a reference of decorated class (i.e., BufferedReeader) inside decorator class (i.e., LineNumberDecorator)
 * 	   -- Use the explicit constructor to assign the decorated class instance to the reference: polymorphism
 * 	-- Override the method that needs to enhanced
 * 
 * @author VinceYuan
 *
 */
public class SemicolonDecorator extends BufferedReader {

	/**	
	 * 	Maintain a reference of decorated class inside decorator class	
	 */
	private BufferedReader bufferedReader;
	
	/**	
	 * 	Declare a constructor that assigns the object to the reference of decorated class	 
	 */
	public SemicolonDecorator (BufferedReader bufferedReader) {
		/*	Only to make sure the compilation is successful	 */
		super(bufferedReader);
		/*	Assign the instance to the reference of decorated class	 */
		this.bufferedReader = bufferedReader;
	}
	
	/**
	 * 	Override the method that needs to enhanced (with decorated class method invocation)	
	 *  -- Add the semicolon at the end of each line
	 */
	@Override
	public String readLine() {
		
		try {
			/*	If the line is null (i.e., read nothing from the file), then return null	*/
			String line = bufferedReader.readLine();
			if (line == null) {
				return null;
			
			/*	Otherwise process what is read from reader	*/
			} else {
				line = line + ";";
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}

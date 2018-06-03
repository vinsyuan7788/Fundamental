package com.java.se.conclusion.enumeration;

import java.util.Arrays;
import java.util.Random;

import com.java.se.conclusion.enumeration.common.Enumeration;
import com.java.se.conclusion.enumeration.common.Enumeration.Light;

/**
 * 	This is a class to test enumeration
 * 	-- To see what enumeration class exactly is, do the decompilation for the enumeration class
 *     -- Enumeration is a sub-class (can be public|private|etc.): hence can have (since sub-class is still a class)
 *        -- Constructors (MUST be private)
 *        -- Static|instance variables
 *        -- Static|instance|abstract methods
 *        -- Details refer to "javase.testclass.enumeration" package
 *     -- Enumeration value is the object of current class created by a privatized constructor described 
 *        -- It is described by "public static final [EnumerationClassName] [EnumerationValue]", refer to "javase.testclass.enumeration" package
 *  -- Enumeration can be used in "switch...case..."
 * 	
 * 	When to use enumeration:
 *  -- When the data value need to be assigned within some range, consider enumeration
 *     -- E.g., week day, traffic light, rainbow color, gender, season, etc.
 *     
 * @author VinceYuan
 *
 */
public class TestEnumeration {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestEnumeration testEnumeration = new TestEnumeration();
		System.out.println("Here tests invocation of public enumeration class:");
		testEnumeration.testInvokePublicEnumerationClass();
		System.out.println("\nHere tests traversal of public enumeration class:");
		testEnumeration.testTraverseEnumerationValues();
		System.out.println("\nHere tests switch cases on public enumeration class:");
		testEnumeration.testSwitchCase();
	}
	
	/**
	 * 	Test invoke the members of the public enumeration class
	 * 	-- If the enumeration is public, then its public enumeration values, variables, methods are all invokable
	 *     -- If the enumeration value has implemented abstract methods, the methods are invokable as well
	 *  -- If the enumeration is private, then the enumeration & everything regarding the enumeration are NOT invokable
	 */
	private void testInvokePublicEnumerationClass() {
		
		try {
			/*	Invoke the public enumeration class	*/
			Light red = Enumeration.Light.RED;
			String string = red.flash();
			String value = red.getValue();
			Light[] enumerationValues = Enumeration.Light.values();
			String defaultColor = Enumeration.Light.DEFAULT_COLOR;
			String light = Enumeration.Light.getLight();
			
			/*	Output the results	*/
			System.out.println("The red light: " + red);
			System.out.println("The red light name:" + red.name());
			System.out.println("The red light value: " + red.value);
			System.out.println("The red light ordinal: " + red.ordinal());
			System.out.println("The string from \"flash()\" of enumeration value: " + string);
			System.out.println("The result of \"getValue()\": " + value);
			System.out.println("All enumeration values: " + Arrays.toString(enumerationValues));
			System.out.println("The default color: " + defaultColor);
			System.out.println("The light obtain by \"getLight()\": " + light);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test traverse the enumeration values of the enumeration class
	 * @throws Exception
	 */
	private void testTraverseEnumerationValues() {
		
		/*	Traverse the enumeration values	 */
		Enumeration.traverseLight();
	}
	
	/**
	 * 	Test "switch...case..." on enumeration values
	 */
	private void testSwitchCase() {
		
		/*	Randomly pick an enumeration value	 */
		Light[] lights = Enumeration.Light.values();
		Light light = lights[new Random().nextInt(lights.length)];
		
		/*	Test "switch...case..." on enumeration values	*/ 
		Enumeration.SwitchCase(light);
	}
}

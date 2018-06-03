package com.java.se.conclusion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 	This is a class to test injection through test method
 *  -- Instance variables store the value injected by test method ONLY INSIDE the test cycle
 *     -- An test cycle = @BeforeClass + @Before + @Test + @After + @AfterClass, which is why it is "unit" test
 *  -- Outside the test cycle or once the test cycle ends, instance variables go back to default value (null or 0, etc.)
 *  
 * @author VinceYuan
 *
 */
public class TestJUnit {

	/*	Instance variables	*/
	private String username;
	private double salary;
	
	/**
	 * 	Each time the test cycle starts or restarts, the value of Instance variables becomes null or 0
	 */
	@Before
	public void checkValue() {
		System.out.println("Before stage in the test cycle:");
		System.out.println("username: " + username);
		System.out.println("salary: " + salary);
	}
	
	@Test
	public void injectValueToInstanceVariables() {
		username = "Vince";
		salary = 200000;
	}
	
	@After
	public void checkInjectedValue() {
		System.out.println("After stage in the test cycle:");
		System.out.println("username: " + username);
		System.out.println("salary: " + salary);
	}
}

package com.java.se.conclusion.bignumber;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 	This is a class to test BigDecimal and BigInteger
 * 	-- BigInteger and BigDecimal can be used to ensure the precision of number calculation
 *  -- BigInteger and BigDecimal can represent the calculated result in any order of magnitude
 *  
 * @author VinceYuan
 *
 */
public class TestBigNumber {

	/*	Necessary instance variables	*/
	private double d1, d2, d3;
	private float f1, f2, f3;
	private BigDecimal sum_bd;
	private BigInteger sum_bi;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {	
		TestBigNumber testBigNumber = new TestBigNumber();
		testBigNumber.testPreparation();
		System.out.println("Here tests number calculation:");
		testBigNumber.testNumberCalculation();
		System.out.println("\nHere tests accurate calculation:");
		testBigNumber.testAccurateCalculation();
		System.out.println("\nHere tests big number representation:");
		testBigNumber.testBigNumberRepresentation();
		System.out.println("\nHere tests other methods:");
		testBigNumber.testOtherMethods();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		d1 = 2.0; d2 = 1.1; d3 = 3.0;
		f1 = 0.08f; f2 = 0.01f; f3 = 0.2f;
	}
	
	/**
	 * 	There are problems regarding number calculation
	 * 	-- Double-typed and float-typed calculation maybe inaccurate
	 */
	private void testNumberCalculation () {
		
		/*	Calculation of Double type maybe inaccurate	 */
		System.out.println("Calculation of Double type maybe inaccurate. For examples:");
		System.out.println("Substraction: " + d1 + " - " + d2 + " = " + (d1 - d2));
		System.out.println("Multiplication: " + d3 + " * " + d2 + " = " + (d3 * d2));
		
		/*	Calculation of Float type maybe inaccurate	*/
		System.out.println("Calculation of Float type maybe inaccurate. For exmaples:");
		System.out.println("Addition: " + f1 + " + " + f2 + " = " + (f1 + f2));
		System.out.println("Division: " + f1 + " / " + f3 + " = " + (f1 / f3));
	}
	
	/**
	 * 	BigDecimal can be used to:
	 * 	-- Address the calculation inaccuracy
	 */
	private void testAccurateCalculation () {
		
		/*	
		 * 	Use BigDecimal to do precise calculation
		 *  -- Make sure the argument is (converted to) String type	
		 */
		BigDecimal d1_bd = new BigDecimal(Double.toString(d1));
		BigDecimal d2_bd = new BigDecimal(String.valueOf(d2));		// This way is recommended due to declaration consistency of different data types				
		BigDecimal d3_bd = BigDecimal.valueOf(d3);
		BigDecimal f1_bd = new BigDecimal(Float.toString(f1));
		BigDecimal f2_bd = new BigDecimal(String.valueOf(f2));
		BigDecimal f3_bd = new BigDecimal(String.valueOf(f3));
		System.out.println("Calculation of BigDecimal type is accurate:");
		System.out.println("Subtraction: " + d1_bd + " - " + d2_bd + " = " + d1_bd.subtract(d2_bd).doubleValue());
		System.out.println("Multiplication: " + d3_bd + " * " + d2_bd + " = " + d3_bd.multiply(d2_bd).doubleValue());
		System.out.println("Addition: " + f1_bd + " + " + f2_bd + " = " + f1_bd.add(f2_bd).floatValue());
		System.out.println("Division: " + f1_bd + " / " + f3_bd + " = " + f1_bd.divide(f3_bd).floatValue());
	}
	
	/**
	 * 	BigDecimal and BigInteger can be used to:
	 *  -- Represent an integer with any order of magnitude
	 */
	private void testBigNumberRepresentation() {
		
		/*	Use BigDecimal to do (1.5 * 2.5 * ... * 999.5 * 1000.5)	 */
		sum_bd = new BigDecimal(String.valueOf(1));
		for (double i = 1.5; i <= 1000.5; i++) {
			sum_bd = sum_bd.multiply(new BigDecimal(String.valueOf(i)));
		}
		System.out.println("The (1.5 * 2.5 * ... * 999.5 * 1000.5) result using BigDecimal:\n" + sum_bd);
		System.out.println("The digits of the result: " + sum_bd.precision());
		System.out.println("The digits of decimal part: " + sum_bd.scale());
		
		/*	Use BigDecimal and BigInteger to do 1000 factorial and compare the results	*/
		sum_bd = new BigDecimal(String.valueOf(1));
		for (int i = 1; i <= 1000; i++) {
			sum_bd = sum_bd.multiply(BigDecimal.valueOf(i));
		}
		System.out.println("\nThe 1000 factorial result using BigDecimal:\n" + sum_bd);
		System.out.println("The digits of the result: " + sum_bd.precision());
		System.out.println("The digits of decimal part: " + sum_bd.scale());
		
		/*	Use BigInteger to do 1000 factorial	 */
		sum_bi = new BigInteger(String.valueOf(1));
		for (int i = 1; i <= 1000; i++) {
			sum_bi = sum_bi.multiply(BigInteger.valueOf(i));
		}
		System.out.println("\nThe 1000 factorial result using BigInteger:\n" + sum_bi);
		System.out.println("The digits of the result: " + sum_bd.precision());
		System.out.println("The digits of decimal part: " + sum_bd.scale());
		
		/*	Compare the calculated results from BigDecimal and BigInteger	*/
		if (sum_bd != null && sum_bi != null) {
			System.out.println("\nIf these two 1000 factorial results are equal: " + (sum_bi.compareTo(sum_bd.toBigInteger()) == 0));		
		}
	}
	
	/**
	 * 	Test other methods of BigDecimal and BigInteger
	 */
	private void testOtherMethods() {
		
		/*	Here is to test BigDecimal methods	 */
		BigDecimal bd = new BigDecimal(String.valueOf(921.2));
		System.out.println("Below is big decimal:");
		System.out.println("The scale of \"" + bd + "\": " + bd.scale());
		System.out.println("The precision of \""+ bd + "\": " + bd.precision());
		System.out.println("The unscaled value of \"" + bd + "\": " + bd.unscaledValue());
		System.out.println("The negate of \"" + bd + "\": " + bd.negate());
		System.out.println("The plus of \"" + bd + "\": " + bd.plus());
		System.out.println("The sigum of \"" + bd + "\": " + bd.signum());
		System.out.println("The ulp of \"" + bd + "\": " + bd.ulp());
		
		/*	Here is to test BigInteger methods	*/
		BigInteger bi = new BigInteger(String.valueOf(234));
		BigInteger bi2 = new BigInteger(String.valueOf(432));
		System.out.println("\nBelow is big decimal:");
		System.out.println("The bit count of \"" + bi + "\": " + bi.bitCount());
		System.out.println("The NOT result of \"" + bi + "\": " + bi.not());
		System.out.println("The AND result of \"" + bi + "\" and \"" + bi2 + "\": " + bi.and(bi2));
		System.out.println("The OR result of \"" + bi + "\" and \"" + bi2 + "\": " + bi.or(bi2));
		System.out.println("The XOR result of \"" + bi + "\" and \"" + bi2 + "\": " + bi.xor(bi2));
	}
}

package com.java.se.algorithm.ec;

import java.math.BigInteger;

import com.java.se.algorithm.ec.bean.Point;

/**
 * 	This is a class to test EC (Elliptic Curve) Cryptography
 * 
 * @author VinceYuan
 *
 */
public class TestEllipticCurve {
	
	/*	Necessary instance variables for ellipse E: y^2 = x^3 + ax + b (mod p), p is prime	 */
	private int a = 7;
	private int b = 15;
	private int p = 3571;

	/**
	 * 	This is a main method for execution
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*	Instantiate an instance for testing	 */
		TestEllipticCurve test = new TestEllipticCurve();
		
		/*	Do the multiplication for a point	 */
		int k = 150;
		Point g1 = new Point(16, 3096);
		test.computeMultiplication(k, g1);
		
		/*	Find the order of a point	 */
		Point g2 = new Point(2288, 1585);
		test.findOrder(g2);
	}
	
	/**
	 * 	This is a method to compute multiplication for a point
	 * @param k
	 * @param g
	 */
	private void computeMultiplication(int k, Point g) {
		Point mulRes = ellipticMul(k, g);
		System.out.println("Multiplication result of " + g + " on E: y^2 = x^3 + " + a + "x + " + b + " (mod + " + p + "): " + mulRes);
	}
	
	/**
	 * 	This is a method to find the order of a point
	 * @param g
	 */
	private void findOrder(Point g) {
		
		int order = 2;
		try {
			while (true) {
				ellipticMul(order, g);
				order = order + 1;
			}
		} catch (Exception e) {
			System.out.println("The order of " + g + " on E: y^2 = x^3 + " + a + "x + " + b + " (mod " + p + "): " + order);
		}
	}
	
	/**
	 * 	This is a method to implement elliptic multiplication
	 * @param k
	 * @param g
	 * @return
	 */
	private Point ellipticMul(int k, Point g) {
		
		/*	Initialize a variable to record the result	*/
		Point result = g;
		
		/*	If K < 2, then print out a message	*/
	    if (k < 2) {
	    	System.out.println("K value must be equal or greater than 2! Return the generator.");
	    
        /*	If K >= 2, then start the multiplication	*/
	    } else {
	    	Point q = g;
	    	Point lastPoint = g;
	    	for (int i = 2; i <= k; i++) {
				result = ellipticAdd(lastPoint, q);
				lastPoint = result;
			}
	    }
	    
	    /*	Return the result	 */
	    return result;
	}
	
	/**
	 * 	This is a method to implement elliptic addition
	 * @param p
	 * @param q
	 * @return
	 */
	private Point ellipticAdd(Point p, Point q) {
		
		/*	Create 2 variables to represent coordinates of a point	*/
		Integer x = null;
		Integer y = null;
		
		/*	If point p and point q are not the same	 */
		if (!p.equals(q)) {
			int A = mod(mod(p.getY() - q.getY(), this.p) * modInverse(p.getX() - q.getX(), this.p), this.p);
			x = mod(A * A - p.getX() - q.getX(), this.p);
			y = mod(A * (p.getX() - x) - p.getY(), this.p);
			
		/*	If point p and point q are the same	 */
		} else {
			int B = mod(mod(3 * p.getX() * p.getX() + a, this.p) * modInverse(2 * p.getY(), this.p), this.p);
			x = mod(B * B - 2 * p.getX(), this.p);
			y = mod(B * (p.getX() - x) - p.getY(), this.p);
		}
		
		/*	Return a new point	*/
		return new Point(x, y);
	}
	
	/**
	 * 	Here are the method for mod and mod-inverse calculation
	 * @param num
	 * @param mod
	 * @return
	 */
	private int mod(int num, int mod) {
		return new BigInteger(String.valueOf(num)).mod(new BigInteger(String.valueOf(mod))).intValue();
	}
	private int modInverse(int num, int mod) {
		return new BigInteger(String.valueOf(num)).modInverse(new BigInteger(String.valueOf(mod))).intValue();
	}
}

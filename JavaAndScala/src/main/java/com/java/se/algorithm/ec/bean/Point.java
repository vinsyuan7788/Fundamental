package com.java.se.algorithm.ec.bean;

/**
 * 	This is a Java bean to test EC (Elliptic Curve) Cryptography
 * 
 * @author VinceYuan
 *
 */
public class Point {
	
	/*	Instance variables	*/
	private Integer x;
	private Integer y;
	
	/*	Constructors	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/*	Getters and setters	 */
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}

	/*	For readability	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

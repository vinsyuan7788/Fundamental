package com.java.se.conclusion.oop.constructor.bean;

/**
 * 	This is a Java bean to be used to test constructor
 * 
 * @author VinceYuan
 *
 */
public class Apartment {

	/*	Instance variables	*/
	private Double length;
	private Double width;
	private Double height;
	
	/**
	 * 	Here are constructors:
	 *  -- Parameterless constructor still works since it is declared explicitly when parameter constructor is declared
	 *  -- The parameter of copy constructor is the instance of current class (i.e., "Apartment" in this case)
	 */
	/*	Parameterless constructor	*/
	public Apartment() {}
	/*	Parameter constructor	*/
	public Apartment(Double length, Double width, Double height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}
	/*	Copy constructor	*/
	public Apartment(Apartment instance) {
		this.length = instance.getLength();
		this.width = instance.getWidth();
		this.height = instance.getHeight();
	}
	
	/*	Getters and setters	 */
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "Apartment [length=" + length + ", width=" + width + ", height=" + height + "]";
	}
}

package com.java.se.conclusion.interoperation.bean;

import com.java.se.conclusion.interoperation.enumeration.Color;
import com.java.se.conclusion.interoperation.enumeration.Price;

/**
 * 	This is a Java bean to test interaction between Java and Scala
 * 
 * @author VinceYuan
 *
 */
public class Item {

	/*	Instance variables	*/
	private String id;
	private String name;
	private Color colorTag;
	private Price priceTag;
	
	/*	Constructors	*/
	public Item() {}
	public Item(String id, String name, Color colorTag, Price priceTag) {
		this.id = id;
		this.name = name;
		this.colorTag = colorTag;
		this.priceTag = priceTag;
	}
	
	/*	Getters and setters	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColorTag() {
		return colorTag;
	}
	public void setColorTag(Color colorTag) {
		this.colorTag = colorTag;
	}
	public Price getPriceTag() {
		return priceTag;
	}
	public void setPriceTag(Price priceTag) {
		this.priceTag = priceTag;
	}
	
	/*	For readability	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", colorTag=" + colorTag + ", priceTag=" + priceTag + "]";
	}	
}

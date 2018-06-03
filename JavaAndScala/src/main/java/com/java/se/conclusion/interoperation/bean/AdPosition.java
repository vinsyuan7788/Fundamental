package com.java.se.conclusion.interoperation.bean;

/**
 * 	This is a Java bean to test interaction between Java and Scala
 * 
 * @author VinceYuan
 *
 */
public class AdPosition {

	/*	Necessary instance variables	*/
	private String id;
	private Long x;
	private Long y;
	private Long height;
	private Long width;
	private Item item;
	
	/*	Constructors	*/
	public AdPosition() {}
	public AdPosition(String id, Long x, Long y, Long height, Long width) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	/*	Getters and setters	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getX() {
		return x;
	}
	public void setX(Long x) {
		this.x = x;
	}
	public Long getY() {
		return y;
	}
	public void setY(Long y) {
		this.y = y;
	}
	public Long getHeight() {
		return height;
	}
	public void setHeight(Long height) {
		this.height = height;
	}
	public Long getWidth() {
		return width;
	}
	public void setWidth(Long width) {
		this.width = width;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	/*	For readability	 */
	@Override
	public String toString() {
		return "AdPosition [id=" + id + ", x=" + x + ", y=" + y + ", height=" + height + ", width=" + width + ", item="
				+ item + "]";
	}
}

package com.java.se.conclusion.reflection.common.bean.parent;

/**
 * 	This is an abstract class to be used to test reflection
 *  -- This class must be inherited by its child classes
 * 
 * @author VinceYuan
 *
 */
public abstract class SoftwareEngineer<D, C> {

	/*	Instance variables	*/
	private String title;

	/*	Instance methods: getters and setters	*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

package com.java.se.conclusion.design.factory.singleton.common;

/**
 * 	This is a Java bean to be used to test the implementation of singleton factory pattern
 * 	-- This Java bean must offer a parameterless constructor, which is offered by default
 * 
 * @author VinceYuan
 *
 */
public class Teacher {

	/*	Instance variables	*/
	private String id;
	private String name;
	private String age;
	private Character gender;
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

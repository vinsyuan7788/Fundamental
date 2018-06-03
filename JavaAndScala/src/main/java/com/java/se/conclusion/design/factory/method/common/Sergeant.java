package com.java.se.conclusion.design.factory.method.common;

/**
 * 	This is a Java bean to be used to test the implementation of factory method pattern
 * 	-- This Java bean must offer a parameterless constructor, which is offered by default
 * 
 * @author VinceYuan
 *
 */
public class Sergeant {

	/*	Instance variables	*/
	private String id;
	private String name;
	private Integer age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
		return "Sergeant [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
}

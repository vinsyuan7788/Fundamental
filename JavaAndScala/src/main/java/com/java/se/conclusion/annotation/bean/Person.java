package com.java.se.conclusion.annotation.bean;

import com.java.se.conclusion.annotation.annotations.IfGetMethodName;
import com.java.se.conclusion.annotation.annotations.InjectValueForInteger;
import com.java.se.conclusion.annotation.annotations.InjectValueForString;
import com.java.se.conclusion.annotation.annotations.IsClassSingleton;

/**
 * 	This is a Java bean to demonstrate annotation development
 * 
 * @author VinceYuan
 *
 */
@IsClassSingleton(singleton=true)
public class Person {

	/*	Instance variables	*/
	@InjectValueForString("550E8400-E29B-11D4-A716-446655440000")
	private String id;
	@InjectValueForString("Vince")
	private String username;
	@InjectValueForInteger(27)
	private Integer age;
	@InjectValueForString("Male")
	private String gender;
	
	/*	Getters and setters	 */
	@IfGetMethodName(getName=true)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@IfGetMethodName(getName=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@IfGetMethodName(getName=true)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@IfGetMethodName(getName=true)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/*	For console output	*/
	@Override
	@IfGetMethodName(getName=true)
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", age=" + age + ", gender=" + gender + "]";
	}
	
	/*	Custom method to test method annotation parser	*/
	@IfGetMethodName(getName=true)
	private void testPrivateMethod(){}
}

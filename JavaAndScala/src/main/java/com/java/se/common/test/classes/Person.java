package com.java.se.common.test.classes;

import java.io.Serializable;
import java.util.Date;

/**
 * 	This is a JavaBean for testing
 * 
 * @author VinceYuan
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = -1277478265547986729L;
	private String id;
	private String name;
	private Integer age;
	private Date birthDate;
	
	public Person(String id, String name, Integer age, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}
	
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", birthDate=" + birthDate + "]";
	}
}

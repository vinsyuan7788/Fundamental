package com.java.se.conclusion.lambda.functionalinterface.bean;

/**
 * 	This is a class to be used to test functional interface
 * 
 * @author VinceYuan
 *
 */
public class HadoopEngineer {

	/*	Instance variables	*/
	private String id;
	private String name;
	private Integer age;
	private Double salary;
	
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "HadoopEngineer [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}

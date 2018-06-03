package com.java.se.conclusion.lambda.stream.bean;

/**
 * 	This is a class to be used to test Stream
 * 
 * @author VinceYuan
 *
 */
public class Professor {

	/*	Instance variables	*/
	private String id;
	private String name;
	private Double salary;
	private Boolean isTenure;
	
	/*	Constructors	*/
	public Professor() {}
	public Professor(String id, String name, Double salary, Boolean isTenure) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.isTenure = isTenure;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Boolean getIsTenure() {
		return isTenure;
	}
	public void setIsTenure(Boolean isTenure) {
		this.isTenure = isTenure;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", salary=" + salary + ", isTenure=" + isTenure + "]";
	}
}

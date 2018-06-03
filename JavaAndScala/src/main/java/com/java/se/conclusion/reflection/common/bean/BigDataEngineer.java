package com.java.se.conclusion.reflection.common.bean;

import java.io.Serializable;

import com.java.se.conclusion.reflection.common.annotation.IfGetMethodName;
import com.java.se.conclusion.reflection.common.annotation.IsClassSingleton;
import com.java.se.conclusion.reflection.common.bean.parent.HumanBeing;
import com.java.se.conclusion.reflection.common.bean.parent.Programmer;
import com.java.se.conclusion.reflection.common.bean.parent.SoftwareEngineer;

/**
 * 	This is a Java bean to be used to test reflection
 *  -- This class must inherit a parent class
 *  -- This class is annotated with @IsClassSingleton to test annotation parsing using reflection
 * 
 * @author VinceYuan
 *
 */
@IsClassSingleton(singleton=true)
public class BigDataEngineer extends SoftwareEngineer<Number, Integer> implements Serializable, Programmer, HumanBeing<Number, String> {

	/*	Static variables	*/
	private static final long serialVersionUID = 3874535809440953665L;
	
	/*	Instance variables	 */
	private String id;
	private String name;
	private Integer age;
	private Double salary;
	
	/*	Constructors  */
	public BigDataEngineer() {}
	public BigDataEngineer(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BigDataEngineer(String id, String name, Integer age, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	/*	Instance methods: getters and setters	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@IfGetMethodName(getName=true)
	public Double getSalary() {
		return salary;
	}
	@IfGetMethodName(getName=true)
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	/*	Static methods: getters	 */
	@IfGetMethodName(getName=true)
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/*	Override a method	*/
	@Override
	public void exercise() {
		System.out.println("A big data engineer is doing exercise...");
	}
	
	/*	For console output	*/
	@Override
	@IfGetMethodName(getName=true)
	public String toString() {
		return "BigDataEngineer [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}

package com.java.se.conclusion.lambda.functionalutility.bean;

/**
 * 	This is a Java bean to be used to test functional interface provided by Java utility
 * 
 * @author VinceYuan
 *
 */
public class Trainee {

	/*	Instance variables	*/
    private String firstName;
    private String lastName;
    private Double grade;
    private Double feeDiscount = 0.0;
    private Double baseFee = 20000.0;

    /*	Constructors	*/
    public Trainee() {}
    public Trainee(String firstName, String lastName, Double grade) {
    	super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    /*	Getters and setters	 */
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Double getFeeDiscount() {
		return feeDiscount;
	}
	public void setFeeDiscount(Double feeDiscount) {
		this.feeDiscount = feeDiscount;
	}
	public Double getBaseFee() {
		return baseFee;
	}
	public void setBaseFee(Double baseFee) {
		this.baseFee = baseFee;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "Trainee [firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + ", feeDiscount="
				+ feeDiscount + ", baseFee=" + baseFee + "]";
	}
	public void printFee(){
        Double newFee = baseFee - ((baseFee * feeDiscount) / 100);
        System.out.println("The fee after discount: " + newFee);
    }
}

package com.java.se.conclusion.collection.nested.common;

/**
 * 	This is a class to be used to test List
 * 
 * @author VinceYuan
 *
 */
public class PhoneNumber {

	/*	Instance variables	*/
	private String id;
	private String username;
	private Integer phoneNumber;
	private String lastLocation;
	
	/*	Constructors	*/
	public PhoneNumber() {}
	public PhoneNumber(String id, String username, Integer phoneNumber, String lastLocation) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.lastLocation = lastLocation;
	}
	
	/*	Getters and setters	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLastLocation() {
		return lastLocation;
	}
	public void setLastLocation(String lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	/*	For console output	*/
	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", username=" + username + ", phoneNumber=" + phoneNumber + ", lastLocation="
				+ lastLocation + "]";
	}
}

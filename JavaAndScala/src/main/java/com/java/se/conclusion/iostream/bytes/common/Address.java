package com.java.se.conclusion.iostream.bytes.common;

import java.io.Serializable;

/**
 * 	This is a class to provide an address for User class
 * 	-- Since the class is maintained by User (which is serializible and will be serialized), this class MUST implement Serializable as well
 * 
 * @author VinceYuan
 *
 */
public class Address implements Serializable {

	/**
	 * 	Specify a generated serial version ID, so the ID won't be calculated automatically
	 * 	-- To avoid the ID incompatibility if the class is modified and become incompatible with the serialized class on disk
	 */
	private static final long serialVersionUID = -7140661900460594433L;
	
	private String country;
	private String city;
	private String street;
	
	public Address(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", street="
				+ street + "]";
	}
}

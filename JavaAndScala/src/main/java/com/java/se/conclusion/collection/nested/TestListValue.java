package com.java.se.conclusion.collection.nested;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.java.se.conclusion.collection.nested.common.PhoneNumber;

/**
 * 	This is a class to test if the map value is a list
 * 
 * @author VinceYuan
 *
 */
public class TestListValue {

	/*	Necessary instance variables	*/
	private List<PhoneNumber> phoneNumberList;
	private Map<String, List<PhoneNumber>> userNumberMap = new HashMap<>();
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestListValue testListValue = new TestListValue();
		testListValue.testPrepartion();
		testListValue.testMap();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPrepartion() {
		
		/*	Initialize necessary data	*/
		phoneNumberList = new ArrayList<PhoneNumber>();
		phoneNumberList.add(new PhoneNumber("001", "Vince", 123456789, "NJ"));
		phoneNumberList.add(new PhoneNumber("002", "Vince", 223456789, "PA"));
		userNumberMap.put("Vince", phoneNumberList);
		phoneNumberList = new ArrayList<PhoneNumber>();
		phoneNumberList.add(new PhoneNumber("011", "Violet", 123456780, "PA"));
		phoneNumberList.add(new PhoneNumber("012", "Violet", 223456780, "NY"));
		phoneNumberList.add(new PhoneNumber("013", "Violet", 323456789, "CA"));
		userNumberMap.put("Violet", phoneNumberList);
	}
	
	/**
	 * 	Test Map
	 */
	private void testMap() {

		/*	Traverse the map	*/
		Set<Entry<String, List<PhoneNumber>>> userNumberSet = userNumberMap.entrySet();
		for (Entry<String, List<PhoneNumber>> userNumbers : userNumberSet) {
			String user = userNumbers.getKey();
			List<PhoneNumber> phoneNumbers = userNumbers.getValue();
			System.out.println("The phone number information of " + user + ":");
			for (PhoneNumber phoneNumber : phoneNumbers) {
				System.out.println(phoneNumber);
			}
		}
	}
}

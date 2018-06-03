package com.java.se.conclusion.lambda.functionalutility;

import com.java.se.conclusion.lambda.functionalutility.bean.Trainee;
import com.java.se.conclusion.lambda.functionalutility.util.FunctionalUtilityUtils;

/**
 * 	This is a class to test functional interface provided by Java utility
 * 
 * 	Lambda expression v.s. method references
 *  -- Generally use lambda expression over method references since lambda expression covers more functionality
 *     -- E.g., predicate (as a condition), consumer (as an action), etc.
 *  -- Except that method references can enormously simply the codes
 *  
 * @author VinceYuan
 *
 */
public class TestFunctionalUtility {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestFunctionalUtility testFunctionalUtility = new TestFunctionalUtility();
		System.out.println("Here tests supplier, predicate and consumer:");
		testFunctionalUtility.testSupplierPredicateConsumer();
		System.out.println("\nHere tests supplier, predicate and function:");
		testFunctionalUtility.testSupplierPredicateFunction();
	}
	
	/**
	 * 	Test supplier, predicate and consumer
	 */
	private void testSupplierPredicateConsumer() {
	    
		/*	This is the trainee instance by lambda expression	*/
	    Trainee vince = FunctionalUtilityUtils.executeJobAndReturn(() -> new Trainee("Vince", "Yuan", 9.5));
	    System.out.println("The trainee information by lambda expression: " + FunctionalUtilityUtils.executeJobAndReturn(() -> vince.getFirstName()) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> vince.getLastName()) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> vince.getGrade()) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> vince.getFeeDiscount()) +  
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> vince.getBaseFee()));
	    Trainee vince_evaluated = FunctionalUtilityUtils.evaluateCondition(vince, trainee -> trainee.getGrade() >= 9.0);
	    FunctionalUtilityUtils.performAction(vince_evaluated, trainee -> trainee.setFeeDiscount(30.0));
	    System.out.println("The trainee information: " + vince_evaluated);
	    vince_evaluated.printFee();
	    
	    /*	This is the trainee instance by lambda expression	*/
	    Trainee violet = FunctionalUtilityUtils.executeJobAndReturn(() -> { Double grade = 8.5; return new Trainee("Violet", "He", grade); });
	    System.out.println("\nThe trainee information by lambda expression: " + FunctionalUtilityUtils.executeJobAndReturn(() -> { return violet.getFirstName(); }) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> { return violet.getLastName(); }) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> { return violet.getGrade(); }) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> { return violet.getFeeDiscount(); }) +  
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(() -> { return violet.getBaseFee(); }));
	    Trainee violet_evaluated = FunctionalUtilityUtils.evaluateCondition(violet, trainee -> trainee.getGrade() >= 8.5);
	    FunctionalUtilityUtils.performAction(violet_evaluated, trainee -> trainee.setFeeDiscount(20.0));
	    System.out.println("The trainee information: " + violet_evaluated);
	    violet_evaluated.printFee();
	    
	    /*	This is the trainee instance by method reference	*/
	    Trainee johnny = FunctionalUtilityUtils.executeJobAndReturn(Trainee::new);
	    FunctionalUtilityUtils.performAction(johnny, trainee -> { trainee.setFirstName("Johnny"); trainee.setLastName("Kim"); trainee.setGrade(8.0); });
	    System.out.println("\nThe trainee information by method reference: " + FunctionalUtilityUtils.executeJobAndReturn(johnny::getFirstName) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(johnny::getLastName) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(johnny::getGrade) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(johnny::getFeeDiscount) + 
	    		", " + FunctionalUtilityUtils.executeJobAndReturn(johnny::getBaseFee));
	    johnny = FunctionalUtilityUtils.evaluateCondition(johnny, trainee -> trainee.getGrade() >= 8.0);
	    FunctionalUtilityUtils.performAction(johnny, trainee -> trainee.setFeeDiscount(10.0));
	    System.out.println("The trainee information: " + johnny);
	    johnny.printFee();
	}
	
	private void testSupplierPredicateFunction() {
		
		/*	String instance by lambda expression and method reference	*/
	    String vow = FunctionalUtilityUtils.executeJobAndReturn(() -> new String());
	    String evaluatedVow = FunctionalUtilityUtils.evaluateCondition(vow, string -> string.length() == 0);
	    vow = FunctionalUtilityUtils.invokeOneParameterMethodAndReturn(string -> evaluatedVow.concat(string), "I Love China!");
	    System.out.println("The vow by lambda expression: " + vow);
	    StringBuffer slogan = FunctionalUtilityUtils.executeJobAndReturn(StringBuffer::new);
	    slogan = FunctionalUtilityUtils.evaluateCondition(slogan, stringBuffer -> stringBuffer.length() == 0);
	    slogan = FunctionalUtilityUtils.invokeOneParameterMethodAndReturn(slogan::append, "I Love China!");
	    System.out.println("The slogan by method reference: " + slogan.toString());
	    
	    /*	Integer instance by lambda expression and method reference	*/
	    System.out.println("\nThe integer by lambda expression: " + FunctionalUtilityUtils.invokeOneParameterMethodAndReturn(string -> Integer.valueOf(string), "123"));
	    System.out.println("The integer by method reference: " + FunctionalUtilityUtils.invokeOneParameterMethodAndReturn(Integer::valueOf, "123"));
	}
}

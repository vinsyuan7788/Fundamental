package com.java.se.conclusion.lambda.functionalinterface;

import com.java.se.common.utils.BeanUtils;
import com.java.se.conclusion.lambda.functionalinterface.bean.HadoopEngineer;
import com.java.se.conclusion.lambda.functionalinterface.interfaces.Comparator;
import com.java.se.conclusion.lambda.functionalinterface.interfaces.Programmer;
import com.java.se.conclusion.lambda.functionalinterface.interfaces.Receptionist;
import com.java.se.conclusion.lambda.functionalinterface.interfaces.Soldier;
import com.java.se.conclusion.lambda.functionalinterface.interfaces.Sportsman;

/**
 * 	This is a class to test functional interface (FI)
 *  -- FI: the interface that have only one methods to be implemented (using lambda expression)
 *     -- Functional interfaces in Java resembles delegates in C#
 *  
 * 	Comparison between FI and interface
 *  -- @FunctionalInterface: necessary to explicitly specify the interface is FI
 *     -- But it is not a must
 *  -- Methods to be implemented:
 *     -- FI: can have only ONE, which can be implemented using lambda expression
 *     -- interface: can have MULTIPLE
 *  -- Default methods: both can have multiple
 * 
 * @author VinceYuan
 *
 */
public class TestFunctionalInterface {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestFunctionalInterface testFunctionalInterface = new TestFunctionalInterface();
		testFunctionalInterface.testFunctionalInterface();
	}
	
	/**
	 * 	Test functional interface
	 */
	private void testFunctionalInterface() {
		
		/*	Implement parameterless FI without return using lambda expression  */
		Programmer programmer = () -> { System.out.println("Programming using Java..."); };
		System.out.println("Parameterless FI without return:");
		programmer.program();
		
		/*	Implement parameterless FI with return using lambda expression	*/
		Soldier<String> soldier = () -> "I Love China!!!";
		System.out.println("\nParameterless FI with return:");
		System.out.println("The slogan: " + soldier.shoutSlogan());
		
		/*	Implement parameter FI without return using lambda expression	*/
		Sportsman<String> sportsman = name -> { System.out.println(name + " is doing exercise..."); }; 
		System.out.println("\nParameter FI without return:");
		sportsman.exercise("Vince");
		
		/*	Implement parameter FI with return using lambda expression	*/
		Receptionist<HadoopEngineer, String> receptionist = instance -> instance.toString();
		HadoopEngineer hadoopEngineer = BeanUtils.createSingletonInstance(HadoopEngineer.class, "550E8400-E29B-11D4-A716-446655440000", "Vince", 27, 200000.0);
		System.out.println("\nParameter FI with return:");
		System.out.println("The instance information: " + receptionist.getInfo(hadoopEngineer));
		Comparator<HadoopEngineer> comparator = (instance1, instance2) -> {
			Integer age1 = instance1.getAge();
			Integer age2 = instance2.getAge();
			return age1.compareTo(age2);
		};
		HadoopEngineer vince = new HadoopEngineer();
		vince.setAge(27);
		HadoopEngineer violet = new HadoopEngineer();
		violet.setAge(25);
		System.out.println("If vince is older than violet: " + (comparator.compare(vince, violet) > 0 ? true: false));
	}
}

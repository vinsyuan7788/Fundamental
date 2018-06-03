package com.java.se.conclusion.design.factory;

import com.java.se.conclusion.design.factory.abstracts.BrandFactory;
import com.java.se.conclusion.design.factory.abstracts.MacFactory;
import com.java.se.conclusion.design.factory.abstracts.WindowsFactory;
import com.java.se.conclusion.design.factory.abstracts.common.Border;
import com.java.se.conclusion.design.factory.abstracts.common.Button;
import com.java.se.conclusion.design.factory.configuration.TxtConfigurationFactory;
import com.java.se.conclusion.design.factory.configuration.common.Clerk;
import com.java.se.conclusion.design.factory.configuration.common.Customer;
import com.java.se.conclusion.design.factory.method.ConfigurationFactory;
import com.java.se.conclusion.design.factory.method.PropConfigurationFactory;
import com.java.se.conclusion.design.factory.method.XmlConfigurationFactory;
import com.java.se.conclusion.design.factory.method.common.Lieutenant;
import com.java.se.conclusion.design.factory.method.common.Sergeant;
import com.java.se.conclusion.design.factory.simple.LaptopFactory;
import com.java.se.conclusion.design.factory.simple.VehicleFactory;
import com.java.se.conclusion.design.factory.simple.common.laptop.Laptop;
import com.java.se.conclusion.design.factory.simple.common.vehicle.Vehicle;
import com.java.se.conclusion.design.factory.singleton.LazySingletonFactory;
import com.java.se.conclusion.design.factory.singleton.common.Teacher;

/**
 * 	This is a class to test factory pattern
 * 
 * 	There are several types of factory pattern, of which those commonly-used including:
 *  -- Product-level: Factory for the product
 *     -- Simple factory: to return an instance from different class according to different arguments
 *     -- Singleton factory: to return a singleton instance of any class
 *     -- Configuration factory: to return an instance from configuration file
 *        -- Typically applied in the design of Java frameworks (e.g., Spring, etc.)
 *  -- Factory-level: Based on low-level with factory abstraction
 *     -- Factory method: abstract the factory and delegates the instance creation to its child classes
 *        -- The instance (or product created by factory) belongs to one family
 *     -- Abstract factory: based on factory method and return a multiple families of instance
 *        -- The instance (or product created by factory) belongs to multiple families
 *  
 *  Factory pattern is usually implemented with reflection
 * 
 * @author VinceYuan
 *
 */
public class TestFactory {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestFactory testFactory = new TestFactory();
		System.out.println("Here tests simple factory:");
		testFactory.testSimpleFactory();
		System.out.println("\nHere tests singleton factory:");
		testFactory.testSingletonFactory();
		System.out.println("\nHere tests configuration factory:");
		testFactory.testConfigurationFactory();
		System.out.println("\nHere tests factory method:");
		testFactory.testFactoryMethod();
		System.out.println("\nHere tests abstract factory:");
		testFactory.testAbstractFactory();
	}
	
	/**
	 * 	Test simple factory pattern
	 */
	private void testSimpleFactory() {
		
		/*	Get different instances of the parent interface according to the argument	*/
		Laptop acer = LaptopFactory.getLaptop("Acer");
		Laptop dell = LaptopFactory.getLaptop("Dell");
		Laptop lenovo = LaptopFactory.getLaptop("Lenovo");
		acer.startup();
		dell.startup();
		lenovo.startup();
		
		/*	Get different instances of the parent abstract class according to the argument	*/
		Vehicle ship = VehicleFactory.getVehicle("Ship");
		Vehicle train = VehicleFactory.getVehicle("Train");
		Vehicle truck = VehicleFactory.getVehicle("Truck");
		ship.turn();
		train.turn();
		truck.turn();
	}
	
	/**
	 * 	Test singleton factory pattern
	 *  -- Singleton factory pattern is collaborated with lazy singleton pattern and double-checked locking pattern
	 */
	private void testSingletonFactory() {
		
		/*	Get 2 instances	 */
		Teacher vince = (Teacher) LazySingletonFactory.getInstance(Teacher.class);
		Teacher violet = (Teacher) LazySingletonFactory.getInstance(Teacher.class);
		
		/*	See if 2 instances are the same	 */
		System.out.println("If vince and violet reference the same instance? " + ((vince == violet) && (vince.equals(violet))));
	}
	
	/**
	 * 	Test configuration factory pattern
	 */
	private void testConfigurationFactory() {
		
		/*	Get 2 different instances from text configuration factory	*/
		Clerk clerk = (Clerk) TxtConfigurationFactory.getInstance("clerk_config");
		Customer customer = (Customer) TxtConfigurationFactory.getInstance("customer_config");
		
		/*	Output the information of the instances	 */
		System.out.println("The clerk information: " + clerk);
		System.out.println("The customer infomration: " + customer);
	}
	
	/**
	 * 	Test factory method pattern
	 */
	private void testFactoryMethod() {
		
		/*	Get 2 instances form TWO CHILD configuration factories with the SAME factory reference "ConfigurationFactory"	*/
		ConfigurationFactory configurationFactory = new PropConfigurationFactory();
		Lieutenant lieutenant = (Lieutenant) configurationFactory.getInstance("lieutenant_config");
		System.out.println("The lieutenant information: " + lieutenant);
		configurationFactory = new XmlConfigurationFactory();
		lieutenant = (Lieutenant) configurationFactory.getInstance("lieutenant_config");
		System.out.println("The lieutenant information: " + lieutenant);
		
		/*	Get another 2 instances form TWO CHILD configuration factories with the SAME factory reference "ConfigurationFactory"	*/
		configurationFactory = new PropConfigurationFactory();
		Sergeant sergeant = (Sergeant) configurationFactory.getInstance("sergeant_config");
		System.out.println("The sergeant information: " + sergeant);
		configurationFactory = new XmlConfigurationFactory();
		sergeant = (Sergeant) configurationFactory.getInstance("sergeant_config");
		System.out.println("The sergeant information: " + sergeant);
	}
	
	/**
	 * 	Test abstract factory pattern
	 */
	private void testAbstractFactory() {
		
		/*	Get 4 instances that belong to TWO families (Mac/Windows + border/button) with the SAME factory reference "BrandFactory"	*/
		BrandFactory brandFactory = new MacFactory();
		Border macBorder = brandFactory.getBorder();
		Button macButton = brandFactory.getButton();
		brandFactory = new WindowsFactory();
		Border windowsBorder = brandFactory.getBorder();
		Button windowsButton = brandFactory.getButton();
		macBorder.scroll();
		macButton.design();
		windowsBorder.scroll();
		windowsButton.design();
	}
}

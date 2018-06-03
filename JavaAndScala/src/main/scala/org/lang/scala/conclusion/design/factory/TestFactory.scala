package org.lang.scala.conclusion.design.factory

import org.lang.scala.common.utils.ReflectionUtils
import org.lang.scala.conclusion.design.factory.abstracts.BrandFactory
import org.lang.scala.conclusion.design.factory.abstracts.MacFactory
import org.lang.scala.conclusion.design.factory.abstracts.WindowsFactory
import org.lang.scala.conclusion.design.factory.configuration.TxtConfigurationFactory
import org.lang.scala.conclusion.design.factory.configuration.common.Clerk
import org.lang.scala.conclusion.design.factory.configuration.common.Customer
import org.lang.scala.conclusion.design.factory.method.ConfigurationFactory
import org.lang.scala.conclusion.design.factory.method.PropConfigurationFactory
import org.lang.scala.conclusion.design.factory.method.XmlConfigurationFactory
import org.lang.scala.conclusion.design.factory.method.common.Lieutenant
import org.lang.scala.conclusion.design.factory.method.common.Sergeant
import org.lang.scala.conclusion.design.factory.simple.LaptopFactory
import org.lang.scala.conclusion.design.factory.simple.VehicleFactory
import org.lang.scala.conclusion.design.factory.singleton.design.LazySingletonFactory
import org.lang.scala.conclusion.design.factory.singleton.design.common.Teacher
import org.lang.scala.conclusion.design.factory.singleton.objects.Professor

/**
 * 	This is a stand-alone object to test factory pattern
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
 * 	@author VinceYuan
 */
object TestFactory {
 
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests simple factory:")
    testSimpleFactory()
    println("\nHere tests singleton factory:")
    testSingletonFactory()
    println("\nHere tests configuration factory:")
    testConfigurationFactory()  
    println("\nHere tests factory method:")
    testFactoryMethod()         
    println("\nHere tests abstract factory:")
    testAbstractFactory()
  }
  
  /**
   * 	This is a method to test simple factory
   */
  private def testSimpleFactory(): Unit = {
    
		/*	Get different instances of the parent interface according to the argument	*/
		val acer = LaptopFactory.getLaptop("Acer")
		val dell = LaptopFactory.getLaptop("Dell")
		val lenovo = LaptopFactory.getLaptop("Lenovo")
		acer.startup()
		dell.startup()
		lenovo.startup()
		
		/*	Get different instances of the parent abstract class according to the argument	*/
		val ship = VehicleFactory.getVehicle("Ship")
		val train = VehicleFactory.getVehicle("Train")
		val truck = VehicleFactory.getVehicle("Truck")
		ship.turn()
		train.turn()
		truck.turn()
  }
  
  /**
   * 	This is a method to test singleton factory
   */
  private def testSingletonFactory(): Unit = {
    
    /*	Here tests singleton factory through design pattern for Scala only	*/
    var vince = LazySingletonFactory.getInstance[Teacher]
    var violet = LazySingletonFactory.getInstance[Teacher]
    println(s"Vince: ${vince}")
    println(s"Violet: ${violet}")
    println(s"If vince and violet reference the same instance? ${vince == violet && vince.equals(violet)}")
    
    /*	Here tests singleton factory through design pattern for Java compatibility	 */
    val clazz = ReflectionUtils.getJavaClassFromScalaType[Teacher]
    vince = LazySingletonFactory.getInstance(clazz).asInstanceOf[Teacher]
    violet = LazySingletonFactory.getInstance(clazz).asInstanceOf[Teacher]
    println(s"Vince: ${vince}")
    println(s"Violet: ${violet}")
    println(s"If vince and violet reference the same instance? ${vince == violet && vince.equals(violet)}")
    
    /*	Here tests singleton factory through object	directly	*/
    val tom = Professor
    val jerry = Professor
    println(s"If tom and jerry reference the same instance? ${tom == jerry && tom.equals(jerry)}")
  }
  
  /**
   * 	This is a method to test configuration factory
   */
  private def testConfigurationFactory(): Unit = {
    
    /*	Get instances from configuration files	*/
    val clerkByJava = TxtConfigurationFactory.getInstanceByJavaReflection("clerk_config").asInstanceOf[Clerk]
    val clerkByScala = TxtConfigurationFactory.getInstanceByScalaReflection[Clerk]("clerk_config")
    val customerByJava = TxtConfigurationFactory.getInstanceByJavaReflection("customer_config").asInstanceOf[Customer]
    val customerByScala = TxtConfigurationFactory.getInstanceByScalaReflection[Customer]("customer_config")
    
    /*	Output the information of instances	 */
    println(s"The clerk information:\n${clerkByJava}")
    println(s"The clerk information:\n${clerkByScala}")
    println(s"The customer information:\n${customerByJava}")
    println(s"The customer information:\n${customerByScala}")
  }
  
  /**
   * 	This is a method to test factory method
   */
  private def testFactoryMethod(): Unit = {
    
		/*	Get 2 instances form TWO CHILD configuration factories with the SAME factory reference "ConfigurationFactory"	*/
		var configurationFactory: ConfigurationFactory = new PropConfigurationFactory()
		var lieutenantByJava = configurationFactory.getInstanceByJavaReflection("lieutenant_config").asInstanceOf[Lieutenant]
		println("The lieutenant information: " + lieutenantByJava)
		var lieutenantByScala = configurationFactory.getInstanceByScalaReflection[Lieutenant]("lieutenant_config")
		println("The lieutenant information: " + lieutenantByScala)
		configurationFactory = new XmlConfigurationFactory()
		lieutenantByJava = configurationFactory.getInstanceByJavaReflection("lieutenant_config").asInstanceOf[Lieutenant]
		println("The lieutenant information: " + lieutenantByJava)
		lieutenantByScala = configurationFactory.getInstanceByScalaReflection[Lieutenant]("lieutenant_config")
		println("The lieutenant information: " + lieutenantByScala)
		
		/*	Get another 2 instances form TWO CHILD configuration factories with the SAME factory reference "ConfigurationFactory"	*/
		configurationFactory = new PropConfigurationFactory()
		var sergeantByJava = configurationFactory.getInstanceByJavaReflection("sergeant_config").asInstanceOf[Sergeant]
		println("The sergeant information: " + sergeantByJava)
		var sergeantByScala = configurationFactory.getInstanceByScalaReflection[Sergeant]("sergeant_config")
		println("The sergenat information: " + sergeantByScala)
		configurationFactory = new XmlConfigurationFactory()
		sergeantByJava = configurationFactory.getInstanceByJavaReflection("sergeant_config").asInstanceOf[Sergeant]
		println("The sergeant information: " + sergeantByJava)
		sergeantByScala = configurationFactory.getInstanceByScalaReflection[Sergeant]("sergeant_config")
		println("The sergeant information: " + sergeantByScala)
  }
  
  /**
   * 	This is a method to test abstract factory
   */
  private def testAbstractFactory(): Unit = {
    
		/*	Get 4 instances that belong to TWO families (Mac/Windows + border/button) with the SAME factory reference "BrandFactory"	*/		
		var brandFactory: BrandFactory = new MacFactory()
		val macBorder = brandFactory.getBorder()
		val macButton = brandFactory.getButton()
		brandFactory = new WindowsFactory()
		val windowsBorder = brandFactory.getBorder()
		val windowsButton = brandFactory.getButton()
		macBorder.scroll()
		macButton.design()
		windowsBorder.scroll()
		windowsButton.design()
  }
}
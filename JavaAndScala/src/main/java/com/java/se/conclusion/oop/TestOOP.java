package com.java.se.conclusion.oop;

/**
 * 	This is a class to test OOP (Object-Oriented Programming)
 * 
 * 	Features on OOP:
 * 	-- Encapsulation: privatization for protection (e.g. Java bean)
 *     -- "private", getter and setter
 * 	   -- Declare the variables of a class as private: "prviate"
 * 	   -- Provide public setter and getter methods to modify and view the variables values: "public"
 *     -- For high cohesion and low coupling
 * 	-- Abstraction: extraction of common features
 *     -- superclass (MAY use "abstract" (cannot co-exist with "static", "private" and "final") OR NOT) or superinterface
 *     -- When to use: know there is a class, but some (or even no) class method is hard to describe in general
 *     -- Details:
 *     	  -- An abstract class can have either abstract method or non-abstract method
 *        -- An abstract class can have no abstract method
 *        -- An abstract class cannot be instantiated, but it has constructors for its child classes
 *     	  -- If a method in a class does not have method body, then it should be described as "abstract".
 *        -- If there is an abstract method, then corresponding class must be abstract.
 *        -- All classes that extends the abstract class must override the abstract methods.
 * 	-- Inheritance: subclass can gain the ability of superclass and enhance the ability by themselves
 *     -- "extends", "implements", "super"
 *        -- When instantiation of a subclass, the constructor of the subclass will invoke the default parameterless constructor of superclass (i.e., super()), then continue executing the rest part of the constructor
 *        -- For "implements": An interface that has default methods (since Java 8) can be viewed as a mixin
 *           -- Originally a mixin is a class that contains methods for use by other classes without having to be the parent class of those other classes
 *     		 -- But compiler using "class" to support mixin will cause the issue "multiple inheritance of state"
 *              -- Regarding "multiple inheritance of state" refers to "https://docs.oracle.com/javase/tutorial/java/IandI/multipleinheritance.html"
 *     		 -- Hence generally PL (Programming Language) introduces another keyword to achieve the same effect that mixin brings
 *        	 	-- E.g., "interface" in Java and C#, "trait" in Scala, etc.
 *     -- Gain the ability of superclass: may override the method
 *     -- Enhance the abliity by themselves: may overload the method
 * 	-- Polymorphism: superclass can refer to the object of any subclass
 *     -- "extends", "implements", "super", "instanceof"
 *        -- Come from inheritance; improves the code scalability
 *        -- "instanceof": for the conversion from parent type to child type 
 *     -- Reference|Argument type -- superclass; Return obejct -- subclass
 *     -- E.g.: in IOP (Interface-Oriented Programming): interface can refer to different implementation subclasses according to different situation, so the codes can be decoupled
 *     
 *  For polymorphism, there are instance (or object) polymorphism, type polymorphism, method polymorphism
 *  -- Instance polymorphism: instances return to parent class; 
 *     -- Static: method overloading
 *     -- Dynamic: instances return to parent class
 *  -- Type polymorphism: generics (placeholder and wildcard)
 *     -- Static: generics placeholder
 *     -- Dynamic: generics wildcard
 *  -- Method polymorphism: functional interface (or delegate or callback), which is method overriding and a special case of instance polymorphism
 *     -- Dynamic: functional interface (or delegate or callback)
 *     
 *  Static and dynamic polymorphism:
 *  -- Static polymorphism: Same method name is overloaded with different type or number of parameters in same class (different signature). Targeted method call is resolved at COMPILE-TIME
 *     -- Equivalent to static binding, compile-time binding, early binding, method overloading 
 *  -- Dynamic polymorphism: Same method is overridden with same signature in different classes. Type of object on which method is being invoked is not known at compile time but will be decided at RUN-TIME
 *     -- Equivalent to dynamic binding, run-time binding, late binding, Method overriding
 *     
 * @author VinceYuan
 *
 */
public class TestOOP {

}

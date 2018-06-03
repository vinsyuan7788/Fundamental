package com.java.se.conclusion.design;

/**
 * 	This is a class to test design pattern
 * 
 *  There are several types of design pattern, of which those commonly-used including:
 * 	-- Creational pattern: to create instance in a manner suitable to some situation
 * 	   -- Singleton: to make sure there is ONLY one object (or instance) in the (heap) memory
 *     -- Factory: to provide an object (or instance) of a specific class
 * 	-- Behavioral pattern: to realize the communication pattern between objects
 *     -- Template: child classes can customize an inside-template job by inheriting the template class
 *     -- Observer: once object can observe an event raised by another object (and do corresponding processing if the event is raised)
 * 	-- Structural pattern: to realize the relationship between entities
 *     -- Inheritance: to enhance (method(s) of) a specific class through hard-coding
 *     -- Decorator: to enhance (method(s) of) decorated or decorator classes through hard-coding
 * 	   -- Proxy: to enhance (method(s) of) any class with custom-coded content by another class
 *  -- Concurrency pattern: to deal with multi-threaded programming paradigm
 *     -- Double-checked locking: to reduce the overhead of acquiring a lock
 *     -- Thread-local: to have (global) resource local to each thread
 *  -- Architectural pattern: to solve soft architecture
 *     -- IOC: to pass the object creation to a external component which can inject objects using configuration
 *     -- MVC: to improve the program robustness, scalability and flexibility
 * 
 * 	Pattern: a fixed procedure to resolve one type of problem
 * 	-- Hence no need to understand: if there is a demand or requirement, then use this pattern  
 *  
 * 	For the some pattern involving 2 classes or entities: observer, decorator, static proxy, etc.
 * 	-- Active (enhancing or decorator or proxy, etc.) class extends passive (enhanced or decorated or target, etc.) class
 *     -- so can make use of inheritance
 *  -- Active class maintains a reference for (the parent of) passive class
 *     -- so can make use of polymorphism
 *  -- Introduce a class|interface as the parent of the passive classes
 *     -- this parent class can be abstract class
 *     
 *  Patterns are always used collaboratively. For example:
 *  -- Lazy singleton pattern is always used with double-checked locking pattern
 *  -- Singleton factory pattern is always used with lazy singleton pattern
 *  -- Factory method pattern is usually used with singleton factory pattern, configuration factory pattern, etc.
 *  
 *  For inheritance, decorator pattern and proxy pattern, ranking from static to dynamic:
 *  -- Inheritance --> decorator pattern --> static proxy pattern --> dynamic proxy pattern
 *     
 * @author VinceYuan
 *
 */
public class TestDesignPattern {
	
}

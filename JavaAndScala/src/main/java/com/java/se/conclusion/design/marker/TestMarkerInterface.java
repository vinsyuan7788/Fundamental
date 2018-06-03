package com.java.se.conclusion.design.marker;

/**
 * 	This is a class to test marker interface pattern
 *  -- A marker interface specifies some functionality, 
 *  -- Only the classes that implement this marker interface are allowed to achieve these specified functionality 
 *  
 *  An practical example is Serializable interface:
 *  -- Serializable specifies serialization/de-serialization functionality for disk read/write
 *  -- "objectOutputStream.writeObject" will check if an object is an instance of Serializable
 *     -- If yes, allow to write the object to disk
 *     -- If no, throw an NotSerializableException exception
 * 
 * @author VinceYuan
 *
 */
public class TestMarkerInterface {

}

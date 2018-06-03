package org.lang.scala.conclusion.design.marker

/**
 * 	This is a class to test marker trait pattern
 *  -- A marker trait specifies some functionality, 
 *  -- Only the classes that implement this marker trait are allowed to achieve these specified functionality 
 *  
 *  An similar example in Java is Serializable interface:
 *  -- Serializable specifies serialization/de-serialization functionality for disk read/write
 *  -- "objectOutputStream.writeObject" will check if an object is an instance of Serializable
 *     -- If yes, allow to write the object to disk
 *     -- If no, throw an NotSerializableException exception
 *    
 * 	@author VinceYuan
 */
object TestMarkerTrait {
  
}
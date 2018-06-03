package org.lang.scala.conclusion.design.factory.simple.common.laptop

import org.lang.scala.conclusion.design.factory.simple.common.laptop.parent.Laptop

/**
 * 	This is a stand-alone class to be used to test the implementation of simple factory pattern
 *  -- This class must implement a parent interface
 *  
 * 	@author VinceYuan
 */
class Acer extends Laptop {
  
  override def startup(): Unit = {
    println("An Acer laptop is starting up...")
  }
  
  override def shutdown(): Unit = {
    println("An Acer laptop is shutting down...")
  }
}
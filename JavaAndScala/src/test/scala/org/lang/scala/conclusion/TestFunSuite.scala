package org.lang.scala.conclusion

import org.scalatest._

/**
 * 	This is a stand-alone class to test "FunSuite" for Scala test
 * 
 * 	@author VinceYuan
 */
class TestFunSuite extends FunSuite {
  
  /**
   * 	This is a method for unit test
   */
  test("val and var") {
    assert(this.testVal() == this.testVar());
  }
    
  /**
   * 	This is a method to test "val" keyword
   */
  def testVal(): String = {
    val stringVal = "Hello Scala!~";
//    stringVal = "Hello Scala!~"
    return stringVal
  }
  
    /**
   * 	This is a method to test "var" keyword
   */
  def testVar(): String = {
    var stringVar = "Hello World!~"
    stringVar = "Hello Scala!~"
    return stringVar
  }
}
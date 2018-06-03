package org.lang.scala.common

import org.junit.Test
import org.lang.scala.common.utils.OrdinalUtils

/**
 * 	This is a stand-alone class to test common utility classes
 * 
 * 	@author VinceYuan
 */
class TestCommonUtils {
  
  /**
   * 	This is a method to test OrdinalUtils class
   */
  @Test
  def testOrdinalUtils() = {
    
		val num1 = 1;
		val num2 = 11;
		val num3 = 21;
		
		println(num1 + " ---> " + OrdinalUtils.toOrdinal(num1));
		println(num2 + " ---> " + OrdinalUtils.toOrdinal(num2));
		println(num3 + " ---> " + OrdinalUtils.toOrdinal(num3));
  }
}
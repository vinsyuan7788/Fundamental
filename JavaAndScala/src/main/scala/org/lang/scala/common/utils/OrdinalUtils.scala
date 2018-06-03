package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contains ordinal utility methods
 * 
 * 	@author VinceYuan
 */
object OrdinalUtils {
  
  /**
   * 	This is a method to convert number to ordinal
   */
  def toOrdinal(number: Int): String = {
    
  	/*	If the number ends with "11", "12" and "13", append "th"	*/
    if (number.toString().endsWith("11")) number.toString() + "th"
    if (number.toString().endsWith("12")) number.toString() + "th"
    if (number.toString().endsWith("13")) number.toString() + "th"
   
    /*	Else if the number ends with "1", "2" and "3", append "st", "nd", "rd" respectively	*/
    if (number.toString().endsWith("1")) number.toString() + "st"
    if (number.toString().endsWith("2")) number.toString() + "nd"
    if (number.toString().endsWith("3")) number.toString() + "rd"
    
    /*	Else append "th"  */
    number.toString() + "th"
  }
}
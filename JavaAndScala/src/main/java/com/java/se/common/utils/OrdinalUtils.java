package com.java.se.common.utils;

/**
 * 	This is a class to implement ordinal utility methods
 * 
 * @author VinceYuan
 *
 */
public class OrdinalUtils {

	/**
	 * 	This is a method to convert number into ordinal
	 * @param number
	 * @return
	 */
    public static final String toOrdinal(Integer number) {

    	/*	If the number ends with "11", "12" and "13", append "th"	*/
        if (number.toString().endsWith("11")) return number.toString() + "th";
        if (number.toString().endsWith("12")) return number.toString() + "th";
        if (number.toString().endsWith("13")) return number.toString() + "th";
        
        /*	Else if the number ends with "1", "2" and "3", append "st", "nd", "rd" respectively	*/
        if (number.toString().endsWith("1")) return number.toString() + "st";
        if (number.toString().endsWith("2")) return number.toString() + "nd";
        if (number.toString().endsWith("3")) return number.toString() + "rd";
        
        /*	Else append "th"  */
        return number.toString() + "th";
    }
}

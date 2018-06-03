package org.lang.scala.conclusion.regex.common

import scala.util.Random

/**
 * 	This is a stand-alone object to randomly generate a captcha
 * 
 * 	@author VinceYuan
 */
object Captcha {
  
	/*	This is the object array to sample the number for each digit	 */
	val objArr = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A')

	/**
	 * 	This is a method to get a captcha
	 * 	-- The length of captcha is between 6 and 9
	 * 	-- The captcha may consist of number and letter (A)
	 */
	def getCaptcha(): String = {
		
		/*	Randomly decide the number of digits for captcha: 6 - 9 digits  */
	  val numOfDigits = new Random().nextInt(4) + 6
		
		/*	Get the captcha	 */
		val stringBuilder = new StringBuilder();
		for (i <- 0 until numOfDigits) {
			stringBuilder.append(objArr(new Random().nextInt(objArr.length)))
		}
	  stringBuilder.toString()
	}
}
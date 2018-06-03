package org.lang.scala.conclusion.regex

import org.lang.scala.conclusion.regex.common.Captcha

/**
 * 	This is a stand-alone object to test regex
 * 	-- Regex rules
 * 	-- Regex for matching and splitting, etc.
 * 
 * 	@author VinceYuan
 */
object TestRegex {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here demonstrates pre-defined characters:")
    testPredefinedCharacters()
    println("\nHere demonstrates character class:")
    testCharacterClass()
    println("\nHere demonstrates greediness:")
    testGreediness()
    println("\nHere demonstrates regex match:")
    testRegexMatch()
    println("\nHere demonstrates regex split:")
    testRegexSplit()
  }
  
	/**
	 * 	This is a method to test pre-defined characters of regex
	 */
	private def testPredefinedCharacters(): Unit = {
		
		/*	A character for pre-defined character predication	*/
		val character = " ";
		
		/*
		 * 	Pre-defined characters:
		 * 	.: any character
		 * 	\d: any number [0-9]
		 * 	\D: any non-number [^0-9]
		 * 	\s: blank character [ \t\n\x0B\f\r]
		 * 	\S: non-blank character [^\s]
		 * 	\w: word character [a-zA-Z_0-9]
		 * 	\W: non-word character [^\w]
		 * 
		 * 	Note: 
		 * 	1. To express slash in implementation, need to add another slash before slash, so it is, e.g., "\\d" (slash slash d) to make "\d" readable by Java compiler
		 * 	2. For \t, \n, etc., need to add a slash before slash as well for the same reason in implementation
		 */
		println("Any character: " + (character.matches(".")));
		println("Number character: " + (character.matches("\\d")));
		println("Non-number character: " + (character.matches("\\D")));
		println("Blank character: " + (character.matches("\\s")));
		println("Non-blank character: " + (character.matches("\\S")));
		println("Word character: " + (character.matches("\\w")));
		println("Non-word character: " + (character.matches("\\W")));
	}
	
	/**
	 * 	This is a method to test character class of regex
	 */
	private def testCharacterClass() {
		
		/*	A string for character class predication	*/
		val character = "2";
		
		/*
		 * 	Character class:
		 * 	[abc123]: only appear a, b, c, 1, 2 or 3
		 *  [^abc123]: only appears any character except a, b, c, 1, 2 and 3
		 *  [a-zA-Z0-9] or [a-z[A-Z[0-9]]]: on appears between a and z or between A and Z or between 0 and 9
		 *  [a-z&&[def]]: only appears in the intersection of a-z and def (namely [def])
		 */
		println("A, B, C, 1, 2 or 3: " + character.matches("[abc123]"));
		println("Any character except A, B, C, 1, 2 and 3: " + character.matches("[^abc123]"));
		println("Any character in a-z or A-Z or 0-9: " + character.matches("[a-zA-Z0-9]"));
//		println("Any character in a-z or A-Z or 0-9: " + character.matches("[a-z[A-Z[0-9]]]"));
		println("Any character in the intersection of a-z and def: " + character.matches("[def]"));
//		println("Any character in the intersection of a-z and def: " + character.matches("[a-z&&[def]]"));
	}

	/**
	 * 	This is a method to test greediness of regex
	 */
	private def testGreediness(): Unit = {
		
		/*	A string for greediness predication	 */
		val string = "12AB6789";
		
		/*
		 * 	Greediness:
		 * 	X?: X appears none or once 
		 * 	X*: X appears none or multiple times
		 * 	X+: X appears once or multiple times
		 * 	X{n}: X appears n times
		 * 	X{n,}: X appears at least n times
		 * 	X{n,m}: X appears at least n times but no more than m times
		 */
		println("Number appears none or once: " + (string.matches("\\d?")));
		println("Number appears none or multiple times: " + (string.matches("[0-9]*")));
		println("Number appears once or multiple times: " + (string.matches("[0-9]+")));
		println("Number appears 3 times: " + (string.matches("\\d{3}")));
		println("Number appears at least 3 times: " + (string.matches("[0-9]{3,}")));
		println("Number appears at least 3 times & no more than 9 times: " + (string.matches("[0-9]{3,9}")));
		println("Word appears none or once: " + (string.matches("\\w?")));
		println("Word appears none or multiple times: " + (string.matches("[a-zA-Z_0-9]*")));
		println("Word appears once or multiple times: " + (string.matches("[a-zA-Z_0-9]+")));
		println("Word appears 3 times: " + (string.matches("\\w{3}")));
		println("Word appears at least 3 times: " + (string.matches("[a-zA-Z_0-9]{3,}")));
		println("Word appears at least 3 times & no more than 9 times: " + (string.matches("[a-zA-Z_0-9]{3,9}")));
		println("Non-blank character appears none or once: " + (string.matches("\\S?")));
		println("Non-blank appears none or multiple times: " + (string.matches("[^ \\t\\n\\x0B\\f\\r]*")));
		println("Non-blank appears once or multiple times: " + (string.matches("[^ \\t\\n\\x0B\\f\\r]+")));
		println("Non-blank appears 3 times: " + (string.matches("\\S{3}")));
		println("Non-blank appears at least 3 times: " + (string.matches("[^ \\t\\n\\x0B\\f\\r]{3,}")));
		println("Non-blank appears at least 3 times & no more than 9 times: " + (string.matches("[^ \\t\\n\\x0B\\f\\r]{3,9}")));
	}
	
	/**
	 * 	This is a method to test the regex matching 
	 * 	-- Here do not take email as example since in differnt industrial field, the rules vary a lot
	 *     -- In e-comercce, the email is no need to verify in the back-end because even the format is right, the email may be invalid for activation
	 *     -- If necessary can verify the email with JS or JQuery, etc.
	 */
	private def testRegexMatch(): Unit = {
		
		/*	Get a captcha	*/
		val captcha = Captcha.getCaptcha();
		
		/*	Specify a regex for predication	 */
		val regex = "[1-9]\\d{4,10}";
		
		/*	
		 * 	Output the captcha and predicate if it is legit. The captcha is legit only if
		 * 	-- Start from 1 to 9
		 * 	-- Length must be between 5 and 11
		 * 	-- Must consist of ONLY number
		 */
		println("Captcha: " + captcha);
		println(if (captcha.matches(regex)) "Legit captcha" else "Illegit captcha");
	}
	
	/**
	 * 	Test the regex split
	 */
  private def testRegexSplit(): Unit = {
		
		/*	Strings to be split by regex	*/
		val string1 = "We   are  the       champion";
		val string2 = "Wesupsupsupsupsupsuparejugjugjugthemidmidchampion";
		
		/*	Specify the regex for splitting strings	 */
		val regex1 = " +";
		val regex2 = "(.+)\\1+";
		
		/*	Split the string by blank and repeated words	*/
		val stringArray1 = string1.split(regex1);
		println("The elements in stringArray1: " + stringArray1.toBuffer);
		val stringArray2 = string2.split(regex2);
		println("The elements in stringArray2: " + stringArray2.toBuffer);
	}
}
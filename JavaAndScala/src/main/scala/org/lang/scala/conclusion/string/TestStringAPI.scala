package org.lang.scala.conclusion.string

/**
 * 	This is a stand-alone object to test String APIs
 * 
 * 	@author VinceYuan
 */
object TestStringAPI {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests first letter upper case conversion:")
    testFirstLetterUpperCaseConverstion()
    println("\nHere tests string reverse:")
    testStringReverse()
    println("\nHere tests mulitple-line string:")
    testMultiLineString()
    println("\nHere tests string non-empty:")
    testStringNonEmpty()
    println("\nHere tests string testStringInterpolation:")
    testStringInterpolation()
  }
  
  /**
	 * 	Test the upper case conversion of the first letter
	 */
  private def testFirstLetterUpperCaseConverstion(): Unit = {
    
    /*	Get the setter name for the corresponding field name	*/
		val fieldName = "xxxx";
		val setterName = "set" + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
		
		/*	Output the information	*/
		System.out.println("The field name: " + fieldName);
		System.out.println("The setter name: " + setterName);
  }
  
  /**
   * 	This is a method to test string reverse
   */
  private def testStringReverse(): Unit = {
    val originalStr = "D >-- C >-- B >-- A"
    val reverseStr = originalStr.reverse
    println(s"Original string: $originalStr")
    println(s"Reverse string: $reverseStr")
  }
  
  /**
   * 	This is a method to test multiple-line string
   */
  private def testMultiLineString(): Unit = {
    
    /*	Test plain multiple-line string: not starting with 's'	*/
    val line1 = """
      |select id as newId, 
        |age as newAge, 
        |salary as newSalary 
      |from developer 
      |where age >= 30 
      |group by id, age, salary 
      |order by id
    """.stripMargin.replaceAll("\n", " ").trim()
    println(line1)
    
    /*	Test multiple-line strings with variables interpolated: starting with 's'	*/
    val col1 = "id"
    val col2 = "age"
    val col3 = "salary"
    val col11 = "newId"
    val col22 = "newAge"
    val col33 = "newSalary"
    val table = "developer"
    val condition = s"$col2 >= 30"
    val lines2 = s"""
      |select $col1 as $col11,
        |$col2 as $col22,
        |$col3 as $col33 from $table
      |where $condition
      |group by $col1, $col2, $col3
      |order by $col1
    """.stripMargin.replaceAll("\n", " ").trim()
    println(lines2)
  }
  
  /**
   * 	This is a method to test "nonEmpty"
   */
  private def testStringNonEmpty(): Unit = {
    val str1 = ""
    val str2 = "				".trim()
    val str3 = "				"
    val str4 = "abcdefg"
    println(s"If $str1 is empty: " + str1.nonEmpty)
    println(s"If $str2 is empty: " + str2.nonEmpty)
    println(s"If $str3 is empty: " + str3.nonEmpty)
    println(s"If $str4 is empty: " + str4.nonEmpty)
  }
  
  /**
   * 	This is a method to test String interpolation
   *  -- If want to use \"\" within the interpolation, MUST use s"""xxx""" instead of s"xxx" 
   */
  private def testStringInterpolation(): Unit = {
    
    val name = "Vince"
    val nameList = List("Violet")
    println(s"Hello World! Hello $name! Hello ${nameList(0).toString()}!")
    println(s"""Hello \"Darling~\" Hello World! Hello $name! Hello ${nameList(0).toString()}!""")
  }
}
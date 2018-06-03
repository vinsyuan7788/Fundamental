package org.lang.scala.conclusion.datatype.algebraic.sum.enumeration

/**
 * 	This is a stand-alone object to test enumeration
 *  
 *  To declare an enumeration: 
 *  -- Declare an object that extends "Enumeration" class
 *  -- Use the built-in method "Value"
 *     
 *  To use the enumeration value:
 *  -- Use the value directly
 *  -- Use the value through ID
 *  -- Use the value through name
 *  
 *  The data type of each value in a class A that extends Enumeration
 *  -- A.Value: e.g., TestEnumeration.Value
 *  
 *  Notice that when invoking the ID after invoking the value through its name:
 *  -- The ID will be auto-incremented
 *     -- Since each time invokes "Value(name: String)" method, the built-in ID inside "Enumeration" class will plus 1
 *  -- But this will NOT affect those values declared with IDs through "Value()"
 *     -- Those ID that has been assigned to a value remain unchanged
 *  -- This maybe a bug
 * 
 * 	@author VinceYuan
 */
object TestEnumeration extends Enumeration {

  /*	Necessary instance variables	*/
  val Spring = Value(1, "spring")
  val Summer = Value(11, "summer")
  val Fall = Value(111, "fall")
  val Winter = Value(1111, "winter")
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests enumeration:")
    testEnumeration()
    println("\nHere tests data type of enumeration value:")
    testDataTypeOfEnumerationValue()
  }
  
  /**
   * 	This is a method to test enumeration
   */
  def testEnumeration(): Unit = {
    
    /*	Use the enumeration value directly	*/
    println("Here demonstrates using the enumeration value directly:")
    val weekdayArr = Array() :+ TestEnumeration.Mon :+ TestEnumeration.Tue :+ 
      TestEnumeration.Wed :+ TestEnumeration.Thu :+ TestEnumeration.Fri :+ 
      TestEnumeration.Sat :+ TestEnumeration.Sun
    val weekdayIdArr = Array() :+ TestEnumeration.Mon.id :+ TestEnumeration.Tue.id :+ 
      TestEnumeration.Wed.id :+ TestEnumeration.Thu.id :+ TestEnumeration.Fri.id :+ 
      TestEnumeration.Sat.id :+ TestEnumeration.Sun.id
    println(weekdayArr.toBuffer)
    println(weekdayIdArr.toBuffer)
    
    /*	Use the enumeration value through ID	*/
    println("\nHere demonstrates using the enumeration value through ID:")
    val seasonList = List() :+ TestEnumeration(1) :+ TestEnumeration(11) :+ 
      TestEnumeration(111) :+ TestEnumeration(1111)
    val seasonIdList = List() :+ TestEnumeration(1).id :+ TestEnumeration(11).id :+ 
      TestEnumeration(111).id :+ TestEnumeration(1111).id
    println(seasonList)
    println(seasonIdList)
    
    /*	
     * 	Use the enumeration value through name
     *  -- ID being invoked after invoking the value through its name will be auto-incremented
     *     -- This maybe a bug
     */
    println("\nHere demonstrates using the enumeration value through name:")
    val seasonSet1 = Set() + TestEnumeration.Value("spring") + TestEnumeration.Value("summer") + 
      TestEnumeration.Value("fall") + TestEnumeration.Value("winter")
    val seasonIdSet1 = Set() + TestEnumeration.Value("spring").id + TestEnumeration.Value("summer").id + 
      TestEnumeration.Value("fall").id + TestEnumeration.Value("winter").id
    val seasonIdSet2 = Set() + TestEnumeration.Value("spring").id + TestEnumeration.Value("summer").id + 
      TestEnumeration.Value("fall").id + TestEnumeration.Value("winter").id
    val seasonSet2 = Set() + TestEnumeration(1) + TestEnumeration(11) + 
      TestEnumeration(111) + TestEnumeration(1111)
    println(seasonSet1)
    println(seasonIdSet1)
    println(seasonIdSet2)
    println(seasonSet2)
  }
  
  /**
   * 	This is a method to test data type of enumeration value
   */
  private def testDataTypeOfEnumerationValue(): Unit = {
    
    var seasons = Map[TestEnumeration.Value, Int]()
    seasons += (TestEnumeration.Spring -> 1)
    seasons += (TestEnumeration.Summer -> 2)
    seasons += (TestEnumeration.Fall -> 3)
    seasons += (TestEnumeration.Winter -> 4)
    println(s"Seasons: ${seasons}")
    
    var weekDays = Map[TestEnumeration.Value, Int]()
    weekDays += (TestEnumeration.Mon -> 2)
    weekDays += (TestEnumeration.Tue -> 3)
    weekDays += (TestEnumeration.Wed -> 4)
    weekDays += (TestEnumeration.Thu -> 5)
    weekDays += (TestEnumeration.Fri -> 6)
    weekDays += (TestEnumeration.Sat -> 7)
    weekDays += (TestEnumeration.Sun -> 1)
    println(s"weekDays: ${weekDays}")
  }
}
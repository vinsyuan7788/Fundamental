package org.lang.scala.conclusion.design.nullobj

/**
 * 	This is a stand-alone object to test null-object pattern
 *  -- This is a special case of state pattern or strategy pattern
 *  
 *  Why using Option, Some, None:
 *  -- For the consistency of data type
 *     -- Null is a data type that is compatible with complex or custom data type, but not with primitive type
 *  -- Hence to express a primitive type is null, unable to do it directly
 *     -- In Java, using wrapper class for primitive (Integer, Short, Long, etc.) to address data type consistency with "null"
 *     -- In Scala, using Option, Some, None
 *  -- To avoid NullPointException:
 *     -- E.g., for a block of codes, there maybe multiple logics that do NOT allow null value
 *        -- In Java, may need to multiple try...catch to capture those NullPointException and processing respectively, which causes inconvenience during programming
 *        -- In Scala, using Option, Some, None with pattern matching, which simplify the programming and make the code structure more concise
 *        
 *  @author VinceYuan
 */
object TestNullObject {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testNullObject()
  }
  
  /**
   * 	This is a main method test null-object pattern
   */
  private def testNullObject(): Unit = {
    
    /*	Using "Option" class for null-object pattern	*/
    val map = Map("username" -> "VinceYuan", "gender" -> 'M')
    val value1 = map.get("username") match {
      case Some(username) => username
      case None => null
    }
    val value2 = map.get("salary") match {
      case Some(salary) => salary
      case None => 0.0d
    }
    println(value1)
    println(value2)
    
    /*	Using built-in methods that use "Option" class instead: RECOMMNEDED in practice	*/
    val value3 = map.getOrElse("username", "Violet")
    val value4 = map.getOrElse("salary", 0.0d)
    println(value3)
    println(value4)
  }
}
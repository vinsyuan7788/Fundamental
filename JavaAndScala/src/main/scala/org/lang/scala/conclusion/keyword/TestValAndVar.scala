package org.lang.scala.conclusion.keyword

/**
 * 	This is a stand-alone object to test "val" and "var" keywords
 *  -- val: used to define a variable and assign an unchangeable (or finalized) value to it
 *     -- Functionally same as "final" in Java or C# functionally
 *     -- Mechanically any variable declared by "val" will be finalized and privatized and assigned a getter after compilation (in .class file)
 *        -- When get the value of a "val" variable, it actually invokes the getter to return the value in JVM
 *  -- var: used to define a variable
 *     -- Functionally same as "var" in C# or JavaScript
 *     -- Mechanically any variable declared by "var" will be privatized and assigned a getter and setter after compilation (in .class file)
 *        -- When get the value of a "var" variable, it actually invokes the getter to return the value in JVM
 *        -- When set the value of a "var" variable, it actually invokes the setter to set the value of the variable in JVM
 *  
 *  Usually val is the first option when both val and var are available since 
 *  -- It ensures the thread security
 *  -- JVM only needs to read it once (since once it is unchanged)
 *  Hence in practice, just use "val" unless compiler informs an error
 *     
 * 	@author VinceYuan
 */
object TestValAndVar { 

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println(testVal())
    println(testVar())
    testTrickyCase()
  }
  
  /**
   * 	This is a method to test "val" keyword
   */
  private def testVal(): String = {
    val stringVal = "Hello Scala!~";
//    stringVal = "Hello Scala!~"
    return stringVal
  }
  
  /**
   * 	This is a method to test "var" keyword
   */
  private def testVar(): String = {
    var stringVar = "Hello World!~"
    stringVar = "Hello Scala!~"
    return stringVar
  }
  
  /**
   * 	This is a method to test tricky case
   */
  private def testTrickyCase(): Unit = {
    val t1, t2, (a, b, c) = {
      println("ABC")
      (1, 2, 3)
    }
    println(t1)
    println(t2)
    println((a, b, c))
    println(a)
    println(t1._1)
  }
}
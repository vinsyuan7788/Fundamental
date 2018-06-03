package org.scala.conclusion.structure.addableonly

/**
 * 	This is a stand-alone object to test List commonly-used operators
 *  -- Add: ":+"
 *  -- Add flatten: "++"
 *  -- Prepend: "::" or "+:"
 *  -- Prepend flatten: ":::" or"++:"
 *   	
 * 	@author VinceYuan
 */
object TestListOperators {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testListOperators()
  }
  
  /**
   * 	This is a method to test List commonly-used operators
   */
  private def testListOperators(): Unit = {
    
    /*	This is a list to store elements	*/
    var list = List[Any]()
    
    /*
     * 	Append an element into a list: ":+"
     * 	-- list = list :+ element
     *  -- list :+= element
     */
    println("Append using \":+\"")
    list = list :+ "Hello Scala"
    println(list)
    list :+= "Hello Spark!"
    println(list)
    list = list :+ List("GFriend", "FingerTip")
    println(list)
    
    /*
     * 	Append a flatten element into a list: "++"
     * 	-- list = list ++ element
     *  -- list ++= element
     */
    println("Append using \"++\"")
    list = list ++ List("BlackPink", "Burn baby burn")
    println(list)
    list ++= List(321, 654)
    println(list)
    
    /*
     * 	Prepend an element into a list: "::" or "+:"
     *  -- list = element ::/+: list 
     *  -- list ::=/+:= (element) 
     */
    println("Prepend using \"::\" or \"+:\"")
    list = "My Darling" :: list
    println(list)
    list ::= "My baby"
    println(list)
    list = List(123) +: list
    println(list)  
    list +:= List(321)
    println(list)
    
    /*
     * 	Prepend a flatten element into a list: ":::" or "++:"
     *  -- list = element :::/++: list 
     *  -- list :::=/++:= (element) 
     */
    println("Prepend using \":::\" or \"++:\"")
    list = List(456, 789) ::: list
    println(list)
    list :::= List("Lovelyz", "Wow")
    println(list)
    list = List(987, 654) ++: list
    println(list)
    list ++:= List("GFriend", "FingerTip")
    println(list)
  }
}
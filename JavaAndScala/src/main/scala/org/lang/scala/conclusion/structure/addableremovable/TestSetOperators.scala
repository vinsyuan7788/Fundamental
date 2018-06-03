package org.scala.conclusion.structure.addableremovable

/**
 * 	This is a stand-alone objects to test Set commonly-used operators
 * 	-- Add: "+="
 *  -- Add flatten: "++="
 *  -- Prepend flatten: "++:="
 *  -- Remove: "-="
 *  -- Remove flatten: "--="
 * 
 * 	@author VinceYuan
 */
object TestSetOperators {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSetOperators()
  }
  
  /**
   * 	This is a method to test Set commonly-used operators
   */
  private def testSetOperators(): Unit = {
    
    /*	This is a set to store elements	 */
    var set = Set[Any]()
    
    /*
     * 	Append an element into a set: "+="
     * 	-- set = set + element
     *  -- set += element
     */
    println("Append using \"+=\"")
    set = set + "Hello Scala"
    println(set)
    set += "Hello Spark!"
    println(set)
    set = set + Set("GFriend", "FingerTip")
    println(set)
    
    /*
     * 	Append a flatten element into a set: "++="
     * 	-- set = set ++ element
     *  -- set ++= element
     */
    println("Append using \"++=\"")
    set = set ++ Set("BlackPink", "Burn baby burn")
    println(set)
    set ++= Set(321, 654)
    println(set)
    
    /*
     * 	Prepend a flatten element into a set: "++:="
     *  -- set = element ++: set 
     *  -- set ++:= (element) 
     */
    println("Prepend using \"++:=\"")
    set = Set(456, 789) ++: set
    println(set)
    set ++:= Set("Lovelyz", "Wow")
    println(set)
    
    /*
     * 	Remove an element from a set: "-="
     *  -- set = set - element
     *  -- set -= element
     */
    println("Remove using \"-=\"")
    set -= "Burn baby burn"
    println(set)
    set -= Set("GFriend", "FingerTip")
    println(set)
    
    /*
     * 	Remove a flatten element from a set: "--"
     *  -- set = set -- element
     *  -- set --= element
     */
    println("Remove using \"--=\"")
    set --= Set(654, 321)
    println(set)
    set --= Set("BlackPink", "Hello Scala", "Hello Spark!")
    println(set)
  }
}
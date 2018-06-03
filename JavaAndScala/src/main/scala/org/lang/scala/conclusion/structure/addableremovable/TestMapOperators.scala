package org.scala.conclusion.structure.addableremovable

/**
 * 	This is a stand-alone object to test Map commonly-used operators
 * 	-- Add: "+="
 *  -- Add flatten: "++="
 *  -- Prepend flatten: "++:="
 *  -- Remove: "-="
 *  -- Remove flatten: "--="
 * 
 * 	@author VinceYuan
 */
object TestMapOperators {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testMapOperators()
  }
  
  /**
   * 	This is a method to test Map commonly-used operators
   */
  private def testMapOperators(): Unit = {
    
    /*	This is a map to store elements	*/
    var map = Map[Any, Any]()
    
    /*
     * 	Append an element into a map: "+="
     * 	-- map += (key -> value)
     *  -- map += ((key, value))
     */
    println("Append using \"+=\"")
    map += (1 -> "Hello Scala")
    println(map)
    map += (2 -> "Hello Spark!")
    println(map)
    map += (("GFriend", "FingerTip"))
    println(map)
    
    /*
     * 	Append a flatten element into a map: "++="
     * 	-- map ++= Map(Key -> Value, ...)
     */
    println("Append using \"++=\"")
    map ++= Map("BlackPink" -> "Burn baby burn", 321 -> 654)
    println(map)
    
    /*
     * 	Prepend a flatten element into a map: "++:="
     *  -- map = Map(Key -> Value, ...) ++: map 
     *  -- map ++:= Map(Key -> Value, ...) 
     */
    println("Prepend using \"++:=\"")
    map = Map(456 -> 789, "Lovelyz" -> "Wow") ++: map
    println(map)
    map = Map(987 -> 654) ++: map
    println(map)
    
    /*
     * 	Remove an element from a map: "-="
     *  -- map = map - key
     *  -- map -= key
     */
    println("Remove using \"-=\"")
    map -= 987
    println(map)
    map -= "GFriend"
    println(map)
    
    /*
     * 	Remove a flatten element from a map: "--="
     *  -- map = map -- keys
     *  -- map --= keys
     */
    println("Remove using \"--=\"")
    map = map -- List(456, "Lovelyz")
    println(map)
    map --= Array("BlackPink", 321, 1, 2)
    println(map)
  }
}
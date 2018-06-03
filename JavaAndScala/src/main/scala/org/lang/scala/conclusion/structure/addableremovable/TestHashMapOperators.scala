package org.scala.conclusion.structure.addableremovable

import scala.collection.mutable.HashMap

/**
 * 	This is a stand-alone object to test HashMap commonly-used operators
 * 	-- Add: "+="
 *  -- Add flatten: "++="
 *  -- Prepend flatten: "++:="
 *  -- Remove: "-="
 *  -- Remove flatten: "--="
 * 
 * 	@author VinceYuan
 */
object TestHashMapOperators {

  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testMapOperators()
  }
  
  /**
   * 	This is a method to test HashMap commonly-used operators
   */
  private def testMapOperators(): Unit = {
    
    /*	This is a hash map to store elements	*/
    var hashMap = HashMap[Any, Any]()
    
    /*
     * 	Append an element into a hash map: "+="
     * 	-- hashMap += (key -> value)
     *  -- hashMap += ((key, value))
     */
    println("Append using \"+=\"")
    hashMap += (1 -> "Hello Scala")
    println(hashMap)
    hashMap += (2 -> "Hello Spark!")
    println(hashMap)
    hashMap += (("GFriend", "FingerTip"))
    println(hashMap)
    
    /*
     * 	Append a flatten element into a hash map: "++="
     * 	-- hashMap ++= HashMap(Key -> Value, ...)
     */
    println("Append using \"++=\"")
    hashMap ++= HashMap("BlackPink" -> "Burn baby burn", 321 -> 654)
    println(hashMap)
    
    /*
     * 	Prepend a flatten element into a hash map: "++:="
     *  -- hashMap = HashMap(Key -> Value, ...) ++: hashMap 
     *  -- hashMap ++:= HashMap(Key -> Value, ...) 
     */
    println("Prepend using \"++:=\"")
    hashMap ++:= HashMap(456 -> 789, "Lovelyz" -> "Wow")
    println(hashMap)
    hashMap ++:= HashMap(987 -> 654)
    println(hashMap)
    
    /*
     * 	Remove an element from a hash map: "-="
     *  -- hashMap = hashMap - key
     *  -- hashMap -= key
     */
    println("Remove using \"-=\"")
    hashMap -= 987
    println(hashMap)
    hashMap -= "GFriend"
    println(hashMap)
    
    /*
     * 	Remove a flatten element from a hash map: "--="
     *  -- hashMap = hashMap -- keys
     *  -- hashMap --= keys
     */
    println("Remove using \"--=\"")
    hashMap = hashMap -- List(456, "Lovelyz")
    println(hashMap)
    hashMap --= Array("BlackPink", 321, 1, 2)
    println(hashMap)
  }
}
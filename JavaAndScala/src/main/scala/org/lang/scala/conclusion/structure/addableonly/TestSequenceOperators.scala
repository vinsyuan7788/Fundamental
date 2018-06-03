package org.scala.conclusion.structure.addableonly

/**
 * 	This is a stand-alone object to test Sequence commonly-used operators
 *  -- Add: ":+"
 *  -- Add flatten: "++"
 *  -- Prepend: "+:"
 *  -- Prepend flatten: "++:"
 *   	
 * 	@author VinceYuan
 */
object TestSequenceOperators {
 
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testSequenceOperators()
  }
  
  /**
   * 	This is a method to test Sequence commonly-used operators
   */
  private def testSequenceOperators(): Unit = {
    
    /*	This is a sequence to store elements	 */
    var seq = Seq[Any]()
    
    /*
     * 	Append an element into a sequence: ":+"
     *  -- seq = seq :+ element
     *  -- seq :+= element
     */
    println("Append using \"+=\"")
    seq = seq :+ "Hello Scala"
    println(seq)
    seq :+= "Hello Spark!"
    println(seq)
    seq :+= Seq("Hi Scala")
    println(seq)
    
    /*
     * 	Append a flatten element into a sequence: "++"
     *  -- seq = seq ++ element
     *  -- seq ++= element
     */
    println("Append using \"++\"")
    seq ++= Seq("BlackPink", "Burn baby burn")
    println(seq)
    seq ++= Seq(321, 654)
    println(seq)
    
    /*
     * 	Prepend an element into a sequence: "+:"
     *  -- seq = element +: seq 
     *  -- seq +:= (element) 
     */
    println("Prepend using \"+:\"")
    seq = "My Darling" +: seq
    println(seq)  
    seq +:= Seq(123)
    println(seq)  

    /*
     * 	Prepend a flatten element into a sequence: "++:"
     *  -- seq = element ++: seq 
     *  -- seq ++:= (element) 
     */
    println("Prepend using \"++:\"")
    seq = Array(456, 789) ++: seq
    println(seq)
    seq ++:= Seq("Lovelyz", "Wow")
    println(seq)
  }
}
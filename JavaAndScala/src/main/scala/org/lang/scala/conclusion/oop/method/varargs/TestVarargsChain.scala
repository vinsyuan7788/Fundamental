package org.lang.scala.conclusion.oop.method.varargs

/**
 * 	This is a method to test varargs chain
 * 	-- If an varargs need to be passed into another varargs, MUST use "_*"
 *     -- Since an varargs passed into a method becomes an instance (or a whole argument) "WrappedArray(...)"
 * 
 * 	@author VinceYuan
 */
object TestVarargsChain {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testVarargsChain()
  }
  
  /**
   * 	This is a method to test varargs chain
   */
  private def testVarargsChain(): Unit = {

    /*	Test varargs chain basics	 */
    chainVarargs_unsuccessfully(1, "ABC", 'U', false)
    chainVarargs_successfully(1, "ABC", 'U', false)
    chainVarargs_unsuccessfully(Array(1, "ABC", 'U', false): _*)
    chainVarargs_successfully(Array(1, "ABC", 'U', false): _*)
    chainVarargs_unsuccessfully(List(1, "ABC", 'U', false): _*)
    chainVarargs_successfully(List(1, "ABC", 'U', false): _*)
    chainVarargs_unsuccessfully(1, "ABC", 'U', false, 2, "CDE", 'K', true)
    chainVarargs_successfully(1, "ABC", 'U', false, 2, "CDE", 'K', true)
    chainVarargs_unsuccessfully(Array(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    chainVarargs_successfully(Array(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    chainVarargs_unsuccessfully(List(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    chainVarargs_successfully(List(1, "ABC", 'U', false, 2, "CDE", 'K', true): _*)
    chainVarargs_unsuccessfully(Array(1, "ABC", 'U', false).toBuffer, Array(2, "CDE", 'K', true).toBuffer)
    chainVarargs_successfully(Array(1, "ABC", 'U', false).toBuffer, Array(2, "CDE", 'K', true).toBuffer)
    chainVarargs_unsuccessfully(List(1, "ABC", 'U', false), List(2, "DEF", 'K', true))
    chainVarargs_successfully(List(1, "ABC", 'U', false), List(2, "DEF", 'K', true))
  }
  
  /**
   * 	Here are the methods that chain varargs
   */
  private def chainVarargs_unsuccessfully(x: Any*) = {
    println("Varargs: " + x) 
    println("Varargs length: " + x.length)
    getVarargs(x)(x)
  }
  private def chainVarargs_successfully(x: Any*) = {
    println("Varargs: " + x) 
    println("Varargs length: " + x.length)
    getVarargs(x: _*)(x)
  }
  private def getVarargs(x: Any*)(y: Seq[Any]) = {
    println("Chain varargs: " + x) 
    println("Chain Varargs length: " + x.length)
    println("If chain varargs succeeds? " + (x == y && x.length == y.length) + "\n")
  }
}
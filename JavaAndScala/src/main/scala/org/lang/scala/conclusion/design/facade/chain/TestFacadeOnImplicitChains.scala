package org.lang.scala.conclusion.design.facade.chain

import org.lang.scala.conclusion.design.facade.chain.classes.A
import org.lang.scala.conclusion.design.facade.chain.classes.B
import org.lang.scala.conclusion.design.facade.chain.classes.C
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.aToB
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.bToC
import org.lang.scala.conclusion.design.facade.facade.CustomPredef.toA

/**
 * 	This is a stand-alone object to test facade pattern on implicit chains
 * 
 * 	@author VinceYuan
 */
object TestFacadeOnImplicitChains {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testFacadeOnImplicitChains()
  }
  
  /**
   * 	This is a method to test facade on implicits chain 
   */
  private def testFacadeOnImplicitChains(): Unit = {
    
    val n = 5
    println(n.sum)
    println(n.getA)
    println(n.getB)
    println(n.getC)
    val a = new A(5)
    println(a.sum)
    println(a.getA)
    println(a.getB)
    println(a.getC)
    val b = new B(5, 5)
    println(b.sum)
    println(b.getB)
    println(b.getC)
    val c = new C(5, 5, 10)
    println(c.sum)
    println(c.getC)
  }
}
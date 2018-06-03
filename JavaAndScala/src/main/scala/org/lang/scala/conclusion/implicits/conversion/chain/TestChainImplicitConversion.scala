package org.lang.scala.conclusion.implicits.conversion.chain

import scala.reflect.runtime.universe._

import org.lang.scala.conclusion.implicits.common.conversion.classes.A
import org.lang.scala.conclusion.implicits.common.conversion.classes.B
import org.lang.scala.conclusion.implicits.common.conversion.classes.C

object TestChainImplicitConversion {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testImplicitChains()
  }
  
  /**
   * 	This is a method to test implicit chains
   */
  private def testImplicitChains(): Unit = {
    
    val n = 5
    println(n.getA)
    println(n.getB)
    println(n.getC)
    println(n.sum)
    println()
    val a = new A(5)
    println(a.getA)
    println(a.getB)
    println(a.getC)
    println(a.sum)
    println()
    val b = new B(5, 5)
    println(b.getB)
    println(b.getC)
    println(b.sum)
    println()
    val c = new C(5, 5, 5)
    println(c.getC)
    println(c.sum)
  }
  
  /*	Here are implicit conversions for implicit chains	 */
  /**
   * 	For n:
   *  -- Through "ntoA": n => A
   */
  private implicit def ntoA(n: Int): A = {
    new A(n)
  }
  /**
   * 	For n:
   *  -- ---> Through "ntoA": n => A --->
   *     implicitly referred by "f: T => A" ---> T = A 
   *     ---> Through "aToB" ---> A => B
   *  For A:
   *  -- ---> new A: A => A --->
   *     implicitly referred by "f: A => A"
   */
  private implicit def atoB[T : TypeTag](a: T)(implicit f: T => A): B = {
    println(s"Here T is ${typeTag[T].tpe}")
    new B(a.x, a.x)
  }
  private implicit def bToC[G : TypeTag](b: G)(implicit f: G => B): C = {
    new C(b.x, b.y, b.x + b.y)  
  }
}
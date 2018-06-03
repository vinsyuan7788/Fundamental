package org.lang.scala.algorithm.ec

import scala.BigInt

import org.lang.scala.algorithm.ec.cases.Point

/**
 * 	This is a stand-alone object to perform EC (Elliptic Curve) Cryptography
 * 
 * 	@author VinceYuan
 */
object EllipticCurve {
  
  /*	Necessary instance variables for ellipse E: y^2 = x^3 + ax + b (mod p), p is prime	 */
  private val a = 7
  private val b = 15
  private val p = 3571
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
  
    /*	Do the multiplication for a point	 */
    val k = 150
    val g1 = Point(16,3096)
    computeMultiplication(k, g1)
    
    /*	Find the order of a point	 */
    val g2 = Point(2288, 1585)
    findOrder(g2)
  }
  
  /**
   * 	This is a method to compute multiplication for a (generator) point
   */
  private def computeMultiplication(k: Int, g: Point) = {
    var mulRes = ellipticMul(k, g)
    println(s"Multiplication result of $g on E: y^2 = x^3 + ${a}x + $b (mod $p): ${mulRes}")
  }
  
  /**
   * 	This is a method to find the order of a (generator) point
   */
  private def findOrder(g: Point) = {
    var order = 2
    try {
      while (true) {
        ellipticMul(order, g)
        order = order + 1
      }
    } catch {
      case t: Throwable => {
        println(s"The order of $g on E: y^2 = x^3 + ${a}x + $b (mod $p): ${order}")
      }
    }
  }
  
  /**
   * 	This is a method to implement elliptic multiplication
   */
  private def ellipticMul(k: Int, g: Point): Point = {
    
    /*	Initialize a variable to record the result	*/
    var result = g
    
    /*	If K < 2, then print out a message	*/
    if (k < 2) {
      println("K value must be equal or greater than 2! Return the generator.")
      
    /*	If K >= 2, then start the multiplication	*/
    } else {
      val q = g
      var lastPoint = g
      for (i <- 2 to k) {
        result = ellipticAdd(lastPoint, q)
        lastPoint = result
      } 
    }
    
    /*	Return the result	 */
    result
  }
  
  /**
   * 	This is a method to implement elliptic addition
   */
  private def ellipticAdd(p: Point, q: Point): Point = {
    
    /*	If Point p and Point q are NOT the same point  */
    if (!p.equals(q)) {
      val A = mod(mod(p.y - q.y, this.p) * modInverse(p.x - q.x, this.p), this.p)
      val x = mod(A * A - p.x - q.x, this.p)
      val y = mod(A * (p.x - x) - p.y, this.p)
      Point(x, y)
      
    /*	If Point p and Point q are the same point	 */
    } else {
      val B = mod(mod(3 * p.x * p.x + a, this.p) * modInverse(2 * p.y, this.p), this.p)
      val x = mod(B * B - 2 * p.x, this.p)
      val y = mod(B * (p.x - x) - p.y, this.p)
      Point(x, y)
    }
  }
  
  /**
   * 	Here are the methods for mod and mod-inverse computation
   */
  private def mod(num: Int, mod: Int): Int = {
    BigInt(num).mod(BigInt(mod)).intValue()
  }
  private def modInverse(num: Int, mod: Int): Int = {
    BigInt(num).modInverse(BigInt(mod)).intValue()
  }
}
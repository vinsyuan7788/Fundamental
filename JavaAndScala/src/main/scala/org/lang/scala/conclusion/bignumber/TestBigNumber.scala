package org.lang.scala.conclusion.bignumber

/**
 * 	This is a stand-alone object to test BigDecimal and BigInt
 * 	-- BigDecimal can be used to ensure the precision of number calculation
 *  -- BigInt can be used to do mod and mod-inverse calculation
 *  -- BigDecimal and BigInt can represent the calculated result in any order of magnitude
 *  
 * 	@author VinceYuan
 */
object TestBigNumber {
  
  /*	Necessary instance variables	*/
  private val d1 = 2.0d; private val d2 = 1.1d; private val d3 = 3.0d
  private val f1 = 0.08f; private val f2 = 0.01f; private val f3 = 0.2f
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testNumberCalculation()
    println()
    testAccurateCalculation()
    println()
    testModAndModInverseCalculation()
    println()
    testBigNumberRepresentation()
    println()
    testOtherMethods()
  }
  
	/**
	 * 	There are problems regarding number calculation
	 * 	-- Double-typed and float-typed calculation maybe inaccurate
	 */
  private def testNumberCalculation(): Unit = {
    
		/*	Calculation of Double type maybe inaccurate	 */
		println("Calculation of Double type maybe inaccurate. For examples:")
		println("Substraction: " + d1 + " - " + d2 + " = " + (d1 - d2))
		println("Multiplication: " + d3 + " * " + d2 + " = " + (d3 * d2))
		
		/*	Calculation of Float type maybe inaccurate	*/
		println("\nCalculation of Float type maybe inaccurate. For exmaples:")
		println("Addition: " + f1 + " + " + f2 + " = " + (f1 + f2))
		println("Division: " + f1 + " / " + f3 + " = " + (f1 / f3))
  }

	/**
	 * 	This is a method to test accurate calculation
	 * 
	 * 	BigDecimal can be used to:
	 * 	-- Address the calculation inaccuracy
	 */
  private def testAccurateCalculation(): Unit = {

		/*	
		 * 	Use BigDecimal to do precise calculation
		 *  -- Make sure the argument is (converted to) String type	
		 */
		val d1_bd = BigDecimal(d1)
		val d2_bd = BigDecimal(String.valueOf(d2))      // This way is recommended due to declaration consistency of different data types
		val d3_bd = BigDecimal.valueOf(d3)
		val f1_bd = BigDecimal.decimal(f1)
		val f2_bd = BigDecimal(String.valueOf(f2))
		val f3_bd = BigDecimal(String.valueOf(f3))
		System.out.println("Calculation of BigDecimal type is accurate:")
		System.out.println("Subtraction: " + d1_bd + " - " + d2_bd + " = " + (d1_bd - d2_bd).doubleValue())
		System.out.println("Multiplication: " + d3_bd + " * " + d2_bd + " = " + (d3_bd * d2_bd).doubleValue())
		System.out.println("Addition: " + f1_bd + " + " + f2_bd + " = " + (f1_bd + f2_bd).floatValue())
		System.out.println("Division: " + f1_bd + " / " + f3_bd + " = " + (f1_bd / f3_bd).floatValue())
  }
  
  /**
   * 	This is a method to test mod and mod-inverse calculation
   * 
   *  BigInt can be used to:
	 * 	-- Do mod and mod-inverse calculation
   */
  private def testModAndModInverseCalculation(): Unit = {
    
    /*	Initialize two integers	 */
    val i = 5
    val j = 12
    
    /*	Do mod and mod-inverse calculation	*/
    val mod_1 = BigInt(i).mod(BigInt(j))
    val mod_2 = BigInt(j).mod(BigInt(i))
    val modInverse_1 = BigInt(i).modInverse(BigInt(j))
    val modInverse_2 = BigInt(j).modInverse(BigInt(i))
    println("Mod and Mod-Inverse calculation through BigInt:")
    println(s"$i mod $j: $mod_1")
    println(s"$j mod $i: $mod_2")
    println(s"$i mod-inverse $j: $modInverse_1")
    println(s"$j mod-inverse $i: $modInverse_2")
  }
  
  /**
	 * 	This is a method to test big number representation
	 * 
	 * 	BigDecimal and BigInt can be used to:
	 *  -- Represent an integer with any order of magnitude
	 *  -- Notice that when a number becomes very large, BigDecimal will adopt scientific notation while BigInt will not
	 *     -- This will make some undesirable result. E.g., compare 2 computational results between BigDecimal and BigInt
	 */
  private def testBigNumberRepresentation(): Unit = {
    
    /*	Use BigDecimal to do (1.5 * 2.5 * ... * 999.5 * 1000.5)	 */
		var sum_bd = BigDecimal(String.valueOf(1))
		for (i <- 1.5 to 1000.5 by 1) {
			sum_bd = sum_bd * BigDecimal(String.valueOf(i))
		}
		println("The (1.5 * 2.5 * ... * 999.5 * 1000.5) result using BigDecimal:\n" + sum_bd)
		println("The digits of the result: " + sum_bd.precision)
		println("The digits of decimal part: " + sum_bd.scale)
		
		/*	Use BigDecimal and BigInteger to do 1000 factorial and compare the results	*/
		sum_bd = BigDecimal(String.valueOf(1))
		for (i <- 1 to 1000) {
			sum_bd = sum_bd * BigDecimal(String.valueOf(i))
		}
		println("\nThe 1000 factorial result using BigDecimal:\n" + sum_bd)
		println("The digits of the result: " + sum_bd.precision)
		println("The digits of decimal part: " + sum_bd.scale)
		
		/*	Use BigInt to do 1000 factorial	 */
		var sum_bi = BigInt(String.valueOf(1))
		for (i <- 1 to 1000) {
			sum_bi = sum_bi * BigInt(String.valueOf(i))
		}
		println("\nThe 1000 factorial result using BigInt:\n" + sum_bi)
		println("The digits of the result: " + sum_bd.precision)
		println("The digits of decimal part: " + sum_bd.scale)
		
		/*	Compare the calculated results from BigDecimal and BigInteger	*/
		if (sum_bd != null && sum_bi != null) {
			println("\nIf these two 1000 factorial results are equal: " + sum_bi.equals(sum_bd.toBigInt()) + " (due to the scientific notation of BigDecimal in Scala)")
		}
  }
  
  /**
   * 	This is a method to test other methods of BigDecimal and BigInt
   */
  private def testOtherMethods(): Unit = {
 
		/*	Here is to test BigDecimal methods	 */
		val bd = BigDecimal(String.valueOf(921.2))
		println("Below is big decimal:")
		println("The scale of \"" + bd + "\": " + bd.scale)
		println("The precision of \""+ bd + "\": " + bd.precision)
//		println("The unscaled value of \"" + bd + "\": " + bd.unscaledValue)
//		println("The negate of \"" + bd + "\": " + bd.negate)
//		println("The plus of \"" + bd + "\": " + bd.plus)
		println("The sigum of \"" + bd + "\": " + bd.signum)
		println("The ulp of \"" + bd + "\": " + bd.ulp)
		
		/*	Here is to test BigInt methods	*/
		val bi = BigInt(String.valueOf(234))
		val bi2 = BigInt(String.valueOf(432))
		System.out.println("\nBelow is big decimal:")
		System.out.println("The bit count of \"" + bi + "\": " + bi.bitCount)
		System.out.println("The NOT result of \"" + bi + "\": " + (- (bi + 1)))
		System.out.println("The AND result of \"" + bi + "\" and \"" + bi2 + "\": " + (bi & bi2))
		System.out.println("The OR result of \"" + bi + "\" and \"" + bi2 + "\": " + (bi | bi2))
		System.out.println("The XOR result of \"" + bi + "\" and \"" + bi2 + "\": " + ((bi | bi2) &~ (bi & bi2)))
  }
}
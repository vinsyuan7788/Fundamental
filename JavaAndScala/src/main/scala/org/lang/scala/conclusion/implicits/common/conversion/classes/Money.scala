package org.lang.scala.conclusion.implicits.common.conversion.classes

/**
 * 	This is a companion class to test implicit conversion from the companion object of argument's class
 * 
 * 	@author VinceYuan
 */
class Money(

    val amount: Double
    
) {
  
  def + (money: Money) = new Money(amount + money.amount)
  override def toString() = s"Money[amount=${amount}]"
}

/**
 * 	This is a companion object to test implicit conversion from the companion object of argument's class
 * 
 * 	@author VinceYuan
 */
object Money {
  
  implicit def toMoney(int: Int) = new Money(int.toDouble)
  implicit def toMoney(double: Double) = new Money(double)
}
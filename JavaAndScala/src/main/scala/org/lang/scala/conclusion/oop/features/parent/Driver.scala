package org.lang.scala.conclusion.oop.features.parent

import java.util.UUID

import scala.util.Random

/**
 * 	This is a stand-alone object to test OOP
 * 	-- There is only 1 primary constructor
 *     -- The primary constructor has parameter list (name, age)
 * 
 * 	@author VinceYuan
 */
abstract class Driver(

    val name: String,
    val age: Int,
    val id: String = UUID.randomUUID().toString(),
    val salary: Long = if (Random.nextInt(2) == 1) 20000l else 25000l
    
) {
  
  def getInfo() = {
    println(s"Driver[id=${id}, name=${name}, age=${age}, salary=${salary}]")
  }
}
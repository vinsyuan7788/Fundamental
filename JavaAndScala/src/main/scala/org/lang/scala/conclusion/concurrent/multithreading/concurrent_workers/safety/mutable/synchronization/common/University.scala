package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.synchronization.common

/**
 * 	This is a stand-alone class to serve as a shared resource
 * 
 * 	@author VinceYuan
 */
class University {
  
  /*	Instance variables that serve as global variables that will be shared and operated among threads	 */
  var studentNumber = 10000
  
  /*	Print initial students of this university	 */
  println(s"Student number is ${studentNumber} in this university initially.")
  
  /**
   * 	This is a method to enroll students
   */
  def enrollStudent(number: Int) = {
    
//    getClass.synchronized {      // Uncomment this statement to see the correct test result
      studentNumber += number
      println(s"Agency ${Thread.currentThread().getId()} enrolled ${number} students. Now ${studentNumber} left in the university.") 
//    }                            // Uncomment this statement to see the correct test result
  }
}
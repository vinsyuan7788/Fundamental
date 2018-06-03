package org.lang.scala.conclusion.date

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import org.lang.scala.common.utils.OrdinalUtils

/**
 * 	This is a stand-alone object to test date
 * 	-- Including the conversion among date, calendar and string
 * 
 * 	@author VinceYuan
 */
object TestDateAndCalendarAndString {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testCompareDate()
    println()
    testDateComputation()
    println()
    testCalendarDateStringConversion()
  }

	/**
	 * 	This is a method to test date comparison 
	 */
  private def testCompareDate(): Unit = {
    
  	/*	Get 2 date objects by directly instantiating current date & parsing a string respectively	*/
  	val date1 = new Date()
  	val date2 = new SimpleDateFormat("MM/dd/yyyy").parse("12/13/2016")
  	
  	/*	Do the date comparison by "compareTo()" with "switch case"	*/ 
  	date1.compareTo(date2) match {
  	  case -1 => println(date1 + " is before " + date2)
  	  case 0 => println(date1 + " is equal to " + date2)
  	  case 1 => println(date1 + " is after " + date2)
  	}
  }
  
  /**
   * 	This is a method to test Date computation
   */
  private def testDateComputation(): Unit = {
    
    val dateFormat = new SimpleDateFormat("yyyyMMddHHmmss")
    val dateTime1 = dateFormat.parse("20170126011223").getTime
    val dateTime2 = dateFormat.parse("20170126080233").getTime
    val dataTimeSum = dateTime1 + dateTime2
    val dateTimeSbtr = -dateTime1 + dateTime2
    println(dateTime1)
    println(dateTime2)
    println(dataTimeSum)
    println(dateTimeSbtr)
  }
  
	/**
	 * 	Test the conversion among Calendar, Date and String
	 * 	-- Date: from String and Calendar
	 * 	-- Calendar: from String and Date
	 * 	-- String: from Date and Calendar
	 */
	private def testCalendarDateStringConversion(): Unit = {
	  
	  /*	Date from String	*/
		val dateFromString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-12-12 14:15:16");
		System.out.println("The date from String: " + dateFromString);
		
		/*	Date from Calendar  */
		val dateFromCalendar = Calendar.getInstance().getTime();
		System.out.println("The date from calendar: " + dateFromCalendar);
		
		/*	Calendar from String	*/
		val calendarFromString = Calendar.getInstance();
		calendarFromString.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-12-12 14:15:16"));
		System.out.println("The calendar from string: " + 
				calendarFromString.get(Calendar.YEAR) + "-" + (calendarFromString.get(Calendar.MONTH) + 1) + "-" + calendarFromString.get(Calendar.DAY_OF_MONTH) + ", the " +
				OrdinalUtils.toOrdinal(calendarFromString.get(Calendar.WEEK_OF_MONTH)) + " week of this month and the " + OrdinalUtils.toOrdinal(calendarFromString.get(Calendar.DAY_OF_WEEK) - 1) + " day of this week, " + 
				calendarFromString.get(Calendar.HOUR_OF_DAY) + ":" + calendarFromString.get(Calendar.MINUTE) + ":" + calendarFromString.get(Calendar.SECOND));
		
		/*	Calendar from Date	*/
		val calendarFromDate = Calendar.getInstance();
		calendarFromDate.setTime(new Date());
		System.out.println("The calendar from string: " + 
				calendarFromDate.get(Calendar.YEAR) + "-" + (calendarFromDate.get(Calendar.MONTH) + 1) + "-" + calendarFromDate.get(Calendar.DAY_OF_MONTH) + ", the " +
				OrdinalUtils.toOrdinal(calendarFromDate.get(Calendar.WEEK_OF_MONTH)) + " week of this month and the " + OrdinalUtils.toOrdinal(calendarFromDate.get(Calendar.DAY_OF_WEEK) - 1) + " day of this week, " + 
				calendarFromDate.get(Calendar.HOUR_OF_DAY) + ":" + calendarFromDate.get(Calendar.MINUTE) + ":" + calendarFromDate.get(Calendar.SECOND));
		
		/*	String from Date	*/
		val stringFromDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("The string from date: " + stringFromDate);
		
		/*	String from Calendar	*/
		val stringFromCalender = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		System.out.println("The string from calendar: " + stringFromCalender);
	}
}
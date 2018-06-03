package com.java.se.conclusion.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.java.se.common.utils.OrdinalUtils;

/**
 * 	This is a class to test date
 *  -- Including the conversion among date, calendar and string
 * 
 * @author VinceYuan
 *
 */
public class TestDateAndCalendarAndString {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestDateAndCalendarAndString testDateAndCalendarAndString = new TestDateAndCalendarAndString();
		System.out.println("Here tests date comparison:");
		testDateAndCalendarAndString.testCompareDate();
		System.out.println("\nHere tests conversion among calendar, date and string:");
		testDateAndCalendarAndString.testCalendarDateStringConversion();
	}
	
	/**
	 * 	Test date comparison 
	 * 	-- "Switch case" is only workable for int-typed expression or the expression whose result can be automatically 
	 *     converted to int type (namely byte, short, char, int)
	 */
	private void testCompareDate() {
		
		try {
			/*	Get 2 date objects by directly instantiating current date & parsing a string respectively	*/
			Date date1 = new Date();
			Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("12/13/2016");
			
			/*	Do the date comparison by "compareTo()" with "switch case"	*/
			switch (date1.compareTo(date2)) {
			case -1: 
				System.out.println(date1 + " is before " + date2);
				break;
			case 0: 
				System.out.println(date1 + " is equal to " + date2);
				break;
			case 1: 
				System.out.println(date1 + " is after " + date2); 
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test the conversion among Calendar, Date and String
	 * 	-- Date: from String and Calendar
	 * 	-- Calendar: from String and Date
	 * 	-- String: from Date and Calendar
	 */
	private void testCalendarDateStringConversion() {
		
		try {
			/*	Date from String	*/
			Date dateFromString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-12-12 14:15:16");
			System.out.println("The date from String: " + dateFromString);
			
			/*	Date from Calendar  */
			Date dateFromCalendar = Calendar.getInstance().getTime();
			System.out.println("The date from calendar: " + dateFromCalendar);
			
			/*	Calendar from String	*/
			Calendar calendarFromString = Calendar.getInstance();
			calendarFromString.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-12-12 14:15:16"));
			System.out.println("The calendar from string: " + 
					calendarFromString.get(Calendar.YEAR) + "-" + (calendarFromString.get(Calendar.MONTH) + 1) + "-" + calendarFromString.get(Calendar.DAY_OF_MONTH) + ", the " +
					OrdinalUtils.toOrdinal(calendarFromString.get(Calendar.WEEK_OF_MONTH)) + " week of this month and the " + OrdinalUtils.toOrdinal(calendarFromString.get(Calendar.DAY_OF_WEEK) - 1) + " day of this week, " + 
					calendarFromString.get(Calendar.HOUR_OF_DAY) + ":" + calendarFromString.get(Calendar.MINUTE) + ":" + calendarFromString.get(Calendar.SECOND));
			
			/*	Calendar from Date	*/
			Calendar calendarFromDate = Calendar.getInstance();
			calendarFromDate.setTime(new Date());
			System.out.println("The calendar from string: " + 
					calendarFromDate.get(Calendar.YEAR) + "-" + (calendarFromDate.get(Calendar.MONTH) + 1) + "-" + calendarFromDate.get(Calendar.DAY_OF_MONTH) + ", the " +
					OrdinalUtils.toOrdinal(calendarFromDate.get(Calendar.WEEK_OF_MONTH)) + " week of this month and the " + OrdinalUtils.toOrdinal(calendarFromDate.get(Calendar.DAY_OF_WEEK) - 1) + " day of this week, " + 
					calendarFromDate.get(Calendar.HOUR_OF_DAY) + ":" + calendarFromDate.get(Calendar.MINUTE) + ":" + calendarFromDate.get(Calendar.SECOND));
			
			/*	String from Date	*/
			String stringFromDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			System.out.println("The string from date: " + stringFromDate);
			
			/*	String from Calendar	*/
			String stringFromCalender = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			System.out.println("The string from calendar: " + stringFromCalender);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.java.se.conclusion.exception;

/**
 * 	This is the class to perform testing regarding exception
 * 	-- Unchecked exception: the uncheckable exception by JVM
 *     -- Error, RuntimeException
 *     -- Unchecked exception is unprocessable
 *  -- Checked exception: the checkable exception by JVM
 *     -- All Exception classes except Error, RuntimeException: OutOfMemoryError, IllegalArgumentException, etc.
 *     -- Checked exception is processable
 *     
 *  To process checked exception:
 *  -- Use "try...catch...finally..." to process the exception
 *     -- E.g., print out some message, do some corresponding resolution, etc.
 *  -- Use "throws Exception" on the method or "throw new RuntimeException(Throwable e)" inside the method
 *     -- Whoever invokes the method with thrown-out exceptions can choose if want to process the exception or not
 *     -- If the exception is not processed all the time, then it will be finally printed to failure trace 
 *  
 *  In Web application implementation:
 *  -- Use a global exception resolver to process the exception:
 *     -- E.g., output some readable information to front-end
 *  -- If there is an exception, try catch it
 *     -- If it is checked exception, throw it out using using RuntimeException
 *     -- If it is other exception, throw it out using custom exception class
 *        -- Custom exception class can be created by extending Exception class
 *  -- Do the exception logging to record necessary exception
 *     -- Can be realized in global exception resolver or using AOP
 *     
 * @author VinceYuan
 *
 */
public class TestException {

}

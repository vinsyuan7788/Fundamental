package com.java.se.conclusion.dandc.intramachine.processbuilder;

import static com.java.se.conclusion.dandc.common.classes.ProcessFeasibleOptions.ITERATIONS;
import static com.java.se.conclusion.dandc.common.classes.ProcessFeasibleOptions.THREAD_NAME;

import java.util.Random;

import com.java.se.conclusion.dandc.common.classes.ProcessOptions;
import com.java.se.conclusion.dandc.common.utils.ProcessOptionsParser;

/**
 * 	This is a class that contains a program to be exported to be executed by ProcessBuilder
 * 
 * @author VinceYuan
 *
 */
public class TestProgramForProcessBuilder {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		/*	Parse the arguments to options	*/
		ProcessOptions options = ProcessOptionsParser.parseArgumentsToOptions(args);
				
		/*	Get current thread and set a specific name for current thread	*/
		Thread currentThread = Thread.currentThread();
		currentThread.setName(options.get(THREAD_NAME));
		
		/*	Perform some tasks: create a specific number of random numbers in [0, 100]	*/
		for (int i = 0; i < Integer.parseInt(options.get(ITERATIONS)); i++) {
			System.out.println(currentThread.getName() + ": " + new Random().nextInt(101));
		}
		
		/*	Current thread sleeps for 5 seconds	 */
		Thread.sleep(5000);
	}
}

package com.java.se.conclusion.dandc.common.classes;

import static com.java.se.conclusion.dandc.common.classes.ProcessFeasibleOptions.ITERATIONS;
import static com.java.se.conclusion.dandc.common.classes.ProcessFeasibleOptions.THREAD_NAME;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 	This is a class to represent options for current process
 * 
 * @author VinceYuan
 *
 */
public class ProcessOptions {

	/*	Necessary static variables	*/
	private Map<String, String> options;
	
	/*	Constructors	*/
	public ProcessOptions(String[] args) {		
		options = new ConcurrentHashMap<>();
		try {
			parseArgumentsToOptions(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	This is a method to get value according to key
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return options.get(key);
	}
	
	/**
	 * 	This is a method to parse the arguments to options
	 * 
	 * @param args
	 * @throws Exception
	 */
	private void parseArgumentsToOptions(String[] args) throws Exception {
		
		if (args.length == 0) {
			options.put(THREAD_NAME, "Integer");
			options.put(ITERATIONS, "10");
		} else {
			for (int i = 0; i < args.length; i++) {
				if(args[i].startsWith("--")) {
					String option = args[i];	
					switch (option) {
					case THREAD_NAME: 
						break;
					case ITERATIONS: 
						break;
					default: 
						throw new Exception("Unrecognized option!");
					}
				} else {
					if (i == 0) throw new Exception("Unrecognized option!");
					String value = args[i];
					String option = args[i - 1];
					switch (option) {
					case THREAD_NAME:
						checkNotNull(value);
						options.put(THREAD_NAME, value);
						break;
					case ITERATIONS:
						checkNotNull(value);
						options.put(ITERATIONS, value);
						break;
					}
				}
			}
			if (options.get(THREAD_NAME) == null || options.get(THREAD_NAME).equals(null)) {
				options.put(THREAD_NAME, "Integer");
			}
			if (options.get(ITERATIONS) == null || options.get(ITERATIONS).equals(null)) {
				options.put(ITERATIONS, "10");
			}
		}	
	}
	
	/**
	 * 	This is a method to check if the option value is null
	 * 
	 * @param value
	 * @throws Exception
	 */
	private void checkNotNull(String value) throws Exception {
		if (value.isEmpty()) throw new Exception("option value cannot be empty!");
	}
}

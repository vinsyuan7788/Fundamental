package com.java.se.conclusion.path;

import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 	This is a class to test Path class
 * 
 * @author VinceYuan
 *
 */
public class TestPath {

	/*	Necessary instance variables	*/
	private String pathRelativeToCurrentProject;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestPath testPath = new TestPath();
		testPath.testPreparation();
		testPath.testPath();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		pathRelativeToCurrentProject = "src/main/java/com/java/se/conclusion/path/common/test";
	}

	/**
	 * 	This is a method to test Path class
	 */
	private void testPath() {
		
		try {
			Path path = Paths.get(pathRelativeToCurrentProject);
			System.out.println("The path is:\n" + path.toString());
			System.out.println("\nThe file name:\n" + path.getFileName());
			System.out.println("\nThe parent directory:\n" + path.getParent());
			System.out.println("\nThe absolute path:\n" + path.toAbsolutePath());
			System.out.println("\nThe absolute path (except shortcut file):\n" + path.toRealPath(LinkOption.NOFOLLOW_LINKS));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

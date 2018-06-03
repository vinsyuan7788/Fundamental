package com.java.se.conclusion.file;

import java.io.File;

import com.java.se.common.utils.FileUtils;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test File class
 * 	-- In web project: use "servlet.getRealPath()" to get the real path on disk
 */
public class TestFile {
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestFile testFile = new TestFile();
		System.out.println("Here tests file separator:");
		testFile.testFileSeparator();
		System.out.println("\nHere tests file:");
		testFile.testFile();
		System.out.println("\nHere tests to get current project path:");
		testFile.testProjectPath();
	}
	
	/**
	 * 	Test file separator:
	 * 	-- In Java: "\\" == "/"
	 */
	private void testFileSeparator () {
		
		/*	Create a directory using "\\"	*/
		File file1 = new File(Configuration.Conclusion.FILE_PATH_TO_TEST_SEPARATOR_1);
		file1.mkdirs();
		
		/*	Check if "\\" == "/"	*/
		File file2 = new File(Configuration.Conclusion.FILE_PATH_TO_TEST_SEPARATOR_2);
		if (file2.exists()) {
			System.out.println("\"\\\\\" == \"/\" in Java directory");
		} else {
			System.out.println("\"\\\\\" != \"/\" in Java directory");
		}
		
		/*	Delete the created directory	*/
		System.out.println("Delete the test directory: " + file1.delete());
	}
	
	/**
	 * 	Test file operation
	 *  -- When delete a file or directory, only the deepest node gets deleted
	 *     -- E.g, if delete "C:/JavaTest/File/TestFile/Hello.txt", "C:/JavaTest/File/TestFile/" will remain
	 *     -- E.g., if delete "C:/JavaTest/File/TestFileSeparator/", "C:/JavaTest/File/" will remain
	 */
	private void testFile () {
		
		/*	Given a file path	*/
		String filePath = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE;
		
		/*	Instantiate a File object & output necessary information	*/
		File file = new File(filePath);
		System.out.println("The absolute path: " + file.getAbsolutePath());
		System.out.println("The parent file: " + file.getParentFile());
		System.out.println("The parent path: " + file.getParent());
		System.out.println("If is directory: " + file.isDirectory());
		System.out.println("If is file: " + file.isFile());
		System.out.println("If the file exists: " + file.exists());
		
		/*	Create a file on disk if it does not exist	*/
		FileUtils.createFileIfNotExists(filePath);
		System.out.println("\nIf the file exists: " + file.exists());
		System.out.println("If is directory: " + file.isDirectory());
		System.out.println("If is file: " + file.isFile());
		
		/*	Delete the file on disk	 */
		System.out.println("\nDelete the file: " + file.delete());	
	}
	
	/**
	 * 	Test to get current project path
	 */
	private void testProjectPath() {
		
		String projectPath = System.getProperty("user.dir");

		System.out.println("Project Path: " + projectPath);
	}
}

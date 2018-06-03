package com.java.se.conclusion.iostream.bytes;

import com.java.se.conclusion.iostream.bytes.common.Address;
import com.java.se.conclusion.iostream.bytes.common.User;
import com.java.se.conclusion.iostream.bytes.stream.BufferedIOStream;
import com.java.se.conclusion.iostream.bytes.stream.FileIOStream;
import com.java.se.conclusion.iostream.bytes.stream.ObjectIOStream;
import com.java.se.conclusion.iostream.bytes.stream.PrintOutStream;
import com.java.se.conclusion.iostream.bytes.stream.SequenceInStream;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test byte stream
 * 
 * @author VinceYuan
 *
 */
public class TestByteStream {
	
	/*	Necessary instance variables	*/
	private String filePath_FileIOStream;
	private String filePath_FileIOStream_Copy;
	private String filePath_BufferedIOStream;
	private String filePath_BufferedIOStream_Copy;
	private String filePath_ObjectIOStream;
	private String filePath_SequenceInStream;
	private String filePath_PrintOutStream;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestByteStream testByteStream = new TestByteStream();
		testByteStream.testPreparation();
		System.out.println("Here tests File IO stream:");
		testByteStream.testFileOutputStream();
		testByteStream.testFileInputStream();
		testByteStream.testCopyWithFileIOStream();
		System.out.println("\nHere tests buffered IO stream:");
		testByteStream.testBufferedOutputStream();
		testByteStream.testBufferedInputStream();
		testByteStream.testCopyWithBufferedIOStream();
		System.out.println("\nHere tests object IO stream:");
		testByteStream.testObjectOutputStream();
		testByteStream.testObjectInputStream();
		System.out.println("\nHere tests sequence input stream:");
		testByteStream.testSequenceInputStream();
		System.out.println("\nHere tests print stream:");
		testByteStream.testPrintToFile();
		testByteStream.testPrintToLog();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		filePath_FileIOStream = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_IO_STREAM;
		filePath_FileIOStream_Copy = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_IO_STREAM_COPY;
		filePath_BufferedIOStream = Configuration.Conclusion.FILE_PATH_TO_TEST_BUFFERED_IO_STREAM;
		filePath_BufferedIOStream_Copy = Configuration.Conclusion.FILE_PATH_TO_TEST_BUFFERED_IO_STREAM_COPY;
		filePath_ObjectIOStream = Configuration.Conclusion.FILE_PATH_TO_TEST_OBJECT_IO_STREAM;
		filePath_SequenceInStream = Configuration.Conclusion.FILE_PATH_TO_TEST_SEQUENCE_IN_STREAM;
		filePath_PrintOutStream = Configuration.Conclusion.FILE_PATH_TO_TEST_PRINT_OUT_STREAM;
	}

	/*----------------------------	Test File IO Stream	 ---------------------------------*/
	/**
	 * 	Test write data to a file on disk with FileOutputStream
	 */
	private void testFileOutputStream() {
		
		/*	
		 * 	Specify the data and file path (or file URL)
		 * 	-- If the data that will be written to a file is English or Chinese:
		 *     -- can be written since "getByte()" does the encoding and notepad (, etc.) does the decoding
		 */
//		String data = "We are the champions. Today is the lucky day!! Ooh-ahh like!";
		String data = "大家好大家好，哇哈哈哈哈哈哈 \nHowdy Hello~~~\n";							
		String filePath = filePath_FileIOStream;
		
		/*	Write the data to the file on disk	*/
		FileIOStream.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test read a file from disk with FileInputStream
	 */
	private void testFileInputStream() {
		
		/*	
		 *	Specify the buffer size and file path (or file URL)
		 * 	-- If the data in the file is English: 
		 *     -- Can be read since String constructor does the encoding and decoding
		 *  -- If the data in the file is Chinese with UTF8 encoding:
		 *     -- Can be read since String constructor does the encoding and decoding using UTF-8 (specified by current platform Eclipse Neon)
		 *  -- If the data in the file is Chinese with Non-UTF8 encoding:
		 *     -- Cannot be read since String constructor does the encoding and decoding using UTF-8 (specified by current platform Eclipse Neon)
		 */
		int bufferSize = 128;
		String filePath = filePath_FileIOStream;
		
		/*	Read the file from disk	 */
		FileIOStream.readFromFile(bufferSize, filePath);
	}
	
	/**
	 * 	Test copy a file with FileInputStream & FileOutputStream
	 */
	private void testCopyWithFileIOStream() {
		
		/*	Specify the buffer size, original file path & the copy file path	*/
		int bufferSize = 128;
		String originalFilePath = filePath_FileIOStream;
		String copyFilePath = filePath_FileIOStream_Copy;
		
		/*	Copy the file	*/
		FileIOStream.copyFile(bufferSize, originalFilePath, copyFilePath);
	}
	
	/*----------------------------	Test Buffered IO Stream	 ---------------------------------*/
	/**
	 * 	Test write data to a file on disk with BufferedOutputStream
	 */
	private void testBufferedOutputStream() {
		
		/*	
		 * 	Specify the data and file path (or file URL)
		 * 	-- If the data that will be written to a file is English or Chinese:
		 *     -- Can be written since "getByte()" does the encoding and notepad (, etc.) does the decoding
		 */
//		String data = "We are the champions. Today is the lucky day!! Ooh-ahh like!";
		String data = "大家好大家好，哇哈哈哈哈哈哈 \nHowdy Hello~~~\n";	
		String filePath = filePath_BufferedIOStream;
		
		/*	Write the data to the file on disk	*/
		BufferedIOStream.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test read a file from disk with BufferedInputStream
	 */
	private void testBufferedInputStream() {
		
		/*	
		 *	Specify the buffer size and file path (or file URL)
		 * 	-- If the data in the file is English: 
		 *     -- Can be read since BufferedInputStream addresses the English character decoding when printing out to console
		 *  -- If the data in the file is Chinese with UTF8 encoding:
		 *     -- Cannot be read since BufferedInputStream does not address the Chinese character decoding when printing out to console
		 *  -- If the data in the file is Chinese with Non-UTF8 encoding:
		 *     -- Cannot be read since BufferedInputStream does not address the Chinese character decoding when printing out to console
		 */
		String filePath = filePath_BufferedIOStream;
		
		/*	Read the file from disk	 */
		BufferedIOStream.readFromFile(filePath);
	}
	
	/**
	 * 	Test copy a file with BufferedInputStream & BufferedOutputStream
	 */
	private void testCopyWithBufferedIOStream() {
		
		/*	Specify the buffer size, original file path & the copy file path	*/
		String originalFilePath = filePath_BufferedIOStream;
		String copyFilePath = filePath_BufferedIOStream_Copy;
		
		/*	Copy the file	*/
		BufferedIOStream.copyFile(originalFilePath, copyFilePath);
	}

	/*----------------------------	Test Object IO Stream	 ---------------------------------*/
	/**
	 * 	Test write an object out to a file on disk with ObjectOututStream
	 */
	private void testObjectOutputStream() {
		
		/*	Specify a JavaBean object & file path	*/
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("123");
		user.setGender("Male");
		user.setIncome(12000.0);
		user.setAddress(new Address("USA", "FL", "Portdoom Street, No.109"));
		String filePath = filePath_ObjectIOStream;
		
		/*	Write the object to a file on disk	*/
		ObjectIOStream.writeToFile(user, filePath);
	}
	
	/**
	 * 	Test read an object from a file on disk with ObjectInputStream
	 */
	private void testObjectInputStream() {
		
		/*	Specify the file path	*/
		String filePath = filePath_ObjectIOStream;
		
		/*	Read the object from a file on disk	 */
		ObjectIOStream.readFromFile(filePath);
	}
	
	/*----------------------------	Test Sequence Input Stream	 ---------------------------------*/
	/**
	 * 	Test concatenate files with SequenceInputStream
	 */
	private void testSequenceInputStream() {
		
		/*	Specify the buffer size, the original file paths & new file paths	*/
		int bufferSize = 128;
		String[] originalFilePaths = {filePath_BufferedIOStream, filePath_FileIOStream, filePath_ObjectIOStream};
		String newFilePath = filePath_SequenceInStream;
		
		/*	Do the file concatenation	*/
		SequenceInStream.concatenateFiles(bufferSize, originalFilePaths, newFilePath);
		BufferedIOStream.readFromFile(filePath_SequenceInStream);
	}
	
	/*----------------------------	Test Print Stream	 ---------------------------------*/
	/**
	 * 	Test print data to a file on disk with PrintStream
	 */
	private void testPrintToFile() {
		
		/*	Specify the data & file path	*/
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("123");
		user.setGender("Male");
		user.setIncome(12000.0);
		user.setAddress(new Address("USA", "FL", "Portdoom Street, No.109"));
		String filePath = filePath_PrintOutStream;
		
		/*	Print the data to a file	*/
		PrintOutStream.printToFile(user, filePath);
	}
	
	/**
	 * 	Test print exception information to a log file with PrintStream
	 */
	private void testPrintToLog() {
		
		/*	Specify the file path of log to store exception information	 */
		String logFilePath = filePath_PrintOutStream;
		
		/*	Print the exception information to the log file	 */
		PrintOutStream.printExceptionLog(logFilePath);
	}
}

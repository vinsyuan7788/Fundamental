package com.java.se.conclusion.iostream.character;

import com.java.se.conclusion.iostream.character.stream.BufferedReaderWriter;
import com.java.se.conclusion.iostream.character.stream.ByteStreamReaderWriter;
import com.java.se.conclusion.iostream.character.stream.FileReaderWriter;
import com.java.se.configuration.Configuration;

/**
 * 	This is a class to test character stream
 * 
 * @author VinceYuan
 *
 */
public class TestCharacterStream {

	/*	Necessary instance variables	*/
	private String filePath_FileReaderWriter;
	private String filePath_FileReaderWriter_Copy;
	private String filePath_BufferedReaderWriter;
	private String filePath_BufferedReaderWriter_Copy;
	private String filePath_ByteStreamReaderWriter;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestCharacterStream testCharacterStream = new TestCharacterStream();
		testCharacterStream.testPreparation();
		System.out.println("Here tests file reader and writer:");
		testCharacterStream.testFileReader();
		testCharacterStream.testFileWriter();
		testCharacterStream.testCopyWithFileReaderWriter();
		System.out.println("\nHere tests buffered reader and writer:");
		testCharacterStream.testBufferedReader();
		testCharacterStream.testBufferedWriter();
		testCharacterStream.testCopyWithBufferedReaderWriter();
		System.out.println("\nHere tests byte stream reader and writer:");
		testCharacterStream.testInputStreamReader_ReadFromFile();
		testCharacterStream.testInputStreamReader_ReadFromConsole();
		testCharacterStream.testOutputStreamWriter();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		filePath_FileReaderWriter = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_READER_WRITER;
		filePath_FileReaderWriter_Copy = Configuration.Conclusion.FILE_PATH_TO_TEST_FILE_READER_WRITER_COPY;
		filePath_BufferedReaderWriter = Configuration.Conclusion.FILE_PATH_TO_TEST_BUFFERED_READER_WRITER;
		filePath_BufferedReaderWriter_Copy = Configuration.Conclusion.FILE_PATH_TO_TEST_BUFFERED_READER_WRITER_COPY;
		filePath_ByteStreamReaderWriter = Configuration.Conclusion.FILE_PATH_TO_TEST_BYTE_STREAM_READER_WRITER;
	}
	
	/*----------------------------	Test File Reader and Writer	 ---------------------------------*/
	/**
	 * 	Test write data to a file on disk with FileWriter
	 */
	private void testFileWriter() {
		
		/*	
		 * 	Specify the data and file path (or file URL)
		 * 	-- If the data that will be written to a file is English or Chinese:
		 *     -- Can be written since FileWriter does the encoding (hence no need to use "getByte()") & notepad (, etc.) does the decoding
		 */
//		String data = "We are the champions. Today is the lucky day!! Ooh-ahh like!";
		String data = "大家好大家好，哇哈哈哈哈哈哈 \nHowdy Hello~~~\n";
		String filePath = filePath_FileReaderWriter;
		
		/*	Write the data to the file on disk	*/
		FileReaderWriter.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test read a file from disk with FileReader
	 */
	private void testFileReader() {
		
		/*	
		 *	Specify the buffer size and file path (or file URL)
		 * 	-- If the data in the file is English: 
		 *     -- Can be read since FileReader (adopting the rules of current platform Eclipse Neon, which is UTF-8) adopts the same encoding rule as notepad's decoding
		 *  -- If the data in the file is Chinese with UTF8 encoding:
		 *     -- Can be read since FileReader (adopting the rules of current platform Eclipse Neon, which is UTF-8) adopts the same encoding rule as notepad's decoding
		 *  -- If the data in the file is Chinese with Non-UTF8 encoding:
		 *     -- Cannot be read since FileReader (adopting the rules of current platform MyEclipse10, which is UTF-8) adopts the different encoding rule as notepad's decoding
		 */
		int bufferSize = 128;
		String filePath = filePath_FileReaderWriter; 
		
		/*	Read the file from disk	 */
		FileReaderWriter.readFromFile(bufferSize, filePath);
	}
	
	/**
	 * 	Test copy a file with FileReader & FileWriter
	 * 	-- Using FileReader and FileWriter to copy images will lose the data due to the difference of coding (encoding or decoding) rules between FileReader ( or FileWriter) and image software
	 *     -- Hence read or write data which does not involve character (e.g., image, audio, etc.) should be processed with byte stream
	 */
	private void testCopyWithFileReaderWriter() {
		
		/*	Specify the buffer size, original file path & the copy file path	*/
		int bufferSize = 128;
		String originalFilePath = filePath_FileReaderWriter;
		String copyFilePath = filePath_FileReaderWriter_Copy;
		
		/*	Copy the file	*/
		FileReaderWriter.copyFile(bufferSize, originalFilePath, copyFilePath);
	}
	
	/*------------------------	Test Buffered Reader and Writer	 -------------------------------*/
	/**
	 * 	Test write data to a file on disk with BufferedWriter
	 */
	private void testBufferedWriter() {
		
		/*	
		 * 	Specify the data and file path (or file URL)
		 * 	-- If the data that will be written to a file is English or Chinese:
		 *     -- Can be written since BufferedWriter does the encoding (hence no need to use "getByte()") and notepad (, etc.) does the decoding
		 */
//		String data = "We are the champions. Today is the lucky day!! Ooh-ahh like!";
		String data = "大家好大家好，哇哈哈哈哈哈哈 \nHowdy Hello~~~";
		String filePath = filePath_BufferedReaderWriter;
		
		/*	Write the data to the file on disk	*/
		BufferedReaderWriter.writeToFile(data, filePath);
	}
	
	/**
	 * 	Test read a file from disk with BufferedReader
	 */
	private void testBufferedReader() {
		
		/*	
		 *	Specify the buffer size and file path (or file URL)
		 * 	-- If the data in the file is English: 
		 *     -- Can be read since BufferedReader (adopting the rules of current platform Eclipse Neon, which is UTF-8) adopts the same encoding rule as notepad's decoding
		 *  -- If the data in the file is Chinese with UTF8 encoding:
		 *     -- Can be read since BufferedReader (adopting the rules of current platform Eclipse Neon, which is UTF-8) adopts the same encoding rule as notepad's decoding
		 *  -- If the data in the file is Chinese with Non-UTF8 encoding:
		 *     -- Can be read since BufferedReader (adopting the rules of current platform MyEclipse10, which is UTF-8) adopts the different encoding rule as notepad's decoding
		 */
		String filePath = filePath_BufferedReaderWriter;
 
		/*	Read the file from disk	 */
		BufferedReaderWriter.readFromFile(filePath);
	}
	
	/**
	 * 	Test copy a file with BufferedReader and BufferedWriter
	 * 	1. Using BufferedReader and BufferedWriter to copy images will lose the data due to the difference of coding (encoding or decoding) rules between BufferedReader (or BufferedWriter) and image software, which is same as using FileReader (or FileWriter)
	 *     -- Hence read or write data which does not involve character (e.g., image, audio, etc.) should be processed with byte stream
	 */
	private void testCopyWithBufferedReaderWriter() {
		
		/*	Specify the buffer size, original file path & the copy file path	*/
		String originalFilePath = filePath_BufferedReaderWriter;
		String copyFilePath = filePath_BufferedReaderWriter_Copy;
		
		/*	Copy the file	*/
		BufferedReaderWriter.copyFile(originalFilePath, copyFilePath);
	}
	
	/*------------------------	Test Byte Stream Reader and Writer	------------------------------*/
	/**
	 * 	Test OutputStreamWriter: byte output stream --> character output stream 
	 */
	private void testOutputStreamWriter() {
		
		/*	
		 * 	Specify the data, file path (or file URL) and charset
		 * 	-- If the data that will be written to a file is English or Chinese:
		 *     -- Can be written since OutputStreamWriter does the encoding (hence no need to use "getByte()") & notepad (, etc.) does the decoding
		 */
//		String data = "We are the champions. Today is the lucky day!! Ooh-ahh like!";
		String data = "大家好大家好，哇哈哈哈哈哈哈 \nHowdy Hello~~~\n";
		String filePath = filePath_ByteStreamReaderWriter;
		String charset = "UTF-8";
		
		/*	Write the data to the file on disk	*/
		ByteStreamReaderWriter.writeToFile(data, filePath, charset);
	}
	
	/**
	 * 	Test InputStreamReader: byte input stream --> character input stream 
	 */
	private void testInputStreamReader_ReadFromFile() {
		
		/*	
		 *	Specify the buffer size and file path (or file URL)
		 * 	-- If the data in the file is English: 
		 *     -- Can be read since InputStreamReader specifies the same encoding rule (UTF-8) as notepad's decoding
		 *  -- If the data in the file is Chinese with UTF8 encoding:
		 *     -- Can be read since InputStreamReader specifies the same encoding rule (UTF-8) as notepad's decoding
		 *  -- If the data in the file is Chinese with Non-UTF8 encoding:
		 *     -- Can be read since InputStreamReader specifies the same encoding rule (UTF-8) as notepad's decoding
		 */
		String filePath = filePath_ByteStreamReaderWriter;
		String charset = "UTF-8";
		
		/*	Read the file from disk	 */
		ByteStreamReaderWriter.readFromFile(filePath, charset);
	}
	
	/**
	 * 	Test InputStreamReader: byte input stream --> character input stream 
	 */
	private void testInputStreamReader_ReadFromConsole() {
		
		/*	Read & display whatever is input from console, input "exit" to exit the program	 */
		ByteStreamReaderWriter.readFromConsole();
	}
}

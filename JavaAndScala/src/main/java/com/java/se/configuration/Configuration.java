package com.java.se.configuration;

/**
 * 	This is a class that store the configuration for Java conclusion
 * 
 * @author vinsy
 *
 */
public class Configuration {

	/*	Necessary instance variables	*/
	private final static String FILE_PATH_PREFIX = System.getProperty("user.dir") + "/Test/";
	
	/*************************************	For Conclusion	****************************************/
	public static class Conclusion {
	
		/*	For design pattern	*/
		public final static String FILE_PATH_TO_TEST_DECORATOR = FILE_PATH_PREFIX + "JavaTest\\DesignPattern\\Decorator\\Hello.txt";
		public final static String FILE_PATH_TO_TEST_INHERITANCE = FILE_PATH_PREFIX + "JavaTest\\DesignPattern\\Inheritance\\Hello.txt";
		
		/*	For file	*/
		public final static String FILE_PATH_TO_TEST_SEPARATOR_1 = FILE_PATH_PREFIX + "JavaTest\\File\\TestFileSeparator";
		public final static String FILE_PATH_TO_TEST_SEPARATOR_2 = FILE_PATH_PREFIX + "JavaTest/File/TestFileSeparator";
		public final static String FILE_PATH_TO_TEST_FILE = FILE_PATH_PREFIX + "JavaTest\\File\\TestFile\\Hello.txt";
		
		/*	For IO Stream	*/
		public final static String FILE_PATH_TO_TEST_FILE_IO_STREAM = FILE_PATH_PREFIX + "JavaTest\\IOStream\\ByteStream\\FileIOStream\\Hello.txt";
		public final static String FILE_PATH_TO_TEST_FILE_IO_STREAM_COPY = FILE_PATH_PREFIX + "JavaTest_Copy\\IOStream\\ByteStream\\FileIOStream\\Hello_Copy.txt";
		public final static String FILE_PATH_TO_TEST_BUFFERED_IO_STREAM = FILE_PATH_PREFIX + "JavaTest\\IOStream\\ByteStream\\BufferedIOStream\\Hello.txt";
		public final static String FILE_PATH_TO_TEST_BUFFERED_IO_STREAM_COPY = FILE_PATH_PREFIX + "JavaTest_Copy\\IOStream\\ByteStream\\BufferedIOStream\\Hello_Copy.txt";
		public final static String FILE_PATH_TO_TEST_OBJECT_IO_STREAM = FILE_PATH_PREFIX + "JavaTest\\IOStream\\ByteStream\\ObjectIOStream\\User.txt";
		public final static String FILE_PATH_TO_TEST_SEQUENCE_IN_STREAM = FILE_PATH_PREFIX + "JavaTest\\IOStream\\ByteStream\\SequenceInStream\\Concat.txt";
		public final static String FILE_PATH_TO_TEST_PRINT_OUT_STREAM = FILE_PATH_PREFIX + "JavaTest\\IOStream\\ByteStream\\PrintOutStream\\Print.txt";
		
		public final static String FILE_PATH_TO_TEST_FILE_READER_WRITER = FILE_PATH_PREFIX + "JavaTest\\IOStream\\CharacterStream\\FileReaderWriter\\Hello.txt";
		public final static String FILE_PATH_TO_TEST_FILE_READER_WRITER_COPY = FILE_PATH_PREFIX + "JavaTest_Copy\\IOStream\\CharacterStream\\FileReaderWriter\\Hello_Copy.txt";
		public final static String FILE_PATH_TO_TEST_BUFFERED_READER_WRITER = FILE_PATH_PREFIX + "JavaTest\\IOStream\\CharacterStream\\BufferedReaderWriter\\Hello.txt";
		public final static String FILE_PATH_TO_TEST_BUFFERED_READER_WRITER_COPY = FILE_PATH_PREFIX + "JavaTest_Copy\\IOStream\\CharacterStream\\BufferedReaderWriter\\Hello_Copy.txt";
		public final static String FILE_PATH_TO_TEST_BYTE_STREAM_READER_WRITER = FILE_PATH_PREFIX + "JavaTest\\IOStream\\CharacterStream\\ByteStreamReaderWriter\\Hello.txt";
		
		/*	For property	*/
		public final static String FILE_PATH_TO_TEST_PROPERTIES_ENG = FILE_PATH_PREFIX + "JavaTest\\Properties\\test_eng.properties";
		public final static String FILE_PATH_TO_TEST_PROPERTIES_CHN = FILE_PATH_PREFIX + "JavaTest\\Properties\\test_chn.properties";
	}
}

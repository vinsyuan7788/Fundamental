package org.lang.scala.conclusion.fio.file.stream

/**
 * 	This is a stand-alone object to test IO stream
 * 	-- Byte stream: handle I/O of raw binary data (In actual implementation, char-type casting, String constructor and "getByte()" can be manually used to handle translation, which however is not favorable)
 *     -- InputStream and OutputStream (which are abstract classes) are the super classes of all byte I/O streams
 *     -- File IO: FileInputStream and FileOutputStream
 *     -- Buffered IO: BufferedInputStream and BufferedOutputStream
 *     -- Sequence input: SequenceInputStream
 *     -- Object IO: ObjectInputStream and ObjectOutputStream
 *     -- Print output: PrintStream
 *  -- Character stream: handle I/O of character data, automatically handling translation to and from the local character set (namely "character stream = byte stream + encoding (or decoding)")
 *     -- Reader and Writer (which are abstract classes) are the super classes of all character I/O streams
 *     -- File IO: FileReader and FileWriter
 *     -- Buffered IO: BufferedReader and BufferedWriter
 *     -- Byte stream IO: InputStreamReader and OutputStreamWriter 
 *        -- Since usually what stream is returned to use is not determined by us. This stream can convert the (returned) byte stream to character stream
 *        -- Able to specify the coding (encoding or decoding) rules (UTF-8, GBK, etc.)
 *        
 *  When to use byte or character stream?
 *  -- If the read (or write) data does not involve character (e.g., image, audio, etc.), use byte stream
 *  -- If the read (or write) data involves character (e.g., text, etc.), use character stream
 *     -- Although byte stream is adoptable, it is risky: if the read-in size does not meet some thresholds, it may mis-encode (or mis-decode) the characters
 * 
 * 	@author VinceYuan
 */
object TestIOStream {
  
}
package org.lang.scala.common.utils

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 * 	This is a stand-alone object to provide utility for serialization and deserialization
 * 
 * 	@author VinceYuan
 */
object SerDeUtils {
  
  /**
   * 	This is a method to convert an instance to byte array
   *  -- Instance ---> ObjectOutputStream ---> ByteArrayOutputStream ---> Byte Array
   */
  def toByteArray[T](instance: T): Array[Byte] = {
    
    /*	Create a ByteArrayOutputStream instance	 */
    val byteArrayOutputStream = new ByteArrayOutputStream()
    
    /*	Create a ObjectOutputStream instance whose downstream is ByteArrayOutputStream	*/
    val objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
    
    /*	Write an instance to the ObjectOutputStream	 */
    objectOutputStream.writeObject(instance)
    
    /*	Flush the ObjectOutputStream	*/
    objectOutputStream.flush()
    
    /*	Read the byte array from the ByteArrayOutputStream	*/
    val instanceBytes = byteArrayOutputStream.toByteArray()
    
    /*	Close both output streams	 */
    byteArrayOutputStream.close()
    objectOutputStream.close()
    
    /*	Return the byte array	 */
    instanceBytes
  }
  
  /**
   * 	This is a method to convert a byte array to an instance
   *  -- Byte Array ---> ByteArrayInputStream ---> ObjectInputStream ---> Instance
   */
  def toInstance[T](bytes: Array[Byte]): T = {
    
    /*	Create a ByteArrayInputStream instance that reads from a byte array	 */
    val byteArrayInputStream = new ByteArrayInputStream(bytes)
    
    /*	Create an ObjectInputStream instance whose downstream is ByteArrayInputStream	 */
    val objectInputStream = new ObjectInputStream(byteArrayInputStream)
    
    /*	Read the instance from ObjectInputStream	*/
    val instance = objectInputStream.readObject()
    
    /*	Close both input streams	*/
    byteArrayInputStream.close()
    objectInputStream.close()
    
    /*	Convert the instance to type T and return	 */
    instance.asInstanceOf[T]
  }
}
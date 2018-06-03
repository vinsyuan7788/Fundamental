package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.threadlocal.common

/**
 * 	This is a stand-alone object to manage connections for multiple threads
 * 
 * 	@author VinceYuan 
 */
object ConnectionManager {
  
  /*	Necessary instance variables for connection management	*/
  private val connections = new ThreadLocal[Connection]()
  
  /**
   * 	This is a method to get the connection for current thread
   */
  def getConnection(threadId: Long) = {
    
    /*	Get the connection corresponding to current thread	*/
    val connection = connections.get
    
    /*	If the connection is null, then save the connection and return	*/
    if (connection == null) {
      val newConnection = new Connection(threadId)
      connections.set(newConnection)
      newConnection
      
    /*	Else return the corresponding connection directly	 */
    } else {
      connection
    }
  }
  
  /**
   * 	This is a method to close connection for current thread
   */
  def closeConnection(threadId: Long) = {
    connections.remove()
  }
}
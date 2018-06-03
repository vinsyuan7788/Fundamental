package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contain exception utility methods
 * 
 * 	@author VinceYuan
 */
object ExceptionUtils {
  
  /**
   * 	Here are the methods to check the indices for sub array
   */
  def checkSubArrayIndices[T](arr: Array[T], startIdx: Int, endIdx: Int): Unit = {
    if (startIdx < 0) throw new Exception("Start index cannot be negative")
    if (endIdx > arr.length - 1) throw new Exception("End index cannot exceed (array length - 1)")
    if (startIdx > endIdx) throw new Exception("Start index cannot be greater than end index")
  }
  def checkSubArrayIndicesForSwap[T](arr: Array[T], startIdx: Int, endIdx: Int, index1: Int, index2: Int): Unit = {
    if (startIdx < 0) throw new Exception("Start index cannot be negative")
    if (endIdx > arr.length - 1) throw new Exception("End index cannot exceed (array length - 1)")
    if (startIdx > endIdx) throw new Exception("Start index cannot be greater than end index")
    if (index1 < startIdx || index2 < startIdx) throw new Exception("Indices for swap cannot be less than startIdx")
    if (index1 > endIdx || index2 > endIdx) throw new Exception("Indices for swap cannot be greater than endIdx")    
  }
  def checkSubArrayIndicesForInsert[T](arr: Array[T], startIdx: Int, endIdx: Int, selectedIdx: Int, insertNum: Int): Unit = {
    if (startIdx < 0) throw new Exception("Start index cannot be negative")
    if (endIdx > arr.length - 1) throw new Exception("End index cannot exceed (array length - 1)")
    if (startIdx > endIdx) throw new Exception("Start index cannot be greater than end index")
    if (selectedIdx < startIdx || selectedIdx > endIdx) throw new Exception("Index to insert must lie within startIdx and endIdx")
    if (insertNum < 0) throw new Exception("InsertNum cannot be negative")
  }
}
package org.lang.scala.common.utils

/**
 * 	This is a stand-alone object that contains array utility methods
 * 
 * 	@author VinceYuan
 */
object ArrayUtils {
  
  /**
   * 	This is a method to swap the position of two elements in the given array
   */
  def swap[T](arr: Array[T], index1: Int, index2: Int): Unit = {
    swap(arr, 0, arr.length - 1, index1, index2)
  }
  
  /**
   * 	This is a method to swap the position of two elements in the (sub-array of) given array
   */
  def swap[T](arr: Array[T], startIdx: Int, endIdx: Int, index1: Int, index2: Int): Unit = {
    
    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForSwap(arr, startIdx, endIdx, index1, index2)
    
    /*	Do the swap	 */
    val temp = arr(index1)
    arr(index1) = arr(index2)
    arr(index2) = temp
  }
  
  /**
   * 	This is a method to insert the selected element of given array to the left
   */
  def insertLeft[T](arr: Array[T], selectedIdx: Int, insertNum: Int): Unit = {
    insertLeft(arr, 0, arr.length - 1, selectedIdx, insertNum)
  }
  
  /**
   * 	This is a method to insert the selected element of (the sub-array of) given array to the left
   */
  def insertLeft[T](arr: Array[T], startIdx: Int, endIdx: Int, selectedIdx: Int, insertNum: Int): Unit = {

    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForInsert(arr, startIdx, endIdx, selectedIdx, insertNum)
    
    /*	Insert the selected element to the left	 */
    val arrLen = endIdx - startIdx + 1    
    val actualInsertNum = insertNum % arrLen
    val elemToInsert = arr(selectedIdx)
    if (actualInsertNum > 0) {
      for (offSetIdx <- 1 to actualInsertNum) {
        val idxThatNeedShiftRight = if (selectedIdx - offSetIdx >= startIdx) {
          selectedIdx - offSetIdx
        } else {
          selectedIdx - offSetIdx + arrLen
        }
        val IdxAfterShiftRight = if (idxThatNeedShiftRight + 1 <= endIdx) {
          idxThatNeedShiftRight + 1
        } else {
          idxThatNeedShiftRight + 1 - arrLen
        }
        arr(IdxAfterShiftRight) = arr(idxThatNeedShiftRight)
      }
      val idxToInsert = if (selectedIdx - actualInsertNum >= startIdx) {
        selectedIdx - actualInsertNum
      } else {
        selectedIdx - actualInsertNum + arrLen
      }
      arr(idxToInsert) = elemToInsert
    }
  }
  
  /**
   * 	This is a method to insert the selected element of given array to the right
   */
  def insertRight[T](arr: Array[T], selectedIdx: Int, insertNum: Int): Unit = {
    insertRight(arr, 0, arr.length - 1, selectedIdx, insertNum)
  }
  
  /**
   * 	This is a method to insert the selected element of (the sub-array of) given array to the right
   */
  def insertRight[T](arr: Array[T], startIdx: Int, endIdx: Int, selectedIdx: Int, insertNum: Int): Unit = {

    /*	Check sub-array indices	 */
    ExceptionUtils.checkSubArrayIndicesForInsert(arr, startIdx, endIdx, selectedIdx, insertNum)
    
    /*	Insert the selected element to the left	 */
    val arrLen = endIdx - startIdx + 1    
    val actualInsertNum = insertNum % arrLen
    val elemToInsert = arr(selectedIdx)
    if (actualInsertNum > 0) {
      for (offSetIdx <- 1 to actualInsertNum) {
        val idxThatNeedShiftLeft = if (selectedIdx + offSetIdx <= endIdx) {
          selectedIdx + offSetIdx
        } else {
          selectedIdx + offSetIdx - arrLen
        }
        val IdxAfterShiftLeft = if (idxThatNeedShiftLeft - 1 >= startIdx) {
          idxThatNeedShiftLeft - 1
        } else {
          idxThatNeedShiftLeft - 1 + arrLen
        }
        arr(IdxAfterShiftLeft) = arr(idxThatNeedShiftLeft)
      }
      val idxToInsert = if (selectedIdx + actualInsertNum <= endIdx) {
        selectedIdx + actualInsertNum
      } else {
        selectedIdx + actualInsertNum - arrLen
      }
      arr(idxToInsert) = elemToInsert
    }
  }
}
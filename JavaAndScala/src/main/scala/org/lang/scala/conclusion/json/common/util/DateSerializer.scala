package org.lang.scala.conclusion.json.common.util

import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer

/**
 * 	Here are stand-alone classes to implement custom JSON serializers for GSON
 *  -- When to customize JSON serializers:
 *     -- When GSON cannot recognize the data type and hence cannot do the JSON parsing for them
 *  -- To implement a custom JSON serializers for GSON:
 *     -- MUST extend the interface "JsonSerializer<T>" and override "serialize" method
 *     
 *  @author VinceYuan
 */
class DateSerializer extends JsonSerializer[Date] {
  
  /**
   * 	This is a method to serialize Scala cases/classes to JSON objects
   */
  override def serialize(date: Date, typeOfList: Type, context: JsonSerializationContext): JsonElement = {
    
    /*	Define a date format	*/
    val dateFormat = new SimpleDateFormat("MM/dd/yyyy")
    
    /*	 Use the date format to format the date to string	 */
    val dateString = dateFormat.format(date)
    
    /*	Return the data string as a JSON primitive	*/
    new JsonPrimitive(dateString)
  }
}
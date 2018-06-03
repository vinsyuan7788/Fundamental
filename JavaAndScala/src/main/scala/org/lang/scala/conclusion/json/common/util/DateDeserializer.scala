package org.lang.scala.conclusion.json.common.util

import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement

/**
 * 	Here are stand-alone classes to implement custom JSON deserializers for GSON
 *  -- When to customize JSON deserializer:
 *     -- When GSON cannot recognize the data type and hence cannot do the JSON parsing for them
 *  -- To implement a custom JSON deserializer for GSON:
 *     -- MUST extend the interface "JsonDeserializer<T>" and override "deserialize" method
 *     
 *  @author VinceYuan
 */
class DateDeserializer extends JsonDeserializer[Date] {
  
  /**
   * 	This is a method to deserialize JSON objects to Scala cases/classes
   */
  override def deserialize(jsonDate: JsonElement, typeOfjsonList: Type, context: JsonDeserializationContext): Date = {
     
    /*	Get the JSON element as JSON primitive	*/
    val jsonPrimitive = jsonDate.getAsJsonPrimitive()
    
    /*	
     * 	Get the date string from JSON primitive
     * 	-- Since date string is put in a JSON primitive
     *  -- This is a reverse process of serialization
     */
    val dateString = jsonPrimitive.getAsString()
    
    /*	Define a date format	*/
    val dateFormat = new SimpleDateFormat("MM/dd/yyyy")
    
    /*	Use the date format to parse the date string to a Date instance	 */
    dateFormat.parse(dateString)
  }
}
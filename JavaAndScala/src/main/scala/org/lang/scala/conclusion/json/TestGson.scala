package org.lang.scala.conclusion.json

import java.util.Date

import scala.collection.JavaConversions.seqAsJavaList

import org.lang.scala.conclusion.json.common.cases.Department
import org.lang.scala.conclusion.json.common.cases.Employee
import org.lang.scala.conclusion.json.common.cases.flink.ExecutionPlan
import org.lang.scala.conclusion.json.common.util.DateDeserializer
import org.lang.scala.conclusion.json.common.util.DateSerializer
import org.lang.scala.conclusion.json.common.util.JSONGenerator

import com.google.gson.GsonBuilder

/**
 * 	This is a stand-alone object to test GSON for conversion between Scala cases/classes and JSON objects
 * 
 * 	@author VinceYuan
 */
object TestGson {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    println("Here tests conversion from Scala cases/classes to JSON objects:")
    testScalaToJson()
    println("\nHere tests conversion from JSON objects to Scala cases/classes:")
    testJsonToScala()
    println("\nHere converts Flink execution plan:")
    testConvertFlinkExecutionPlan()
  }
  
  /**
   * 	This is a method to test conversion from Scala cases/classes to JSON objects
   */
  private def testScalaToJson(): Unit = {
    
    /*	Create a Scala instance	*/
    val scalaEmployee = Employee(1, "Lokesh", "Gupta", new Date(), List("Admin", "Manager"), 
      List(Department(100, "Big Data", List("123-456-7890", "987-654-3210"))))
    println(s"Scala case:\n${scalaEmployee}")
    
    /*	Create GSON instance	*/
    val gsonBuilder = new GsonBuilder()
    gsonBuilder.registerTypeAdapter(classOf[Date], new DateSerializer())
    gsonBuilder.registerTypeAdapter(classOf[Date], new DateDeserializer())
    val gson = gsonBuilder.create()
    
    /*	Convert from Scala instance to JSON instance	*/
    val jsonEmployee = gson.toJson(scalaEmployee)
    println(s"JSON object:\n${jsonEmployee}")
  }
  
  /**
   * 	This is a method to test conversion from JSON objects to Scala cases/classes
   */
  private def testJsonToScala(): Unit = {
    
    /*	Create a JSON instance	*/
    val jsonEmployee = "{'id':1,'firstName':'Lokesh','lastName':'Gupta','birthdate':'08/15/2013','roles':['Admin','Manager'],'departments':[{'id':100,'name':'Big Data','phoneNumbers':['123-456-7890','987-654-3210']}]}"
    println(s"JSON object:\n${jsonEmployee}")
    
    /*	Create GSON instance	*/
    val gsonBuilder = new GsonBuilder()
    gsonBuilder.registerTypeAdapter(classOf[Date], new DateSerializer())
    gsonBuilder.registerTypeAdapter(classOf[Date], new DateDeserializer())
    val gson = gsonBuilder.create()
    
    /*	Convert from JSON instance to Scala instance	*/
    val scalaEmployee = gson.fromJson(jsonEmployee, classOf[Employee])
    println(s"Scala case:\n${scalaEmployee}")
  }
  
  /**
   * 	This is a method to convert Flink execution plan from JSON to Scala
   */
  private def testConvertFlinkExecutionPlan(): Unit = {

    /*	Get a demonstrative Flink execution plan, which is in JSON format	 */
    val flinkExecutionPlan = JSONGenerator.getDemonstrativeFlinkExecutionPlan()
    
    /*	Create GSON instance	*/
    val gson = new GsonBuilder()
      .setPrettyPrinting()
      .create()
      
    /*	Convert the Flink execution plan to Scala instance	*/
    val scalaExecutionPlan = gson.fromJson(flinkExecutionPlan, classOf[ExecutionPlan])
    println(s"Scala execution plan:\n${scalaExecutionPlan}")
    
    /*	Convert the Flink execution back to JSON format with pretty printing	*/
    val jsonExecutionPlan = gson.toJson(scalaExecutionPlan)
    println(s"JSON execution plan:\n${jsonExecutionPlan}")
  }
}
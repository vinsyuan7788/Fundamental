package org.lang.scala.conclusion.json.common.util

/**
 * 	This is a stand-alone object that contain utility methods for JSON
 * 
 * 	@author VinceYuan
 */
object JSONGenerator {
  
  /**
   * 	This is a method to get a demonstrative FLink execution plan
   * 	-- In Flink (as of version 1.2), the execution plan is displayed only in JSON format
   */
  def getDemonstrativeFlinkExecutionPlan() = {
    """
      |{'nodes':[
        |{
          |'id':1,
          |'type':'Source: Socket Stream',
          |'pact':'Data Source',
          |'contents':'Source: Socket Stream',
          |'parallelism':1
        |},
        |{
          |'id':2,
          |'type':'Flat Map',
          |'pact':'Operator',
          |'contents':'Flat Map',
          |'parallelism':4,
          |'predecessors':[
            |{
              |'id':1,
              |'ship_strategy':'REBALANCE',
              |'side':'second'
            |}
          |]
        |},
        |{
          |'id':3,
          |'type':'Filter',
          |'pact':'Operator',
          |'contents':'Filter',
          |'parallelism':4,
          |'predecessors':[
            |{
              |'id':2,
              |'ship_strategy':'FORWARD',
              |'side':'second'
            |}
          |]
        |},
        |{
          |'id':4,
          |'type':'Map',
          |'pact':'Operator',
          |'contents':'Map',
          |'parallelism':4,
          |'predecessors':[
            |{
              |'id':3,
              |'ship_strategy':'FORWARD',
              |'side':'second'
            |},
            |{
              |'id':3,
              |'ship_strategy':'FORWARD',
              |'side':'second'
            |}
          |]
        |},
        |{
          |'id':6,
          |'type':'TriggerWindow(TumblingProcessingTimeWindows(5000), ReducingStateDescriptor{serializer=org.apache.flink.streaming.api.environment.graph.TestGetStreamGraph$$anon$2$$anon$1@3dfdd5ef, reduceFunction=org.apache.flink.streaming.api.functions.aggregation.SumAggregator@7113b13f}, ProcessingTimeTrigger(), WindowedStream.reduce(WindowedStream.java:276))',
          |'pact':'Operator',
          |'contents':'TriggerWindow(TumblingProcessingTimeWindows(5000), ReducingStateDescriptor{serializer=org.apache.flink.streaming.api.environment.graph.TestGetStreamGraph$$anon$2$$anon$1@3dfdd5ef, reduceFunction=org.apache.flink.streaming.api.functions.aggregation.SumAggregator@7113b13f}, ProcessingTimeTrigger(), WindowedStream.reduce(WindowedStream.java:276))',
          |'parallelism':4,
          |'predecessors':[
            |{
              |'id':4,
              |'ship_strategy':'HASH',
              |'side':'second'
            |}
          |]
        |},
        |{
          |'id':7,
          |'type':'Sink: Unnamed',
          |'pact':'Data Sink',
          |'contents':'Sink: Unnamed',
          |'parallelism':4,
          |'predecessors':[
            |{
              |'id':6,
              |'ship_strategy':'FORWARD',
              |'side':'second'
            |}
          |]
        |}]
      |}
    |""".stripMargin.trim()
  }
}
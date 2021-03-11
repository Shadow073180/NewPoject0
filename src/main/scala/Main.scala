package com.revature.davidmasterson

import ApiCaller._
import Mongo._
import Utilities._
import Spark._

import org.bson.BsonDocument
import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._

import scala.collection.JavaConverters._
import com.mongodb.client.result.InsertOneResult
import com.mongodb.DBObject
import scala.util.parsing.json.JSON
import play.api.libs.json.{Json,JsValue,JsArray}

 


object Main {

  def main(args: Array[String]): Unit={
    getToken()
    val cards = callApi()
    val cardsArray = parseCardsToArrayOfObjects(cards)
    val file = createCSVFromCardsArray(cardsArray)
    val docs = createDataFrameFromCSV(file)

    
    
  }  

}

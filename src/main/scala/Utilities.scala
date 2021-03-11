package com.revature.davidmasterson

import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters._

import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._


object Utilities {

  /** Configures the Api credentials using info.txt file */
  def setupApi(): ListBuffer[Tuple2[String,String]]={
    import scala.io.Source
    val apiInfo = new ListBuffer[Tuple2[String,String]]()

    for (line <- Source.fromFile("info.txt").getLines()) {
      val fields = line.split(" ")
      if (fields.length == 2) {
        val apiInfoLine = (fields(0),fields(1))
        apiInfo += apiInfoLine
      }
    }
    apiInfo
  }

  /** Connect to mongo db database */
  def getDatabaseConnection(): MongoClient ={
    val mongoClient: MongoClient = MongoClient()
    mongoClient
  }

}

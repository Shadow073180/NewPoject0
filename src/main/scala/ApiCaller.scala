package com.revature.davidmasterson

import Utilities._

import scala.collection.mutable.ListBuffer
import scala.sys.process._
import spray.json._
import DefaultJsonProtocol._

import scala.util.matching.Regex
import org.mongodb.scala.MongoDatabase
import org.mongodb.scala.bson.collection.mutable.Document
import org.mongodb.scala.MongoCollection





object ApiCaller {

  def getToken(): String = {
    val apiInfo: ListBuffer[Tuple2[String,String]] = setupApi()
    val tokenObjectString = s"curl -u ${apiInfo(0)._2}:${apiInfo(1)._2} -d grant_type=client_credentials https://us.battle.net/oauth/token".!!
    println(tokenObjectString)
    val tokenIdObject = tokenObjectString.split("(,|:)")
    println(tokenIdObject)
    val token = tokenIdObject(1).replace("\"","")
    println(token)
    token
  }

  def callApi(): JsValue={
    val token = getToken()
    val api = s"https://us.api.blizzard.com/hearthstone/cards?locale=en_US&access_token=$token"
    val r = scala.io.Source.fromURL(api)
    val rJson = r.mkString.parseJson
    // val pattern = new Regex("(\\[[\\w\\W\\s\\S]*\\])")
    // val cards = pattern.findFirstIn(rJson)
    // val cardsArray = cards.toArray
    // println(cards)
    rJson
  }


  
}

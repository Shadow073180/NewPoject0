package com.revature.davidmasterson

import Utilities._
import Card._

import scala.collection.mutable.ListBuffer
import scala.sys.process._
import scala.util.matching.Regex
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashTable



import play.api.libs.json.{Json,JsValue,JsArray}
import org.mongodb.scala.MongoDatabase
import org.mongodb.scala.bson.collection.mutable.Document
import org.mongodb.scala.MongoCollection
import org.mongodb.scala.model.Filters._
import org.mongodb.scala._
import org.mongodb.scala.model.Projections._
 import org.mongodb.scala.model.Sorts._
import java.io.PrintWriter






object ApiCaller {

  def getToken(): String = {
    val apiInfo: ListBuffer[Tuple2[String,String]] = setupApi()
    val tokenObjectString = s"curl -u ${apiInfo(0)._2}:${apiInfo(1)._2} -d grant_type=client_credentials https://us.battle.net/oauth/token".!!
    val tokenIdObject = tokenObjectString.split("(,|:)")
    val token = tokenIdObject(1).replace("\"","")
    
    token
  }

  def callApi(): JsValue={
    val token = getToken()
    val api = s"https://us.api.blizzard.com/hearthstone/cards?locale=en_US&access_token=$token"
    val r = scala.io.Source.fromURL(api).mkString
    val rJson: JsValue = Json.parse(r)
    rJson
  }


  def parseCardsToArrayOfObjects(rJson: JsValue): Array[Card]={
    val cardObjectsArray = new ArrayBuffer[Card]()
    val cards = (rJson \ "cards").get
    val cardsArray = cards.as[Array[JsValue]]
    for(card <- cardsArray){
      // val cardJson = Json.stringify(card)
      val name = (card \ "name").get.toString()
      val artistName = (card \ "artistName").get.toString()
      val cardSetId = (card \ "cardSetId").get.toString().toInt
      val text = (card \ "text").get.toString()
      val image = (card \ "image").get.toString()
      val cardId = (card \ "id").get.toString().toInt
      val flavorText = (card \ "flavorText").get.toString()
      var health = 0
      var manaCost = 0
      var attack = 0

      // try catch manaCost, attack, and health since not all cards contain these categories.
      try {
        manaCost = (card \ "manaCost").get.toString().toInt
       
      }
      catch {
        case e: NoSuchElementException => manaCost = 0
      }
      try {
        attack = (card \ "attack").get.toString().toInt
        attack.toInt
      }
      catch{
        case e: NoSuchElementException => attack = 0
      }
      try {
        health = (card \ "health").get.toString().toInt
      }
      catch {
        case e: NoSuchElementException => health = 0
      }

      val cardObject =  new Card(cardId,name,artistName,cardSetId,text,image,flavorText,health,manaCost,attack)
      cardObjectsArray += cardObject 
    }
    
      // cardObjectsArray += cardJson 
    
    cardObjectsArray.toArray
  }

  def createCSVFromCardsArray(cards: Array[Card]): String={
    val file = "./cards.csv"
    val writer = new PrintWriter(file)
    for (card <- cards){
      writer.print(s"${card.cardId},${card.name},${card.artistName},${card.cardSetId},${card.text},${card.image},${card.flavorText},${card.health},${card.manaCost},${card.attack}\n")
    }
    writer.close()
    file
  }


  
  
}

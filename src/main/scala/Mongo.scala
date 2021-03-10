package com.revature.davidmasterson

import Utilities._

import scala.util.matching.Regex
import org.mongodb.scala.MongoDatabase
import org.mongodb.scala.bson.collection.mutable.Document
import org.mongodb.scala.MongoCollection

object Mongo {

    val connection = getDatabaseConnection()
    val con = connection.getDatabase("cardsAPI").getCollection("cards")
    val documents = con.find()
    println(documents)

//     def addManyCardsToDB(cards: Array[String]): Unit={
    
    
   
    
//   }

//   def addOneCardToDB(card: Card): Card={

//   }

//   def deleteOneCardFromDB(card: Card): List[Card]={

//   }

//   def updateOneCard(card: Card): Card={

//   }

//   def findCardsByAttack(attack: Int): List[Card]={

//   }

//   def findCardsByArtist(artist: String): List[Card]={

//   }

//   def findCardsWhereNameLike(name: String): List[Card]={

//   }

//   def findCardsByManaCost(cost: Int): List[Card]={

//   }

//   def findCardsBySetId(setId: Int): List[Card]={

//   }

//   def findCardsByHealth(health: Int): List[Card]={

//   }


}
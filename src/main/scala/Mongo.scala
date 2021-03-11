package com.revature.davidmasterson

import Utilities._

import scala.util.matching.Regex
import org.mongodb.scala._
import org.mongodb.scala.model.Aggregates._
import org.mongodb.scala.model.Filters._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import org.mongodb.scala.model.Updates._
import org.mongodb.scala.model._

import scala.collection.JavaConverters._

object Mongo {

    val connection = getDatabaseConnection()
    val con = connection.getDatabase("cardsAPI").getCollection("cards")
    
    def addManyCardsToDB(cards: Array[Document]): Unit={
        con.insertMany(cards)
    
    }

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
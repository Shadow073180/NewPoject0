package com.revature.davidmasterson

import ApiCaller._
import Card._


import org.apache.spark.sql._
import org.apache.log4j._




object Spark {

    def createDataFrameFromCSV(file: String): Dataset[String]={

        Logger.getLogger("org").setLevel(Level.ERROR)
        
        val spark = SparkSession
            .builder
            .master("local[*]")
            .appName("CardBuilder")
            .getOrCreate()
        

        import spark.implicits._
        val columnNames = classOf[Card].getDeclaredFields.map(x => x.getName)
        val card = spark.read
            .option("header", false)
            .option("inferSchema" ,true)
            .csv(path = file)
            .toDF(columnNames:_*)
            .as[Card]

            println("Here is our schema")
            card.printSchema()
            card.show()

        val cardToDoc = card.map(card => s"{cardId:${card.cardId}," +
          s"name:${card.name}," +
          s"artistName:${card.artistName}," +
          s"cardSetId:${card.cardSetId}," +
          s"text:${card.text}," +
          s"image:${card.image}," +
          s"flavorText:${card.flavorText}," +
          s"health:${card.health}," +
          s"manaCost:${card.manaCost}," +
          s"attack:${card.attack}}")
            // card.filter(card("manaCost") > 0).show()
            // card.filter(card("name") contains("Illidan")).show()
        cardToDoc.show(false) 
        cardToDoc

        
    }
}


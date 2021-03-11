package com.revature.davidmasterson


object Card {
    
    case class Card(cardId: Int, name: String, artistName: String, cardSetId: Int, text: String, image: String, flavorText: String, health: Int, manaCost: Int, attack: Int)

}
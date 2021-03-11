# New Project 0

## Tech Stack
__________
* Scala 2.1.2.13
* Spark 3.1.1
* Play JSON 2.9.2
* Spark SQL 3.1.1
* Mongo DB Driver
* Blizzard Token API
* Blizzard HearthStone API
* SBT 1.4.7

____

Description: Application makes a call to the Blizzard Token Api then uses that token to make a call to the Hearthstone API in order to get all the current cards. Once the response is received it then creates an Array of card objects by parsing the response and setting variables:  

> cardId, name, artistName, cardSetId, text, 
image, flavorText, health, manaCost, and attack

Once the objects array has been created, a print writer writes each oject to a csv. 

The CSV is then read into a spark session to create a Cards DataFrame.


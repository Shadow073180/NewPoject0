package com.revature.davidmasterson

import ApiCaller._

object Main {

  def main(args: Array[String]): Unit={
    getToken()
    val cards = callApi()
    
  }

}

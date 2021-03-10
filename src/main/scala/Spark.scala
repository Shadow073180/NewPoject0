package com.revature.davidmasterson

import org.apache.spark.SparkContext


object Spark {

    def createSparkContext(master: String = "[*]", appName: String): SparkContext={
        val sc = new SparkContext(
            master = master,
            appName = appName
        )
        sc
        
    }

    def createRDDFromJson(json: JsValue): Unit={
        val sc = createSparkContext("[*]","CardCreator")
        val sc.
    }
}


name := "NewProject0"

version := "0.1"

scalaVersion := "2.12.13"

idePackagePrefix := Some("com.revature.davidmasterson")

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2" //json parsing
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.2.2" //mongo
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.1"// spark
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.1" // spark-sql

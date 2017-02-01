name := "dpp-bds-staging-json-transformation"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
//  "com.jcraft" % "jsch" % "0.1.48" ,
//  "com.typesafe" % "config" % "1.3.1",
//  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.64" ,
//  "org.slf4j" % "slf4j-simple" % "1.7.21",
//  "org.slf4j" % "slf4j-api" % "1.7.21" ,
//  "org.mockito" % "mockito-all" % "1.9.5",
 "org.scala-lang" % "scala-reflect" % scalaVersion.value,
 "org.scalatest" % "scalatest_2.10" % "3.0.1" % "test",
//  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-streaming" % "2.1.0",
  "org.apache.spark" %% "spark-streaming-kinesis-asl" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0"
)

/*
assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}*/

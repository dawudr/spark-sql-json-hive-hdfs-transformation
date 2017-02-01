package JsonInputStreamQuery

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.io.Source


object JsonInputStreamQuery {
  def main(args: Array[String]): Unit = {
    val ssc = new StreamingContext("local[10]", "test", Duration(3000))
    val sc = ssc.sparkContext
    val streamSqlContext = new StreamSQLContext(ssc, new SQLContext(sc))
    import streamSqlContext._
    // Here we read data line by line from a given file and then put it into a queue DStream.
    // You can replace any kind of String type DStream here including kafka DStream.
    val queue = new mutable.SynchronizedQueue[RDD[String]]()
    Source.fromFile("output/storelocation_offset_50_2017-01-25-16-15.json").getLines().foreach(msg =>
      queue.enqueue(sc.parallelize(List(msg))))
    val queueDStream = ssc.queueStream[String](queue)
    // We can infer the schema of json automatically by using inferJsonSchema
    val schema = streamSqlContext.inferJsonSchema("output/storelocation_offset_50_2017-01-25-16-15.json")
    streamSqlContext.registerDStreamAsTable(
      streamSqlContext.jsonDStream(queueDStream, schema), "jsonTable")
    sql("SELECT * FROM jsonTable").print()
    ssc.start()
    ssc.awaitTerminationOrTimeout(30 * 1000)
    ssc.stop()
  }
}
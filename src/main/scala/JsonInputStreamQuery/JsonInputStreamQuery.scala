package JsonInputStreamQuery

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
// For implicit conversions like converting RDDs to DataFrames

object JsonInputStreamQuery {
  def main(args: Array[String]): Unit = {
//    val ssc = new StreamingContext("local[10]", "test", Duration(3000))
//    val sc = ssc.sparkContext

    val conf = new SparkConf().setAppName("Spark SQL for Json").setMaster("local[*]")

    val sc = new SparkContext(conf)

    // For implicit conversions like converting RDDs to DataFrames
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    val df = spark.read.json("output/storelocation_offset_50_2017-01-25-16-15.json")
    df.show()




    // Here we read data line by line from a given file and then put it into a queue DStream.
    // You can replace any kind of String type DStream here including kafka DStream.
//    val queue = new mutable.SynchronizedQueue[RDD[String]]()
//    Source.fromFile("output/storelocation_offset_50_2017-01-25-16-15.json").getLines().foreach(msg =>
//      queue.enqueue(sc.parallelize(List(msg))))
//    val queueDStream = ssc.queueStream[String](queue)
    // We can infer the schema of json automatically by using inferJsonSchema
//    val schema = streamSqlContext.inferJsonSchema("output/storelocation_offset_50_2017-01-25-16-15.json")
//    streamSqlContext.registerDStreamAsTable(
//      streamSqlContext.jsonDStream(queueDStream, schema), "jsonTable")
//    sql("SELECT * FROM jsonTable").print()
//    ssc.start()
//    ssc.awaitTerminationOrTimeout(30 * 1000)
//    ssc.stop()
  }
}
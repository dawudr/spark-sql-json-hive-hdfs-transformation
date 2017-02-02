package StoresTransformer

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  * $ spark-submit  --class name.space.to.MyMainClass \
  *              --master local[2] \
  *             path/to/my-spark-jar.jar \
  *              argument1 \
  *              argument2 \
  *              argument3
  *
  * See http://spark.apache.org/docs/latest/submitting-applications.html
  * Quickstart https://spark.apache.org/docs/latest/quick-start.html
  */

object StoresTransformer {

  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
    println("Usage: [sparkmaster] [inputFile]")
    //exit(1)
    }

  val conf = new SparkConf ()
  .setAppName ("StoresTransformer")
  .setMaster ("local[*]")

  val sc = new SparkContext (conf)
    val sqlContext = new SQLContext(sc)

    val files: RDD[(String, String)] = sc.wholeTextFiles("output/storelocation_offset_50_2017-01-25-16-15.json")
    val jsonData: RDD[String] = files.map(x => x._2)
//    jsonData.foreach(x => {
//      println(x)
//    })

    val df = sqlContext.read.json(jsonData)
    val storesdf = df.select("results")
//    storesdf.printSchema()
    val storedf = storesdf.select()
    storedf.show()
    storedf.printSchema()





  }

}
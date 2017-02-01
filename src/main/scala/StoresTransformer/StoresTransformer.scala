package StoresTransformer


import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.DeserializationFeature

/**
  * Created by dawud.rahman on 31/01/2017.
  *
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

class StoresTransformer {

  def parse () {
    val master = args(0)
    val inputFile = args(1)
    val conf = new SparkConf()
    conf.setAppName("StoresTransformer")
    val sc = new SparkContext(master, "StoresTransformer", System.getenv("SPARK_HOME"))
    val sqlCtx = new SQLContext(sc)
    val input = sqlCtx.jsonFile(inputFile)
    input.printSchema()
    sc.stop()
  }

}


object StoresTransformer {
  def apply(args: Array[String]) {
//    if (args.length != 2) {
//      println("Usage: [sparkmaster] [inputFile]")
//      exit(1)
//    } else {
      new StoresTransformer()
//    }
  }
}
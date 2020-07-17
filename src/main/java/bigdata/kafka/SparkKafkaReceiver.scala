package bigdata.kafka

import kafka.serializer.StringDecoder
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkKafkaReceiver {

  private val topics = "ztp-test"
  private val HDFS_PATH = "hdfs://node01:9000/kafka-ck"
  private val numThreads = 1

  def main(args: Array[String]): Unit = {
    //当应用程序停止的时候,会将当前批次的数据处理完成后在停止
    System.setProperty("spark.streaming.stopGracefullyOnShutdown", "true")
    //1000*分区数*采样时间=拉取数据量
    System.setProperty("spark.streaming.kafka.maxRatePerPartition", "1000")

    val conf = new SparkConf().setMaster("local[2]").setAppName("receiver")

    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))
    //ssc.checkpoint(HDFS_PATH)

    val kafkaParams = Map(
      "metadata.broker.list" -> "cdh2:9092,cdh3:9092,cdh4:9092",
      "zookeeper.connect" -> "cdh1:2181",
      "group.id" -> "receiver"
    )

    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
    val kafkaDStream = KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](
      ssc, kafkaParams, topicMap, StorageLevel.MEMORY_AND_DISK_2)

    // word count
    kafkaDStream
      .map(_._2) // 1是分区号,2是具体kafka中数据
      //.flatMap(_.split(" "))
      //.map((_, 1))
      //.reduceByKey(_ + _)
      .count()
      .print() // 输出结果

    ssc.start()
    ssc.awaitTermination()
  }
}
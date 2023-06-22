package com

import org.apache.spark.sql.SparkSession

object readFile {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\winutils-master\\hadoop-3.0.0")
    val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .config("spark.sql.extensions", "org.apache.iceberg.spark.extensions.IcebergSparkSessionExtensions")
      .config("spark.sql.catalog.hadoop_prod", "org.apache.iceberg.spark.SparkCatalog")
      .config("spark.sql.catalog.hadoop_prod.type", "hadoop")
      .config("spark.sql.catalog.hadoop_prod.warehouse", "D:\\workspace\\MyTestSpark\\MyTestSpark\\wareHouse")
      .getOrCreate();
    val df = spark.read
      .format("iceberg")
      .load("hadoop_prod.spark_demo1.zipcodes")
    df.printSchema()
    df.show(10, false)
  }
}

// Databricks notebook source
case class Person(id: Int, name: String) {
    if (id == 5) {
        val sleepConfig = scalaj.http.Http("https://your-static-site/config.txt").asString.body.toInt
        println(s"Will wait for ${sleepConfig} second")
        Thread.sleep(sleepConfig * 1000)
    }
    Thread.sleep(4)
}

// COMMAND ----------

val df = sc.makeRDD(1 to 10000).map(x => Person(x, s"Person ${x}")).toDF
println(s"Dataframe length : ${df.count}")

// COMMAND ----------



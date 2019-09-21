import org.apache.spark.sql.types._
val schema = StructType(
    List(
        StructField("OrderLineID", IntegerType, true),
        StructField("OrderID", IntegerType, true),
        StructField("StockItemID", IntegerType, true),
        StructField("Description", StringType, true),
        StructField("PackageTypeID", IntegerType, true),
        StructField("Quantity", IntegerType, true),
        StructField("UnitPrice", DecimalType(18, 2), true),
        StructField("TaxRate", DecimalType(18, 3), true),
        StructField("PickedQuantity", IntegerType, true),
        StructField("PickingCompletedWhen", TimestampType, true),
        StructField("LastEditedBy", IntegerType, true)
    )
)

val csvFile = spark.read.option("header", "true").schema(schema).csv("./order-lines.csv")
csvFile.select(sum($"Quantity" * $"UnitPrice").as("CsvTotalSales")).show


val orcFile = spark.read.orc("./order-lines.orc")
orcFile.select(sum($"Quantity" * $"UnitPrice").as("OrcTotalSales")).show



import scala.io.Source
import java.io.PrintWriter

object SimpleETL {

  def main(args: Array[String]): Unit = {
    val inputFile = "input.csv"
    val outputFile = "output.csv"
    val transformedData = processData(inputFile)
    writeData(outputFile, transformedData)
    println("ETL process completed successfully.")
  }

  def processData(inputFile: String): List[List[String]] = {
    val source = Source.fromFile(inputFile)
    val data = source.getLines().map(_.split(",").toList).toList
    source.close()
    val transformedData = data.map(row => row.map(_.trim.toUpperCase))
    transformedData
  }

  def writeData(outputFile: String, data: List[List[String]]): Unit = {
    val pw = new PrintWriter(outputFile)
    data.foreach(row => pw.println(row.mkString(",")))
    pw.close()
  }

}

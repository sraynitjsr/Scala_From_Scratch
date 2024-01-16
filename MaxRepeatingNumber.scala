object MaxRepeatingNumber extends App {
  def findMaxRepeatingNumber(numbers: List[Int]): Option[Int] = {
    val countMap = scala.collection.mutable.HashMap[Int, Int]().withDefaultValue(0)
    for (num <- numbers) {
      countMap(num) += 1
    }
    val maxRepeatingNumber = countMap.maxBy(_._2)._1
    Some(maxRepeatingNumber)
  }
  val numbers = List(1, 2, 3, 4, 2, 2, 5, 6, 2, 7, 8, 2, 9, 10, 2)
  val result = findMaxRepeatingNumber(numbers)
  result match {
    case Some(maxRepeatingNumber) =>
      println(s"The maximum repeating number is => $maxRepeatingNumber")
    case None =>
      println("No repeating numbers found.")
  }
}

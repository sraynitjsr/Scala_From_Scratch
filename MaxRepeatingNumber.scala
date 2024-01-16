object MaxRepeatingNumber extends App {
    def findMaxRepeatingNumber(numbers: Array[Int]): Option[Int] = {
      val n = numbers.length
      for (i <- 0 until n) {
        numbers(numbers(i) % n) += n
      }  
      var maxIndex = 0
      for (i <- 1 until n) {
        if (numbers(i) > numbers(maxIndex)) {
          maxIndex = i
        }
      }
      for (i <- 0 until n) {
        numbers(i) %= n
      }
      if (numbers(maxIndex) > 1) {
        Some(maxIndex)
      } else {
        None
      }
    }
    val numbers = Array(1, 2, 3, 4, 2, 2, 5, 6, 2, 7, 8, 2, 9, 10, 2)
    val result = findMaxRepeatingNumber(numbers)
    result match {
      case Some(maxRepeatingNumber) =>
        println(s"The maximum repeating number is => $maxRepeatingNumber")
      case None =>
        println("No repeating numbers found.")
    }
}

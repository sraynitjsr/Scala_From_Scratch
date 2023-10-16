object ExceptionHandling {
  def main(args: Array[String]): Unit = {
    try {
      val numerator = 10
      val denominator = 0
      val result = divideNumbers(numerator, denominator)
      println(s"Result: $result")
    } catch {
      case ex: ArithmeticException =>
        println("Error: Division by zero is not allowed.")
      case ex: Exception =>
        println(s"An unexpected error occurred: ${ex.getMessage}")
    }
  }

  def divideNumbers(numerator: Int, denominator: Int): Int = {
    if (denominator == 0) {
      throw new ArithmeticException("Division by zero is not allowed.")
    }
    numerator / denominator
  }
}

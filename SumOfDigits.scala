object SumOfDigits {
  def main(args: Array[String]): Unit = {
    val number = 425
    val sum = findSumOfDigits(number)
    println(s"The sum of digits in $number is: $sum")
  }
  def findSumOfDigits(number: Int): Int = {
    def sumDigitsHelper(n: Int, acc: Int): Int = {
      if (n == 0) {
        acc
      } else {
        val digit = n % 10
        sumDigitsHelper(n / 10, acc + digit)
      }
    }
    sumDigitsHelper(number, 0)
  }
}

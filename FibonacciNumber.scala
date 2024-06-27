object FibonacciNumber {
  def fibonacci(n: Int): Int = {
    if (n <= 1) return n
    
    var a = 0
    var b = 1
    var i = 2
    while (i <= n) {
      val c = a + b
      a = b
      b = c
      i += 1
    }
    b
  }
  
  def main(args: Array[String]): Unit = {
    val n = 10
    println(s"Fibonacci number at position $n is: ${fibonacci(n)}")
  }
}

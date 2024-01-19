object BitwiseSwap {
  def swapBits(x: Int): Int = {
    var result = x
    for (i <- 0 until 32 by 2) {
      val iBit = (result >> i) & 1
      val i1Bit = (result >> (i + 1)) & 1
      result = result - (iBit << i) - (i1Bit << (i + 1)) +
        (iBit << (i + 1)) + (i1Bit << i)
    }
    result
  }
  def main(args: Array[String]): Unit = {
    val x = 43
    println("BitWise Swap of 43 => "+ swapBits(x))
    val y = 23
    println("BitWise Swap of 23 => "+ swapBits(y))
  }
}

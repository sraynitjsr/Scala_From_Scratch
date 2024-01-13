object MaxSumSubarray extends App {

  def maxSubArraySum(arr: Array[Int]): Int = {
    var currentSum = arr(0)
    var maxSum = arr(0)

    for (i <- 1 until arr.length) {
      currentSum = math.max(arr(i), currentSum + arr(i))
      maxSum = math.max(maxSum, currentSum)
    }

    maxSum
  }

  val array = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
  val result = maxSubArraySum(array)

  println(s"The maximum sum subarray is: $result")
}

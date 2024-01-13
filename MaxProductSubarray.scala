object MaxProductSubarray extends App {

  def maxProductSubarray(nums: Array[Int]): Int = {
    var maxProduct = nums(0)
    var minProduct = nums(0)
    var result = nums(0)

    for (i <- 1 until nums.length) {
      if (nums(i) < 0) {
        val temp = maxProduct
        maxProduct = minProduct
        minProduct = temp
      }

      maxProduct = math.max(nums(i), maxProduct * nums(i))
      minProduct = math.min(nums(i), minProduct * nums(i))

      result = math.max(result, maxProduct)
    }

    result
  }

  val array = Array(2, 3, -2, 4, -1)
  val result = maxProductSubarray(array)

  println(s"The maximum product subarray is: $result")
}

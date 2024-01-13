object FindingDuplicates extends App {
  def findDuplicates[T](list: List[T]): List[T] = {
    def findDuplicatesHelper(remaining: List[T], seen: Set[T], duplicates: List[T]): List[T] = {
      remaining match {
        case Nil => duplicates
        case head :: tail =>
          if (seen.contains(head)) {
            findDuplicatesHelper(tail, seen, duplicates :+ head)
          } else {
            findDuplicatesHelper(tail, seen + head, duplicates)
          }
      }
    }
    findDuplicatesHelper(list, Set(), List())
  }
  val inputList = List(1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 9, 4, 10, 10)
  val duplicates = findDuplicates(inputList)
  println(s"Input List: $inputList")
  println(s"Duplicates: $duplicates")
}

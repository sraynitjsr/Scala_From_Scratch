object NameAbbreviation {
  def main(args: Array[String]): Unit = {
    println("Enter your full name:")
    val fullName = scala.io.StdIn.readLine()

    val parts = fullName.split(" ")
    val firstName = parts.headOption.getOrElse("")
    val middleInitial = if (parts.length > 2) parts(1).charAt(0) + ". " else ""
    val lastName = parts.lastOption.map(_.capitalize).getOrElse("")

    val abbreviatedName = s"${firstName.charAt(0)}. $middleInitial$lastName"

    println("Abbreviated Name: " + abbreviatedName)
  }
}

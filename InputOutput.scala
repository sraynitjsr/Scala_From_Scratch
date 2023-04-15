import scala.io.StdIn.readLine

@main def helloInteractive() =
  println("Enter Your Name")
  val name = readLine()

  println("Hello " + name + "!")
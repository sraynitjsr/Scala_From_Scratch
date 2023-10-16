import java.net._
import java.io._

object EchoClient {
  def main(args: Array[String]): Unit = {
    val serverAddress = "localhost"
    val serverPort = 9999

    val socket = new Socket(serverAddress, serverPort)
    val out = new PrintWriter(socket.getOutputStream, true)
    val in = new BufferedReader(new InputStreamReader(socket.getInputStream))

    val message = "Hello, Server!"
    out.println(message)
    println("Sent: " + message)

    val response = in.readLine()
    println("Received: " + response)

    socket.close()
  }
}

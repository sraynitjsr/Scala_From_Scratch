import java.net._
import java.io._

object EchoServer {
  def main(args: Array[String]): Unit = {
    val serverSocket = new ServerSocket(9999)
    println("Server is listening on port 9999...")

    while (true) {
      val clientSocket = serverSocket.accept()
      println("Client connected: " + clientSocket.getInetAddress.getHostAddress)

      val in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream))
      val out = new PrintWriter(clientSocket.getOutputStream, true)

      var message = in.readLine()
      while (message != null) {
        println("Received: " + message)
        out.println("Server: " + message)
        message = in.readLine()
      }

      clientSocket.close()
      println("Client disconnected.")
    }

    serverSocket.close()
  }
}

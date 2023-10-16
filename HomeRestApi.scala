import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

object HomeApi {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("HomeApi")
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    val homeRoute: Route = path("home") {
      get {
        complete("Hello World, Akka This Side, LOL!!")
      }
    }

    val bindingFuture = Http().bindAndHandle(homeRoute, "localhost", 8080)

    println(s"Server online at http://localhost:8080")

    sys.addShutdownHook {
      import system.dispatcher
      bindingFuture
        .flatMap(_.unbind())
        .onComplete(_ => system.terminate())
    }
  }
}

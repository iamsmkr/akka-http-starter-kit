package com.codingkapoor.helloworld.http

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.util.Timeout
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._

private[helloworld] trait Routes extends JsonSupport {

  implicit lazy val timeout: Timeout = Timeout(5.minute)

  implicit def materializer: ActorMaterializer

  lazy val routes: Route = pathSingleSlash {
    get {
      complete {
        Future.unit.map(_ => Thread.sleep(180000)).map(_ => StatusCodes.OK -> "Hello World!")
      }
    }
  }
}

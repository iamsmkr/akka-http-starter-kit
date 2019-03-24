package com.codingkapoor.helloworld.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.ExceptionHandler
import akka.http.scaladsl.server.Directives._

private[helloworld] trait Server extends Routes {

  implicit def system: ActorSystem

  def serverConf: ServerConf

  implicit val _exceptionHandler = ExceptionHandler {
    case e: Exception =>
      e.printStackTrace()
      complete(StatusCodes.InternalServerError, e.getMessage)
  }

  def startServer() = {
    Http().bindAndHandle(routes, serverConf.interface, serverConf.port)
  }
}

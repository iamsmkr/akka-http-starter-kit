package com.codingkapoor.helloworld.core

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.codingkapoor.helloworld.http.{Server, ServerConf}

import scala.concurrent.{Await, ExecutionContext}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object HelloWorld extends App with Server {

  val appConf = RuntimeEnvironment.appConf
  val serverConf = ServerConf(appConf)

  // Always make sure to pass appConf to the actor system while creating an actor system instance
  // otherwise it will be created with default configurations
  implicit val system = ActorSystem("helloworld", appConf)

  implicit lazy val materializer = ActorMaterializer()
  implicit lazy val context: ExecutionContext = system.dispatcher

  startServer().onComplete {
    case Success(_) =>
      println(s"\nHelloWorld API server is online at http://${serverConf.interface}:${serverConf.port}/")

    case Failure(e) =>
      Console.err.println(s"Failed to start HelloWorld API server!")
      e.printStackTrace()
      system.terminate()
  }

  Await.result(system.whenTerminated, Duration.Inf)
}

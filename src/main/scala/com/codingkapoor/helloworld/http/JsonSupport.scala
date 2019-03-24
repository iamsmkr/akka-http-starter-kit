package com.codingkapoor.helloworld.http

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol._

private[helloworld] trait JsonSupport extends SprayJsonSupport {
  implicit val responseJsonFormat = jsonFormat1(Response)
}

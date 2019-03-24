package com.codingkapoor.helloworld.http

import com.typesafe.config.Config

private[helloworld] case class ServerConf(interface: String, port: Int)

private[helloworld] object ServerConf {
  def apply(appConf: Config) = {
    val serverConf = appConf.getConfig("helloworld").getConfig("http")

    val serverInterface = serverConf.getString("interface")
    val serverPort = serverConf.getInt("port")

    new ServerConf(serverInterface, serverPort)
  }
}

package com.codingkapoor.helloworld.core

import java.io.File
import com.typesafe.config.{Config, ConfigFactory}
import scala.sys.SystemProperties

object RuntimeEnvironment {
  private lazy val sp = new SystemProperties()

  def getConfDir: String = {
    val vmParam = "helloworld.conf"
    val r = sp(vmParam)

    if (r != null && !r.trim.isEmpty) r.trim else throw new RuntimeException(s"-D$vmParam was not provided.")
  }

  def getHomeDir: String = {
    val vmParam = "helloworld.home"
    val r = sp(vmParam)

    if (r != null && !r.trim.isEmpty) r.trim else throw new RuntimeException(s"-D$vmParam was not provided.")
  }

  private lazy val appConfFile = getConfDir + File.separator + "application.conf"
  lazy val appConf: Config = ConfigFactory.parseFile(new File(appConfFile))
}


name := "akka-http-starter-kit"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.8"

lazy val slf4jVersion = "1.7.25"
lazy val typeSafeConfigVersion = "1.3.1"

lazy val akkaHttpVersion = "10.1.5"
lazy val akkaVersion    = "2.5.18"

libraryDependencies ++= Seq(
  // -- Slf4j --
  "org.slf4j" % "slf4j-simple" % slf4jVersion,
  // -- Config --
  "com.typesafe" % "config" % typeSafeConfigVersion,
  // -- Akka Http --
  "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream"          % akkaVersion
)

enablePlugins(JavaAppPackaging)

val ScalatraVersion = "2.6.2"

organization := "com.avrisaac555"

name := "Hack ACM"

version := "0.1.3.3.7"

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
    "org.json4s" %% "json4s-jackson" % "3.5.2",
    "org.scalatra" %% "scalatra" % ScalatraVersion,
    "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
    "org.scalatra" %% "scalatra-atmosphere" % "2.6.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
    "org.eclipse.jetty" % "jetty-plus" % "9.4.6.v20170531" % "container;provided",
    "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
    "org.eclipse.jetty.websocket" % "websocket-server" % "9.4.6.v20170531" % "container;provided",
    "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
    "org.scalatra" %% "scalatra-scalate" % ScalatraVersion
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)

javaOptions ++= Seq(
    "-Xdebug",
    "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
)
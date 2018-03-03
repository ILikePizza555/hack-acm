package com.avrisaac555.hackacm

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

/**
  * The front page of the app. In charge of listing games.
  * @param game Game server
  */
class LoginServlet(val game: GameServlet) extends ScalatraServlet with ScalateSupport {
    get("/") {
        contentType = "text/html"
        jade("/index", "layout" -> "WEB-INF/layout/default.jade", "games" -> game.getGames)
    }
}

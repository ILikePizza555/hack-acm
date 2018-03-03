package com.avrisaac55.hackacm

import org.scalatra._

/**
  * In charge of displaying the correct game to players, and updating the game state.
  */
class GameServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }
}

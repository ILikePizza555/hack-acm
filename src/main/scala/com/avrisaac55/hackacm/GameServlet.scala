package com.avrisaac55.hackacm

import org.scalatra._

class GameServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}

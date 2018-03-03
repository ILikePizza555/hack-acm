package com.avrisaac55.hackacm

import org.scalatra.test.scalatest._

class GameServletTests extends ScalatraFunSuite {

  addServlet(classOf[GameServlet], "/*")

  test("GET / on GameServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}

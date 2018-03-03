package com.avrisaac555.hackacm

import java.time.{LocalDateTime, ZoneOffset}

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

import scala.collection.mutable

/**
  * In charge of creating games, displaying it to players, and updating the game state
  */
class GameServlet(private val games: mutable.MutableList[Game] = mutable.MutableList(),
                  private val players: mutable.MutableList[Player] = mutable.MutableList()) extends ScalatraServlet
                                                                                            with ScalateSupport {
    def getGames: List[Game] = games.toList
    def generateId: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)

    def getGameById(id: Long): Option[Game] = games.find(g => g.id == id)

    /**
      * Creates a new game and adds it to the games list
      */
    post("/") {
        val p = Player(generateId, params.getOrElse("playerName", halt(400, "playerName must exist.")))
        players += p

        val g = Game(generateId, params.getOrElse("gameName", halt(400, "gameName must exist.")), LocalDateTime.now())
        games += g

        redirect("/game/" + g.id)
    }

    get("/:id") {
        val g = getGameById(params("id").toLong).getOrElse(halt(404, "Specified game not found."))

        jade("/game", "layout" -> "WEB-INF/layout/default.jade", "game" -> g)
    }

    get("/:id/join") {
        
    }
}

package com.avrisaac555.hackacm

import java.time.{LocalDateTime, ZoneOffset}

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

import scala.collection.mutable

/**
  * In charge of creating games, displaying it to players, and updating the game state
  */
class GameServlet(private val gameMap: mutable.HashMap[Long, Game] = mutable.HashMap()) extends ScalatraServlet with ScalateSupport {
    def getGames: List[Game] = gameMap.values.toList
    def generateId: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)

    def getGameById(id: Long): Option[Game] = gameMap.get(id)

    /**
      * Creates a new game, adds it to the games list, and redirects the player
      */
    post("/") {
        val p = Player(generateId, params.getOrElse("playerName", halt(400, "playerName must exist.")))

        val g = Game(generateId,
                     params.getOrElse("gameName", halt(400, "gameName must exist.")),
                     LocalDateTime.now(),
                     p :: Nil)
        gameMap += g.id -> g

        redirect("/game/" + g.id)
    }

    /**
      * Gets a game
      */
    get("/:id") {
        val g = getGameById(params("id").toLong).getOrElse(halt(404, "Specified game not found."))

        contentType = "text/html"
        jade("/game",
             "layout" -> "WEB-INF/layout/default.jade",
             "game" -> g,
             "header" -> <span>{g.toString}</span>)
    }

    /**
      * Joins a player to a game
      */
    get("/:id/join") {
        val g = getGameById(params("id").toLong).getOrElse(halt(404, "Specified game not found."))
        val p = Player(generateId, params.getOrElse("playerName", halt(400, "playerName must exist.")))

        if(g.players.lengthCompare(4) >= 0) halt(400, "Specified game is full.")

        gameMap(g.id) = g.addPlayer(p)
        
        redirect("/" + g.id)
    }
}

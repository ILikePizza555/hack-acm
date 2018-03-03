package com.avrisaac555.hackacm

import java.time.LocalDateTime

case class Player(id: Long, name: String)

case class Game(id: Long, name: String, beginTime: LocalDateTime, players: List[Player]) {
    def addPlayer(player: Player) = Game(id, name, beginTime, player :: players)
}

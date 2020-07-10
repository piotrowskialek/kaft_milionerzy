package com.kaft.milionerzy.domain.players

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : MongoRepository<Player, String> {
    fun getPlayersByIsPlayingIsTrue(): List<Player>
}
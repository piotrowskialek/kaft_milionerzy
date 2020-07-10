package com.kaft.milionerzy.domain.games

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository : MongoRepository<Game, String> {
    fun findByGameStatus(gameStatus: GameStatus): List<Game>
}
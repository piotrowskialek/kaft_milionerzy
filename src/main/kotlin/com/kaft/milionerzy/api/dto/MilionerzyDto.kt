package com.kaft.milionerzy.api.dto

import com.kaft.milionerzy.domain.games.GameStatus
import com.kaft.milionerzy.domain.questions.Question
import com.kaft.milionerzy.domain.players.Player
import java.util.*

data class PlayerDto(val name: String) {
    fun createEntity(isAdmin: Boolean): Player = Player(name, isAdmin)
}

data class PlayerCreatedResponse(val playerName: String, val gameId: UUID, val gameStatus: GameStatus, val isAdmin: Boolean)

data class InitGameResponse(val questions: List<Question>)
package com.kaft.milionerzy.api.dto

import com.kaft.milionerzy.domain.games.GameStatus
import com.kaft.milionerzy.domain.players.Player
import java.util.*

data class PlayerDto(val name: String) {
    fun createEntity(): Player = Player(name)
}

data class PlayerCreatedResponse(val gameId: UUID, val gameStatus: GameStatus, val isAdmin: Boolean)
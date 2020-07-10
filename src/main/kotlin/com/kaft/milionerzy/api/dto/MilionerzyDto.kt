package com.kaft.milionerzy.api.dto

import com.kaft.milionerzy.domain.games.GameStatus
import com.kaft.milionerzy.domain.questions.Question
import com.kaft.milionerzy.domain.players.Player
import com.kaft.milionerzy.domain.questions.RightAnswerEnum
import java.util.*

data class PlayerDto(val name: String) {
    fun createEntity(isAdmin: Boolean): Player = Player(name, isAdmin)
}

data class PlayerCreatedResponse(val playerName: String, val gameId: UUID, val gameStatus: GameStatus, val isAdmin: Boolean)

data class InitGameResponse(val questions: List<QuestionDto>)


data class QuestionDto (
        val content: String,
        val a: String,
        val b: String,
        val c: String,
        val d: String,
        val rightAnswer: RightAnswerEnum,
        val prize: Int,
        val isGuaranteed: Boolean
)

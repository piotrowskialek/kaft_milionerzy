package com.kaft.milionerzy.domain.games

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Game (
        @Id val id: UUID,
        val gameStatus: GameStatus
)

enum class GameStatus {
    CREATED,
    ACTIVE,
    FINISHED
}
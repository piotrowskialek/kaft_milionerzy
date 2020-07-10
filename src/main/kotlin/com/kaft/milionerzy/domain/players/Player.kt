package com.kaft.milionerzy.domain.players

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Player(
        @Id val name: String,
        val levelAchieved: Level = Level.FIRST,
        val isPlaying: Boolean = false
)

enum class Level(val amount: Int, val isGuaranteed: Boolean) {
    FIRST(0, true),
    SECOND(500, false),
    THIRD(1000, true),
    FOURTH(2000, false),
    FIFTH(5000, false),
    SIXTH(10_000, false),
    SEVENTH(20_000, false),
    EIGHTH(40_000, true),
    NINTH(75_000, false),
    TENTH(125_000, false),
    ELEVENTH(250_000, false),
    TWELFTH(500_000, false),
    THIRTEENTH(1_000_000, false)
}
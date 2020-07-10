package com.kaft.milionerzy.api.dto

import com.kaft.milionerzy.domain.players.Player

data class PlayerDto(val name: String) {
    fun createEntity(): Player = Player(name)
}
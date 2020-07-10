package com.kaft.milionerzy.api

import com.kaft.milionerzy.api.dto.PlayerDto
import com.kaft.milionerzy.domain.players.PlayerRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/players")
class PlayerEndpoint(val playerRepository: PlayerRepository) {

    @PostMapping
    fun createPlayer(playerDto: PlayerDto) = playerRepository.insert(playerDto.createEntity())
}
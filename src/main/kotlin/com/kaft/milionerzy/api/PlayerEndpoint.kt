package com.kaft.milionerzy.api

import com.kaft.milionerzy.api.dto.PlayerCreatedResponse
import com.kaft.milionerzy.api.dto.PlayerDto
import com.kaft.milionerzy.domain.games.Game
import com.kaft.milionerzy.domain.games.GameRepository
import com.kaft.milionerzy.domain.games.GameStatus
import com.kaft.milionerzy.domain.players.Player
import com.kaft.milionerzy.domain.players.PlayerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.util.*

@RestController
@RequestMapping("/players")
class PlayerEndpoint(val playerRepository: PlayerRepository, val gameRepository: GameRepository) {

    @PostMapping
    fun createPlayer(@RequestBody playerDto: PlayerDto): PlayerCreatedResponse {
        playerRepository.findById(playerDto.name).ifPresent {
            throw PlayerExistsException("Name is already taken!")
        }
        gameRepository.findByGameStatus(GameStatus.ACTIVE).firstOrNull()?.let {
            throw GameIsActiveException("Game is already in ACTIVE state!")
        }
        val player = playerRepository.insert(playerDto.createEntity())
        return gameRepository.findByGameStatus(GameStatus.CREATED).firstOrNull()?.let { PlayerCreatedResponse(player.name, it.id, GameStatus.CREATED, false) }
                ?: gameRepository.insert(Game(UUID.randomUUID(), GameStatus.CREATED)).let { PlayerCreatedResponse(player.name, it.id, GameStatus.CREATED, true) }
    }

    @GetMapping
    fun getActivePlayers(): List<Player> = playerRepository.getPlayersByPlayingIsTrue()
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
data class PlayerExistsException(val msg: String): RuntimeException(msg)

@ResponseStatus(HttpStatus.FORBIDDEN)
data class GameIsActiveException(val msg: String): RuntimeException(msg)
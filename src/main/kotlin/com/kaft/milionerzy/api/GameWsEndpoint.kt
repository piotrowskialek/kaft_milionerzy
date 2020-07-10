package com.kaft.milionerzy.api

import com.kaft.milionerzy.api.dto.InitGameResponse
import com.kaft.milionerzy.api.dto.QuestionDto
import com.kaft.milionerzy.domain.players.Level
import com.kaft.milionerzy.domain.questions.Question
import com.kaft.milionerzy.domain.questions.QuestionRandomizer
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class GameWsEndpoint(val questionRandomizer: QuestionRandomizer) {

    @MessageMapping("/topic/initGame")
    @SendTo("/topic/initGame")
    fun initGame(message: Any): InitGameResponse = InitGameResponse(questionRandomizer.getRandomQuestions().toDto())
}

fun List<Question>.toDto():List<QuestionDto> = this.zip(Level.values().takeLast(12)).map {
    QuestionDto(it.first.content, it.first.a, it.first.b, it.first.c, it.first.d, it.first.rightAnswer, it.second.amount, it.second.isGuaranteed)
}
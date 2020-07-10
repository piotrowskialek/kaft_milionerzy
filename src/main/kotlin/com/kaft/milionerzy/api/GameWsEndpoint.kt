package com.kaft.milionerzy.api

import com.kaft.milionerzy.api.dto.InitGameResponse
import com.kaft.milionerzy.domain.questions.QuestionRandomizer
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class GameWsEndpoint(val questionRandomizer: QuestionRandomizer) {

    @MessageMapping("/topic/initGame")
    @SendTo("/topic/initGame")
    fun initGame(message: Any): InitGameResponse = InitGameResponse(questionRandomizer.getRandomQuestions())
}
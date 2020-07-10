package com.kaft.milionerzy.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper
import com.kaft.milionerzy.api.GameWsEndpoint
import com.kaft.milionerzy.api.dto.InitGameResponse
import com.kaft.milionerzy.api.toDto
import com.kaft.milionerzy.domain.questions.QuestionRandomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler


@Configuration
@EnableWebSocket
 class WebSocketConfig(val myHandler: WebSocketHandler) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(myHandler, "/initGame");
    }

}

class MyHandler(val objectMapper: ObjectMapper, val questionRandomizer: QuestionRandomizer) : TextWebSocketHandler() {
    public override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        session.sendMessage(TextMessage(objectMapper.writeValueAsBytes(InitGameResponse(questionRandomizer.getRandomQuestions().toDto()))))
    }
}

@Configuration
class WsConfig {
    @Bean
    fun myHandler(questionRandomizer: QuestionRandomizer, objectMapper: ObjectMapper): WebSocketHandler {
        return MyHandler(objectMapper, questionRandomizer)
    }
}
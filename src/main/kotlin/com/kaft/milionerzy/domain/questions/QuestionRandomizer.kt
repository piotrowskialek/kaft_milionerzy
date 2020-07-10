package com.kaft.milionerzy.domain.questions

import com.kaft.milionerzy.domain.games.QuestionRepository
import org.springframework.stereotype.Component

@Component
class QuestionRandomizer(val questionRepository: QuestionRepository) {
    fun getRandomQuestions(): List<Question> = questionRepository.findAll().take(12)
}
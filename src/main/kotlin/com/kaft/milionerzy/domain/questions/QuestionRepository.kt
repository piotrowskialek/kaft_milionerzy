package com.kaft.milionerzy.domain.games

import com.kaft.milionerzy.domain.questions.Question
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : MongoRepository<Question, String>
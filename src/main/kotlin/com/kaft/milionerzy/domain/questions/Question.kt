package com.kaft.milionerzy.domain.questions

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Question (
        val content: String,
        val a: String,
        val b: String,
        val c: String,
        val d: String,
        val rightAnswer: RightAnswerEnum
)

enum class RightAnswerEnum {
    A, B, C,D
}


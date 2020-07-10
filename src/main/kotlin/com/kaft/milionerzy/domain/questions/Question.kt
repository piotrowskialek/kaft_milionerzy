package com.kaft.milionerzy.domain.questions

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Question (
        @Id val id: UUID,
        val content: String,
        val a: String,
        val b: String,
        val c: String,
        val d: String,
        val rightAnswer: RightAnswerEnum,
        val prize: Int,
        val isGuaranteed: Boolean
)

enum class RightAnswerEnum {
    A, B, C,D
}


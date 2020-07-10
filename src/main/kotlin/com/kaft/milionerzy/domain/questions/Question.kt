package com.kaft.milionerzy.domain.games

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Question (
        @Id val id: UUID,
        val content: String
)


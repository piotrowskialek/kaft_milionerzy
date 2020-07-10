package com.kaft.milionerzy.infrastructure

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.kaft.milionerzy.domain.games.QuestionRepository
import com.kaft.milionerzy.domain.questions.Question
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.File


@Configuration
class QuestionConfiguration(val questionRepository: QuestionRepository) {

    @Bean
    fun questionLoader() {
        questionRepository.insert(loadObjectList())
    }

    fun loadObjectList(): List<Question> {
            return try {
                val bootstrapSchema: CsvSchema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader()
                val mapper = CsvMapper().registerModule(KotlinModule())
                val file: File = ClassPathResource("questions.csv").file
                mapper
                        .readerFor(Question::class.java)
                        .with(bootstrapSchema)
                        .readValues<Question>(file)
                        .readAll()
            } catch (e: Exception) {
                emptyList()
            }
    }

}
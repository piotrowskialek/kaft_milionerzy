package com.kaft.milionerzy.infrastructure

import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
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
        questionRepository.insert(loadObjectList(Question::class.java, "questions.csv"))
    }

    fun <T> loadObjectList(type: Class<T>, fileName: String): List<T> {
        return try {
            val bootstrapSchema: CsvSchema = CsvSchema.emptySchema().withColumnSeparator(';').withoutQuoteChar()
            val mapper = CsvMapper()
            val file: File = ClassPathResource(fileName).file
            val readValues: MappingIterator<T> = mapper.reader(type).with(bootstrapSchema).readValues(file)
            readValues.readAll()
        } catch (e: Exception) {
            emptyList()
        }
    }

}
package com.kaft.milionerzy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class MilionerzyApplication

fun main(args: Array<String>) {
	runApplication<MilionerzyApplication>(*args)
}

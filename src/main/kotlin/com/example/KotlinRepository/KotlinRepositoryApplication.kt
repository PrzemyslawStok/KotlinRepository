package com.example.KotlinRepository

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinRepositoryApplication {
	val logger = LoggerFactory.getLogger(KotlinRepositoryApplication::class.simpleName)

	@Bean
	fun init(repository: StudentRepository) = CommandLineRunner {
		for (i in 1..10) {
			logger.info("Student $i added")
			repository.save(Student("Przemysław", "Stokłosa_${i}"))
		}
		repository.saveAll(Student.createStudents(10,"Piotr","Stokłosa"){"_{it}"})
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinRepositoryApplication>(*args)
}

package com.example.KotlinRepository

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinRepositoryApplication {

	@Bean
	fun init(repository: StudentRepository) = CommandLineRunner {
		for (i in 1..10)
			repository.save(Student("Przemysław", "Stokłosa_${i}"))
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinRepositoryApplication>(*args)
}

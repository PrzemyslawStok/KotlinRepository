package com.example.KotlinRepository

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student,Long>{
    fun findByName(name: String):List<Student>
}

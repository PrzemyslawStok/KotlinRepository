package com.example.KotlinRepository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Student(
        val name: String,
        val surname: String
        )
{
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long = 0
}

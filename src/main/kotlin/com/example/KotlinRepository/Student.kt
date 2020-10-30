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

        companion object {
                fun createStudents(n: Int, name: String, surname: String, f: (Int) -> String): ArrayList<Student> {
                        val array: ArrayList<Student> = arrayListOf()

                        for (i in 1..n) {
                                array.add(Student("${name}_${f(n)}", "${surname}_${f(n)}"))
                        }

                        return array
                }
        }
}

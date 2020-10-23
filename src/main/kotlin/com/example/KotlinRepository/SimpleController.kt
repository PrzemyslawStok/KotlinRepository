package com.example.KotlinRepository

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController(val studentRepository: StudentRepository) {

    val logger = LoggerFactory.getLogger(SimpleController::class.simpleName)

    @RequestMapping("")
    fun getInfo():String{
        return "info"
    }
    @RequestMapping("index")
    fun getIndex() = "index"

    @RequestMapping("add")
    fun add(name: String?, surname: String?):String{
        if(name!=null&&surname!=null) {
            studentRepository.save(Student(name, surname))
            logger.info("Dodano studenta ${name} ${surname}")
            return "Dodano studenta: ${name} ${surname}"
        }else {
            logger.warn("Wprowadzono błędne dane podczas dodawania studenta")
            return "Proszę wprowadzić imię i nazwisko studenta"
        }
    }

    @RequestMapping("Student")
    fun findStudent(@RequestParam("name") name: String):List<Student>{
        return studentRepository.findByName(name)
    }

    @RequestMapping("Students")
    fun allStudents():Iterable<Student>{
        val students = studentRepository.findAll()
        return studentRepository.findAll()
    }
}

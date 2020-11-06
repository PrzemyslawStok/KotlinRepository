package com.example.KotlinRepository

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@Controller
class SimpleController(val studentRepository: StudentRepository) {

    val logger = LoggerFactory.getLogger(SimpleController::class.simpleName)

    @RequestMapping("")
    @ResponseBody
    fun getInfo():String{
        return "info"
    }
    @RequestMapping("index")
    @ResponseBody
    fun getIndex() = "index"

    @RequestMapping("add")
    @ResponseBody
    fun add(@RequestParam name: String?,@RequestParam surname: String?):String{
        if(name!=null&&surname!=null) {
            studentRepository.save(Student(name, surname))
            logger.info("Dodano studenta ${name} ${surname}")
            return "Dodano studenta: ${name} ${surname}"
        }else {
            logger.warn("Wprowadzono błędne dane podczas dodawania studenta")
            return "Proszę wprowadzić imię i nazwisko studenta"
        }
    }

    @RequestMapping("Student/name")
    @ResponseBody
    fun findStudentByName(@RequestParam("name") name: String?):List<Student>?{
        if(name!=null) {
            logger.info("Wyszukano studentów o imieniu: $name")
            return studentRepository.findByName(name)
        }else {
            logger.warn("Błędne dane podczas wyszukiwania studenta")
            return null
        }
    }

    @RequestMapping("Student/surname")
    @ResponseBody
    fun findStudentBySurname(@RequestParam("surname") surname: String?):List<Student>?{
        if(surname!=null) {
            logger.info("Wyszukano studentów o imieniu: $surname")
            return studentRepository.findBySurname(surname)
        }else {
            logger.warn("Błędne dane podczas wyszukiwania studenta")
            return null
        }
    }



    @RequestMapping("Students")
    fun allStudents(model: Model):String{
        val students = studentRepository.findAll()
        model.addAttribute("students",students)
        return "index"
    }
}

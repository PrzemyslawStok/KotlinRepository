package com.example.KotlinRepository

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController(val studentRepository: StudentRepository) {
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
            return "Dodano studenta: ${name} ${surname}"
        }else
            return "Proszę wprowadzić imię i nazwisko studenta"
    }
}

package com.example.springbootkotlin.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param
    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam name : String,
        @RequestParam age : Int,
    ) : String{
        println(name)
        println(age)

        return name + " " + age
    }

    @DeleteMapping("/delete-mapping/{name}/{age}")
    fun deleteMappingPath(
        @PathVariable("name") name : String,
        @PathVariable("age") age : Int
    ): String{
        println(name)
        println(age)

        return name  + " : " + age
    }


}
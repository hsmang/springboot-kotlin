package com.example.springbootkotlin.controller.get

import com.example.springbootkotlin.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable(@PathVariable("name") name : String, @PathVariable age : Int): String{
        println(name)
        println("${name} : ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // GET http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable2(@PathVariable("name") _name : String, @PathVariable age : Int): String{
        println(_name)
        println("${_name} : ${age}")
        return _name + " " + age
    }

    @GetMapping("/get-mapping/query-param")  // ?name=sm&age=20
    fun queryParam(
        @RequestParam name: String, @RequestParam age: Int
    ) : String{
        println("${name }  : ${age}")
        return name + " " + age
    }

    // name , age, address, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(  userRequest : UserRequest ): UserRequest{
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        println(map)
        return map
    }
}
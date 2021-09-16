package com.example.springbootkotlin.controller.put

import com.example.springbootkotlin.model.http.Result
import com.example.springbootkotlin.model.http.UserRequest
import com.example.springbootkotlin.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String{
        return "put-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest) : UserResponse{
        // 0 . Response
        return UserResponse().apply{
            // 1. result
            this.result =
                Result().apply{
                    this.resultCode = "OK"
                    this.resultMessage = "성공"
                }
        }.apply {
            // 2. description
            this.description = " ~~~~~~~ "
        }.apply {
            // 3. user mutable list
            var userList = mutableListOf<UserRequest>()

            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@a"
                this.address = "aa"
                this.phoneNumber = "0101aaaa"
            })

            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "b@b"
                this.address = "bb"
                this.phoneNumber = "0101bbb"
            })

            this.userRequest = userList
        }

    }
}
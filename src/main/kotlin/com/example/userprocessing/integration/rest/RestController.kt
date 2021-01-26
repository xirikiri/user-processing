package com.example.userprocessing.integration.rest

import com.example.userprocessing.model.User
import com.example.userprocessing.service.UserDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class RestController(
        @Autowired private val userDataService: UserDataService
) {
    @GetMapping("/get/{id}")
    fun getUserById(@PathVariable id: String): String {
        return "success";
    }

    @PostMapping("/put")
    fun addUser(@RequestBody user: User?): User {
        return User(
                0,
                "firstName",
                "lastName",
                "email",
                Date(111))
    }
}
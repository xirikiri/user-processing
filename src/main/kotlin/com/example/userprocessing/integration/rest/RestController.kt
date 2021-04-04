package com.example.userprocessing.integration.rest

import com.example.userprocessing.model.User
import com.example.userprocessing.service.UserDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/user")
class RestController(
    private val userDataService: UserDataService
) {
    @GetMapping("/get/{id}")
    fun getUserById(@PathVariable id: String) = userDataService.findUserById(id)

    @PostMapping("/put")
    fun addUser(@RequestBody user: User) = userDataService.addUser(user)

    @GetMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: String) = userDataService.deleteUserById(id)

    @PostMapping("/update")
    fun changeUser(@RequestParam(required = false) id: String?, @RequestBody user: User) =
        userDataService.changeUserById(id, user)
}
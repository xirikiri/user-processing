package com.example.userprocessing.service

import com.example.userprocessing.configuration.UserCrudRepository
import com.example.userprocessing.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*
import kotlin.NoSuchElementException
import kotlin.jvm.Throws

@Service
class UserDataService(
    @Autowired private val userCrudRepository: UserCrudRepository
) {

    @Transactional
    @Throws(NoSuchElementException::class)
    fun findUserById(id: String) = userCrudRepository.findById(id.toLong()).get()

    @Transactional
    fun addUser(user: User): User {
        user.registrationDate = Date.from(Instant.now())
        return userCrudRepository.save(user)
    }

    @Transactional
    fun deleteUserById(id: String) = userCrudRepository.deleteById(id.toLong())
}

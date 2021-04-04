package com.example.userprocessing.service

import com.example.userprocessing.configuration.UserCrudRepository
import com.example.userprocessing.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class UserDataService(
    @Autowired private val userCrudRepository: UserCrudRepository
) {
    fun findUserById(id: String) = userCrudRepository.findById(id.toLong()).get()

    fun addUser(user: User): User {
        user.registrationDate = Date.from(Instant.now())
        return userCrudRepository.save(user)
    }

    fun deleteUserById(id: String) = userCrudRepository.deleteById(id.toLong())

    fun changeUserById(id: String?, user: User): User {
        val userId = id ?: user.id.toString()
        val oldUser = userCrudRepository.findById(userId.toLong()).get()
        oldUser.update(user)
        return userCrudRepository.save(oldUser)
    }

    companion object {
        private fun User.update(newUser: User) {
            when {
                newUser.firstName.isNotEmpty() -> this.firstName = newUser.firstName
                newUser.lastName.isNotEmpty() -> this.lastName = newUser.lastName
                newUser.mail.isNotEmpty() -> this.mail = newUser.mail
            }
        }
    }
}

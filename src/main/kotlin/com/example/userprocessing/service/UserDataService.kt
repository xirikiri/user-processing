package com.example.userprocessing.service

import com.example.userprocessing.configuration.UserCrudRepository
import com.example.userprocessing.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDataService(
        @Autowired private val userCrudRepository: UserCrudRepository
) {
    @Transactional
    fun addUser(user: User) {
        userCrudRepository.save(user)
    }

    @Transactional
    fun findUserById(id: Long) {
        userCrudRepository.findById(id)
    }
}

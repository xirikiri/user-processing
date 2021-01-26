package com.example.userprocessing.configuration

import com.example.userprocessing.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCrudRepository : CrudRepository<User, Long>
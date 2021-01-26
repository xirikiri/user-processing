package com.example.userprocessing.model

import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="USER")
data class User(
        @Id val id: Long,
        val firstName: String,
        val lastName: String,
        val mail: String,
        val registrationDate: Date
)

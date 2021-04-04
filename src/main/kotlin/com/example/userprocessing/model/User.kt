package com.example.userprocessing.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "public", name="user")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        var id: Long? = null,

        @Column(name="firstname")
        var firstName: String,
        @Column(name="lastname")
        var lastName: String,
        @Column(name = "email")
        var mail: String,
        @Column(name = "registrationDate")
        var registrationDate: Date?
)

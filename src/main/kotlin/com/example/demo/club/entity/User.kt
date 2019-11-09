package com.example.demo.club.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "club_user")
data class User(
        @Id @GeneratedValue
        var id: Long? = null
)

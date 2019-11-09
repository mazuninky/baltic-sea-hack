package com.example.demo.club.entity

import javax.persistence.*

@Entity
@Table(name = "club")
data class Club(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column(unique = true)
        val name: String,
        @Column
        val locationLatitude: Float,
        @Column
        val locationLongitude: Float
)

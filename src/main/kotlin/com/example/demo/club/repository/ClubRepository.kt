package com.example.demo.club.repository

import com.example.demo.club.entity.Club
import org.springframework.data.repository.CrudRepository
import com.example.demo.club.entity.User

interface ClubRepository : CrudRepository<Club, Long> {
}

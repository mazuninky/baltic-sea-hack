package com.example.demo.club.repository

import org.springframework.data.repository.CrudRepository
import com.example.demo.club.entity.User

interface UserRepository : CrudRepository<User, Long> {
}

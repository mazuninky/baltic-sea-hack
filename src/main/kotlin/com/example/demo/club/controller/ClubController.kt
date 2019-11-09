package com.example.demo.club.controller

import com.example.demo.club.entity.Club
import com.example.demo.club.repository.ClubRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("club")
class ClubController(private val clubsRepository: ClubRepository) {

    @GetMapping("/all")
    fun listOfClubs(): List<Club> {
        return clubsRepository.findAll().toList()
    }
}

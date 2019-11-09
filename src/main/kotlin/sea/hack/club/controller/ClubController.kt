package sea.hack.club.controller

import sea.hack.club.entity.Club
import sea.hack.club.repository.ClubRepository
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

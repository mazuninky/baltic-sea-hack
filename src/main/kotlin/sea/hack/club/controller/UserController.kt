package sea.hack.club.controller

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import sea.hack.club.controller.dto.ClubDTO
import sea.hack.club.controller.dto.SectionDTO
import sea.hack.club.entity.*
import sea.hack.club.repository.*

@RestController
@RequestMapping("user")
class UserController(private val peopleRepository: PeopleRepository) {

    data class UserDTO(val name : String)
    @GetMapping("/{userId}/name/")
    fun getUser(@PathVariable("userId") userId: Long): UserDTO {
        return UserDTO(peopleRepository.findById(userId).get().name)
    }
}

package sea.hack.club.controller

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import sea.hack.club.entity.Club
import sea.hack.club.repository.ClubRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sea.hack.club.controller.dto.ClubDTO
import sea.hack.club.controller.dto.SectionDTO
import sea.hack.club.repository.LocationRepository
import sea.hack.club.repository.SectionRepository

@RestController
@RequestMapping("club")
class ClubController(private val clubsRepository: ClubRepository,
                     private val sectionRepository: SectionRepository,
                     private val locationRepository: LocationRepository) {

    @GetMapping("/all")
    fun listOfClubs(): List<ClubDTO> {
        val clubs = clubsRepository.findAllWithLocationsBy()

        return clubs.map {
            val sections = it.sections.map {
                val id = checkNotNull(it.id)
                SectionDTO(id, it.name)
            }
            val id = checkNotNull(it.id)
            ClubDTO(id, it.name, it.location.name, it.location.locationLatitude, it.location.locationLongitude, sections)
        }
    }
}

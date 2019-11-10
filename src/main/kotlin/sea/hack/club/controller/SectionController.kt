package sea.hack.club.controller

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import sea.hack.club.entity.Club
import sea.hack.club.controller.dto.ClubDTO
import sea.hack.club.controller.dto.SectionDTO
import sea.hack.club.entity.PeopleMeeting
import sea.hack.club.entity.Section
import sea.hack.club.entity.Skill
import sea.hack.club.repository.*

@RestController
@RequestMapping("section")
class SectionController(private val sectionRepository: SectionRepository) {

    @GetMapping("/all")
    fun getSkills(): List<Section> {
        return sectionRepository.findAllWithSkillsBy().toList()
    }
}

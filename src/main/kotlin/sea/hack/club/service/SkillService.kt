package sea.hack.club.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sea.hack.club.entity.Skill
import sea.hack.club.repository.SkillRepository

@Service
class SkillService(private val skillRepository: SkillRepository) {

    fun create(title: String): Skill {
        val skill = Skill(title)

        return skillRepository.save(skill)
    }

    fun update(id: Long, title: String): Boolean {
        val skill = skillRepository.findByIdOrNull(id) ?: return false

        skill.name = title
        skillRepository.save(skill)
        return true
    }

    fun delete(idList: List<Long>): Boolean {
        idList.map { skillRepository.deleteById(it) }
        return true
    }

}

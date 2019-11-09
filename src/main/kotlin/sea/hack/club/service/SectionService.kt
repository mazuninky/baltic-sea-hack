package sea.hack.club.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sea.hack.club.entity.Section
import sea.hack.club.graphql.types.item.InputUpdateItemType
import sea.hack.club.graphql.types.item.ItemType
import sea.hack.club.repository.SectionRepository
import sea.hack.club.repository.SkillRepository

@Service
class SectionService(private val sectionRepository: SectionRepository,
                     private val skillRepository: SkillRepository) {

    fun create(name: String, tags: List<Long>): Section {
        val skills = skillRepository.findAllById(tags)

        val section = Section(name, skills.toList())

        return sectionRepository.save(section)
    }

    fun update(item: InputUpdateItemType): Boolean {
        val section = sectionRepository.findByIdOrNull(item.id) ?: return false

        section.name = item.title

        val skillsId = item.tags
                .map { it.id }
                .toMutableSet()

        skillsId.addAll(
                section.skills
                        .map { it.id as Long }
        )


        val skills = skillRepository.findAllById(skillsId)

        section.skills = skills.toList();

        sectionRepository.save(section)
        return true
    }

    fun delete(idList: List<Long>): Boolean {
        idList.forEach { sectionRepository.deleteById(it) }
        return true
    }
}

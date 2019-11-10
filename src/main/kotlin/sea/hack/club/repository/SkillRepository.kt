package sea.hack.club.repository

import org.springframework.data.jpa.repository.Query
import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.Skill

@Repository
interface SkillRepository : CrudRepository<Skill, Long> {
    @Query("SELECT s FROM Skill s WHERE s.name LIKE %?1%")
    fun findByName(name: String): List<Skill>
}

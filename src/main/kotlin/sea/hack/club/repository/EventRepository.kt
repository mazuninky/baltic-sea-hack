package sea.hack.club.repository

import org.springframework.data.jpa.repository.EntityGraph
import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.Event
import sea.hack.club.entity.Location

@Repository
interface EventRepository : CrudRepository<Event, Long> {
    @EntityGraph(attributePaths = ["skills"])
    fun findAllWithSkillsBy(): List<Event>

    @EntityGraph(attributePaths = ["skills"])
    fun findOneWithSkillsById(id: Long): Event
}

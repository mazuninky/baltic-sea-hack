package sea.hack.club.repository

import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.Skill
import sea.hack.club.entity.Time

@Repository
interface TimeRepository : CrudRepository<Time, Long> {
}

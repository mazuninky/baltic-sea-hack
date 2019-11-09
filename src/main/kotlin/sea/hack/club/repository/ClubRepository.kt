package sea.hack.club.repository

import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository

interface ClubRepository : CrudRepository<Club, Long> {
}

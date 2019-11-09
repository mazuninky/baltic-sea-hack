package sea.hack.club.repository

import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClubRepository : CrudRepository<Club, Long> {
}

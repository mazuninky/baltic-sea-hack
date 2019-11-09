package sea.hack.club.repository

import org.springframework.data.repository.CrudRepository
import sea.hack.club.entity.People

interface UserRepository : CrudRepository<People, Long> {
}

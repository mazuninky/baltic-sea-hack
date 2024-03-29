package sea.hack.club.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.People

@Repository
interface UserRepository : CrudRepository<People, Long> {
}

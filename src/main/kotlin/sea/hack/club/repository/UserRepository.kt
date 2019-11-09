package sea.hack.club.repository

import org.springframework.data.repository.CrudRepository
import sea.hack.club.entity.User

interface UserRepository : CrudRepository<User, Long> {
}
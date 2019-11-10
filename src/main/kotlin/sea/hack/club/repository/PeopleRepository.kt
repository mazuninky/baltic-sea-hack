package sea.hack.club.repository

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import org.springframework.data.jpa.repository.EntityGraph
import sea.hack.club.entity.Club
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.People

@Repository
interface PeopleRepository : CrudRepository<People, Long> {

}

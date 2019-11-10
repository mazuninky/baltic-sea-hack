package sea.hack.club.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import sea.hack.club.entity.Location
import sea.hack.club.entity.PeopleMeeting

@Repository
interface MeetingRepository : CrudRepository<PeopleMeeting, Long> {

}

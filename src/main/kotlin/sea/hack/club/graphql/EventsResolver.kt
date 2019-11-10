package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.*
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.MeetingRepository

@Component
class EventsResolver(private val eventRepository: EventRepository,
                     private val meetingRepository: MeetingRepository) : GraphQLQueryResolver {
    // getEvents: EventType
    fun getEvents(): List<EventType> {
        return eventRepository.findAllWithSkillsBy().toList()
                .map {
                    val id = checkNotNull(it.id)
                    val locationId = checkNotNull(it.location.id)

                    val timeType = TimeType(it.time.start, it.time.end)

                    val meetings = meetingRepository.findAllByEvent(it)

                    val point = PointType(it.location.name, LocationType(it.location.locationLatitude,
                            it.location.locationLongitude))

                    EventType(
                            id = id,
                            point = point,
                            title = it.name,
                            time = timeType,
                            description = it.description,
                            people = meetings.map { it.id as Long },
                            admins = meetings.map { it.id as Long },
                            tags = it.skills.map { it.id as Long }
                    )
                }
    }
}

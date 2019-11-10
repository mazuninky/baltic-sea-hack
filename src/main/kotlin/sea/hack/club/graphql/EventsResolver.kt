package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Event
import sea.hack.club.graphql.types.*
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.MeetingRepository

@Component
class EventsResolver(private val eventRepository: EventRepository,
                     private val meetingRepository: MeetingRepository) : GraphQLQueryResolver {

    private fun mapType(event: Event): EventType {
        val id = checkNotNull(event.id)

        val timeType = TimeType(event.time.start, event.time.end)

        val meetings = meetingRepository.findAllByEvent(event)

        val point = PointType(event.location.name, LocationType(event.location.locationLatitude,
                event.location.locationLongitude))

        return EventType(
                id = id,
                point = point,
                title = event.name,
                time = timeType,
                description = event.description,
                people = meetings.map { it.id as Long },
                admins = meetings.map { it.id as Long },
                tags = event.skills.map { it.id as Long }
        )
    }

    // getEvents: EventType
    fun getEvents(): List<EventType> {
        return eventRepository.findAllWithSkillsBy().map(this::mapType)
    }

    // getEvent(id: Int!): EventType
    fun getEvent(id: Long): EventType {
        return mapType(eventRepository.findOneWithSkillsById(id))
    }
}

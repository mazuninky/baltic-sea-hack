package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Event
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.MeetingRepository


fun mapType(meetingRepository: MeetingRepository, event: Event): EventType {
    val id = checkNotNull(event.id)

    val timeType = TimeType(event.time.start, event.time.end)

    val meetings = meetingRepository.findAllByEvent(event)

    val point = PointType(event.location.id as Long, event.location.name, LocationType(event.location.locationLatitude,
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

@Component
class EventsResolver(private val eventRepository: EventRepository,
                     private val meetingRepository: MeetingRepository) : GraphQLQueryResolver {


    // getEvents: EventType
    fun getEvents(): List<EventType> {
        return eventRepository.findAllWithSkillsBy().map { mapType(meetingRepository, it) }
    }

    // getEvent(id: Int!): EventType
    fun getEvent(id: Long): EventType {
        return mapType(meetingRepository, eventRepository.findOneWithSkillsById(id))
    }
}

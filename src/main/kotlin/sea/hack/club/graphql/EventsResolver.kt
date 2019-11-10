package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Event
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.MeetingRepository


fun mapType(meetingRepository: MeetingRepository, event: Event): EventType {
    val id = checkNotNull(event.id)

    val timeType = TimeType(event.time.start, event.time.end)

    val meetings = meetingRepository.findAllByEvent(event)

    val point = PointType((event.location.id as Long).toInt(), event.location.name, LocationType(event.location.locationLatitude,
            event.location.locationLongitude))

    return EventType(
            id = id.toInt(),
            point = point,
            title = event.name,
            time = timeType,
            description = event.description,
            people = meetings.map { it.id as Long }.map { it.toInt() },
            admins = meetings.map { it.id as Long }.map { it.toInt() },
            tags = event.skills.map { it.id as Long }.map { it.toInt() }
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
    fun getEvent(id: Int): EventType {
        return mapType(meetingRepository, eventRepository.findOneWithSkillsById(id.toLong()))
    }
}

package sea.hack.club.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import sea.hack.club.entity.Event
import sea.hack.club.entity.Location
import sea.hack.club.entity.Skill
import sea.hack.club.entity.Time
import sea.hack.club.graphql.types.event.InputCreateEventType
import sea.hack.club.graphql.types.event.InputUpdateEventType
import sea.hack.club.graphql.types.tag.InputCreateTagType
import sea.hack.club.repository.*

@Service
class EventService(private val eventRepository: EventRepository,
                   private val sectionRepository: SectionRepository,
                   private val locationRepository: LocationRepository,
                   private val timeRepository: TimeRepository) {

    fun create(input: InputCreateEventType): Event {
        val location = locationRepository.findById(input.pointId as Long).get()
        val time = timeRepository.save(Time(input.start, input.end))
        val section = sectionRepository.findById(input.itemId.toLong())
        val event = Event(name = input.title, description = input.desc,
                location = location, time = time, admin = null,
                skills = emptyList(), section = section.get())

        return eventRepository.save(event)
    }

    fun update(input: InputUpdateEventType): Boolean {
        val event = eventRepository.findOneWithSkillsById(input.id.toLong())

        event.name = input.title
        event.description = input.desc
        // TODO

        return true
    }

    fun delete(idList: List<Int>): Boolean {
        idList.map { eventRepository.deleteById(it.toLong()) }
        return true
    }

}

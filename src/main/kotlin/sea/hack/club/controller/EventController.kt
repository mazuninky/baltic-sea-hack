package sea.hack.club.controller

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import sea.hack.club.entity.Club
import sea.hack.club.controller.dto.ClubDTO
import sea.hack.club.controller.dto.SectionDTO
import sea.hack.club.entity.Event
import sea.hack.club.entity.PeopleMeeting
import sea.hack.club.repository.*


data class EventCount(val count: Int, val event: Event)

@RestController
@RequestMapping("event")
class EventController(private val meetingRepository: MeetingRepository,
                      private val eventRepository: EventRepository,
                      private val peopleRepository: PeopleRepository) {

    @GetMapping("/all")
    fun all(): List<Event> {
        return eventRepository.findAllWithSkillsBy()
    }

    @GetMapping("/{eventId}/count")
    fun count(@PathVariable("eventId") eventId: Long): EventCount {
        val event = eventRepository.findOneWithSkillsById(eventId)
        val count = meetingRepository.findAllByEvent(event).size
        return EventCount(count, event)
    }

    @PostMapping("/{eventId}/meet/{userId}")
    fun meet(@PathVariable("eventId") eventId: Long,
             @PathVariable("userId") userId: Long): Boolean {
        val event = eventRepository.findByIdOrNull(eventId) ?: return false

        val people = peopleRepository.findByIdOrNull(userId) ?: return false

//        val meeting = PeopleMeeting(event, people)
        val meeting = meetingRepository.findOneByEventAndPeople(event, people)

        meeting.isAttended = true
        meetingRepository.save(meeting)

        return true
    }

    @PostMapping("/{eventId}/subscribe/{userId}")
    fun subscribe(@PathVariable("eventId") eventId: Long,
                  @PathVariable("userId") userId: Long): Boolean {
        val event = eventRepository.findByIdOrNull(eventId) ?: return false

        val people = peopleRepository.findByIdOrNull(userId) ?: return false

        val meeting = PeopleMeeting(false, event, people)
//        val meeting = meetingRepository.findOneByEventAndPeople(event, people)

        meetingRepository.save(meeting)

        return true
    }
}

package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.PointType
import sea.hack.club.graphql.types.TimeType
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.event.InputCreateEventType
import sea.hack.club.graphql.types.event.InputUpdateEventType
import sea.hack.club.graphql.types.event.ReturnEventType
import sea.hack.club.graphql.types.item.*
import sea.hack.club.graphql.types.tag.*
import sea.hack.club.graphql.types.toGraphType
import sea.hack.club.repository.EventRepository
import sea.hack.club.service.EventService
import sea.hack.club.service.SectionService
import sea.hack.club.service.SkillService

@Component
class EventMutationResolver(private val eventService: EventService) : GraphQLMutationResolver {
    // event(create: InputCreateEventType, update: InputUpdateEventType, delete: [Int]): ReturnEventType
    fun event(create: InputCreateEventType?, update: InputUpdateEventType?, delete: List<Long>): ReturnEventType {
        val created: EventType? = inputCreate(create)
        val updated = inputUpdate(update)
        val deleted = inputDelete(delete)

        return ReturnEventType(created, updated, deleted)
    }

    private fun inputCreate(create: InputCreateEventType?): EventType? {
        if (create == null) {
            return null
        }

        val event = eventService.create(create)

        return EventType(
                event.id!!,
                PointType(event.location.name, event.location.toGraphType()),
                event.name,
                TimeType(event.time.start, event.time.end),
                event.description,
                emptyList(),
                emptyList(),
                event.skills.map { it.id!! }
        )
    }


    private fun inputUpdate(update: InputUpdateEventType?): Boolean {
        if (update == null) {
            return false
        }

        return eventService.update(update)
    }

    private fun inputDelete(delete: List<Long>): Boolean {
        if (delete.isEmpty()) {
            return false
        }

        return eventService.delete(delete)
    }
}

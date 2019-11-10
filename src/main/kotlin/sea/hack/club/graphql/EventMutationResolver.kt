package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.graphql.types.TimeType
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.event.InputCreateEventType
import sea.hack.club.graphql.types.event.InputUpdateEventType
import sea.hack.club.graphql.types.event.ReturnEventType
import sea.hack.club.graphql.types.item.ItemType
import sea.hack.club.graphql.types.toGraphType
import sea.hack.club.service.EventService

@Component
class EventMutationResolver(private val eventService: EventService) : GraphQLMutationResolver {
    // event(create: InputCreateEventType, update: InputUpdateEventType, delete: [Int]): ReturnEventType
    fun event(create: InputCreateEventType?, update: InputUpdateEventType?, delete: List<Int>): ReturnEventType {
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

        val id = checkNotNull(event.section.id)
        val item = ItemType(id = id.toInt(),
                title = event.section.name,
                events = emptyList(),
                tags = emptyList()
        )

        return EventType(
                (event.id!!).toInt(),
                PointType((event.location.id as Long).toInt(), event.location.name, event.location.toGraphType()),
                event.name,
                TimeType(event.time.start, event.time.end),
                event.description,
                emptyList(),
                emptyList(),
                event.skills.map { it.id!!.toInt() },
                item
        )
    }


    private fun inputUpdate(update: InputUpdateEventType?): Boolean {
        if (update == null) {
            return false
        }

        return eventService.update(update)
    }

    private fun inputDelete(delete: List<Int>): Boolean {
        if (delete.isEmpty()) {
            return false
        }

        return eventService.delete(delete)
    }
}

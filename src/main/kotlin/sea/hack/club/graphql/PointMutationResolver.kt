package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import sea.hack.club.entity.Location
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.graphql.types.TimeType
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.event.InputCreateEventType
import sea.hack.club.graphql.types.event.InputUpdateEventType
import sea.hack.club.graphql.types.event.ReturnEventType
import sea.hack.club.graphql.types.point.InputCreatePointType
import sea.hack.club.graphql.types.point.InputUpdatePointType
import sea.hack.club.graphql.types.point.ReturnPointType
import sea.hack.club.graphql.types.toGraphType
import sea.hack.club.repository.LocationRepository
import sea.hack.club.service.EventService

@Component
class PointMutationResolver(private val locationRepository: LocationRepository) : GraphQLMutationResolver {
    // point(create: InputCreatePointType, update: InputUpdatePointType, delete: [Int]): ReturnPointType
    fun point(create: InputCreatePointType?, update: InputUpdatePointType?, delete: List<Long>): ReturnPointType {
        val created: PointType? = inputCreate(create)
        val updated = inputUpdate(update)
        val deleted = inputDelete(delete)

        return ReturnPointType(created, updated, deleted)
    }

    private fun inputCreate(create: InputCreatePointType?): PointType? {
        if (create == null) {
            return null
        }

        val location = locationRepository.save(Location(create.title, create.lang, create.long))

        return PointType((location.id as Long).toInt(), location.name, location.toGraphType())
    }


    private fun inputUpdate(update: InputUpdatePointType?): Boolean {
        if (update == null) {
            return false
        }

        val loc = locationRepository.findByIdOrNull(update.id.toLong()) ?: return false

        loc.locationLatitude = update.lang
        loc.locationLongitude = update.long
        loc.name = update.title

        locationRepository.save(loc)

        return true
    }

    private fun inputDelete(delete: List<Long>): Boolean {
        if (delete.isEmpty()) {
            return false
        }

        delete.forEach { locationRepository.deleteById(it) }
        return true
    }
}

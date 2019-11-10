package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Event
import sea.hack.club.entity.Location
import sea.hack.club.entity.Section
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.item.ItemType
import sea.hack.club.graphql.types.tag.TagType
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.LocationRepository
import sea.hack.club.repository.MeetingRepository
import sea.hack.club.repository.SectionRepository

@Component
class PointResolver(private val locationRepository: LocationRepository) : GraphQLQueryResolver {

    private fun mapType(point: Location): PointType {
        val id = checkNotNull(point.id)

        return PointType(
                id = id,
                title = point.name,
                location = point.toGraphType()
        )
    }

    fun getPoints(): List<PointType> {
        return locationRepository.findAll().map(this::mapType)
    }

    fun getPoint(id: Long): PointType {
        return mapType(locationRepository.findById(id).get())
    }
}

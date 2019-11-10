package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Location
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.repository.LocationRepository

@Component
class PointResolver(private val locationRepository: LocationRepository) : GraphQLQueryResolver {

    private fun mapType(point: Location): PointType {
        val id = checkNotNull(point.id)

        return PointType(
                id = id.toInt(),
                title = point.name,
                location = point.toGraphType()
        )
    }

    fun getPoints(): List<PointType> {
        return locationRepository.findAll().map(this::mapType)
    }

    fun getPoint(id: Int): PointType {
        return mapType(locationRepository.findById(id.toLong()).get())
    }
}

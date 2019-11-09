package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.dto.ClubDTO
import sea.hack.club.repository.ClubRepository

@Component
class ClubsQueryResovler(private val clubRepository: ClubRepository) : GraphQLQueryResolver {

    fun clubs(): List<ClubDTO> {
        return clubRepository.findAll().map {
            val id = checkNotNull(it.id)
            ClubDTO(id, it.name, it.locationLongitude, it.locationLatitude)
        }
    }
}

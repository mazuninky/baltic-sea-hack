package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Location
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.graphql.types.tag.TagType
import sea.hack.club.graphql.types.tag.toGraphType
import sea.hack.club.repository.LocationRepository
import sea.hack.club.repository.SkillRepository

@Component
class SeacrhResolver(private val skillRepository: SkillRepository) : GraphQLQueryResolver {

    // tagSuggest(search: String): [TagType]
    fun tagSuggest(search: String): List<TagType> {
        return skillRepository.findByName(search).map { it.toGraphType() }
    }

    // stat : String
    fun stat(): String {
        return this::class.java.getResource("/data/analytics.json").file.reader().readText()
    }
}

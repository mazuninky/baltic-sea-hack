package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.entity.Event
import sea.hack.club.entity.Section
import sea.hack.club.graphql.types.*
import sea.hack.club.graphql.types.event.EventType
import sea.hack.club.graphql.types.item.ItemType
import sea.hack.club.graphql.types.tag.TagType
import sea.hack.club.repository.EventRepository
import sea.hack.club.repository.MeetingRepository
import sea.hack.club.repository.SectionRepository

@Component
class ItemResolver(private val sectionRepository: SectionRepository,
                   private val meetingRepository: MeetingRepository,
                   private val eventsRepository: EventRepository) : GraphQLQueryResolver {

    private fun mapType(section: Section): ItemType {
        val id = checkNotNull(section.id)
        val events = eventsRepository.findAllBySection(section)

        return ItemType(
                id = id.toInt(),
                title = section.name,
                events = events.map { mapType(meetingRepository, it) },
                tags = section.skills.map { TagType((it.id as Long).toInt()) }
        )
    }

    fun getItems(): List<ItemType> {
        return sectionRepository.findAllWithSkillsBy().map(this::mapType)
    }

    fun getItem(id: Long): ItemType {
        return mapType(sectionRepository.findOneWithSkillsById(id))
    }
}

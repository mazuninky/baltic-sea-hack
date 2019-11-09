package sea.hack.club.graphql.types.item

import sea.hack.club.entity.Section
import sea.hack.club.entity.Skill
import sea.hack.club.graphql.types.EventType
import sea.hack.club.graphql.types.tag.TagType
import sea.hack.club.graphql.types.tag.toGraphType

/*
type ItemType {
    id: Int
    title: String
    events: [EventType]
    tags: [TagType]
}
 */

data class ItemType(
        val id: Long,
        val title: String,
        val events: List<EventType>,
        val tags: List<TagType>
)


fun Section.toGraphType(): ItemType {
    val id = checkNotNull(this.id)
    return ItemType(id = id,
            title = name,
            events = emptyList(),
            tags = this.skills.map(Skill::toGraphType)
    )
}


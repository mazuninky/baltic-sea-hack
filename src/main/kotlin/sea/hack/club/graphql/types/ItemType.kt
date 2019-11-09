package sea.hack.club.graphql.types

/*
type ItemType {
    title: String
    events: [EventType]
    tags: [TagType]
}
 */

data class ItemType(
        val title: String,
        val events: List<EventType>,
        val tags: List<TagType>
)

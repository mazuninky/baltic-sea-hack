package sea.hack.club.graphql.types.item

/*
input InputUpdateItemType {
    id: Int
    title: String
    tags: [InputTagType]
}
 */

data class InputUpdateItemType(
        val id: Long,
        val title: String,
        val tags: List<InputTagType>
)

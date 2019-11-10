package sea.hack.club.graphql.types.item

/*
input InputUpdateItemType {
    id: Int
    title: String
    tags: [InputTagType]
}
 */

data class InputUpdateItemType(
        val id: Int,
        val title: String,
        val tags: List<InputTagType>
)

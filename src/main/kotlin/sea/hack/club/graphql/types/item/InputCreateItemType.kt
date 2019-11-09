package sea.hack.club.graphql.types.item

/*
input InputCreateItemType {
    title: String
    tags: [InputTagType]
}
 */

data class InputCreateItemType(
        val title: String,
        val tags: List<InputTagType>
)

package sea.hack.club.graphql.types

/*
type PeopleType {
    name: String
    age: Int
    tags: [TagRating]
    history: [EventTagType]
}
 */
data class PeopleType(
        var name: String,
        var age: Int,
        var tags: List<TagRatingType>,
        var history: List<EventTagRatingType>
)

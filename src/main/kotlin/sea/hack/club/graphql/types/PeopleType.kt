package sea.hack.club.graphql.types

import sea.hack.club.graphql.types.event.EventTagRatingType

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

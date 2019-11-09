package sea.hack.club.graphql.types

data class EventTagRatingType(
        val eventId: Long,
        val ratings: List<TagRatingType>
)

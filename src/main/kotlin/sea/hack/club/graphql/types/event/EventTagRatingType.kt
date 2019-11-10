package sea.hack.club.graphql.types.event

import sea.hack.club.graphql.types.TagRatingType

data class EventTagRatingType(
        val eventId: Long,
        val ratings: List<TagRatingType>
)

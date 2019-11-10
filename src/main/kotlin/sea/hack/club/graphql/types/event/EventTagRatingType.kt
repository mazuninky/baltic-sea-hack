package sea.hack.club.graphql.types.event

import sea.hack.club.graphql.types.TagRatingType

data class EventTagRatingType(
        val eventId: Int,
        val ratings: List<TagRatingType>
)

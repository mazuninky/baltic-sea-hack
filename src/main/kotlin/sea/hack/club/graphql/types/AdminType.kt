package sea.hack.club.graphql.types

import sea.hack.club.graphql.types.event.EventType

/*

type AdminType {
    title: String
    events: [EventType]
    points: [PointType]
}
 */

data class AdminType(
        val title: String,
        val events: List<EventType>,
        val points: List<PointType>
)

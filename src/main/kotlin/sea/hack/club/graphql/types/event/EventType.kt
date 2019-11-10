package sea.hack.club.graphql.types.event

import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.graphql.types.TimeType

/*

type EventType {
    pointId: Int
    title: String
    time: TimeType
    description: String
    people: [PeopleType]
    admins: [AdminUserType]
    tags: [String]
}

 */

data class EventType(
        val id: Long,
        val point: PointType,
        val title: String,
        val time: TimeType,
        val description: String,
        val people: List<Long>,
        val admins: List<Long>,
        val tags: List<Long>
)

//fun Event.toGraphType() : EventType {
//    val id = checkNotNull(id)
//    return
//}

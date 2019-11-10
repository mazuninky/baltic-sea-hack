package sea.hack.club.graphql.types.event

import sea.hack.club.graphql.types.PeopleType
import sea.hack.club.graphql.types.point.PointType
import sea.hack.club.graphql.types.TimeType
import sea.hack.club.graphql.types.item.ItemType

/*

type EventType {
    id: Int
    point: PointType
    title: String
    time: TimeType
    description: String
    people: [PeopleType]
    admins: [Int]
    tags: [Int]
    item: ItemType
}

 */

data class EventType(
        val id: Int,
        val point: PointType,
        val title: String,
        val time: TimeType,
        val description: String,
        val people: List<PeopleType>,
        val admins: List<Int>,
        val tags: List<Int>,
        val item: ItemType
)

//fun Event.toGraphType() : EventType {
//    val id = checkNotNull(id)
//    return
//}

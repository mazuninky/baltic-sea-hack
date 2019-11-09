package sea.hack.club.graphql.types

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
        val pointId: Int,
        val title: String,
        val time: TimeType,
        val description: String,
        val people: List<PeopleType>,
        val admins: List<AdminUserType>,
        val tags: List<Long>
)

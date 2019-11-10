package sea.hack.club.graphql.types.event

/*
input InputUpdateEventType {
    id: Int
    title: String
    point: PointInputType
    start: String
    end: String
    tags: [Int]
}
 */
data class InputUpdateEventType(val id: Long, val title: String, val desc: String, val point: PointInputType,
                                val start: String, val end: String, val tags: List<Long>)

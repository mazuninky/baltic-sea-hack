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
data class InputUpdateEventType(val id: Int, val title: String, val desc: String,
        //val point: PointInputType,
                                val pointId: Int,
                                val start: String, val end: String, val tags: List<Int>)

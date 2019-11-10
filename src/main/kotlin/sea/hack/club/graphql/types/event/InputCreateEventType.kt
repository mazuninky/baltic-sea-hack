package sea.hack.club.graphql.types.event

/*
input InputCreateEventType {
    title: String
    point: PointInput
    start: String
    end: String
    tags: [Int]
}
 */

data class InputCreateEventType(
        val title: String,
        val itemId: Int,
        val desc: String,
//        val point: PointInputType,
        val pointId: Int,
        val start: String,
        val end: String,
        val tags: List<Int>
)

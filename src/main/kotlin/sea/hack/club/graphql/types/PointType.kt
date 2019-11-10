package sea.hack.club.graphql.types

//type PointType {
//    title: String
//    location :LocationType
//}

data class PointType(val id: Long, val title: String, val location: LocationType)

package sea.hack.club.graphql.types.point

import sea.hack.club.graphql.types.LocationType

//type PointType {
//    title: String
//    location :LocationType
//}

data class PointType(val id: Int, val title: String, val location: LocationType)

package sea.hack.club.graphql.types

import sea.hack.club.entity.Location

//type LocationType {
//    lang: Float
//    long: Float
//}


data class LocationType(
        val lang: Float,
        val long: Float
)

fun Location.toGraphType(): LocationType {
    return LocationType(this.locationLatitude, this.locationLongitude)
}

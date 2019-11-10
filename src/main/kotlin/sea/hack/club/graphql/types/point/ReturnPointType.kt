package sea.hack.club.graphql.types.point

/*
type ReturnPointType {
    create: PointType
    update: Boolean
    delete: Boolean
}
 */

data class ReturnPointType(val create: PointType?,
                           val update: Boolean,
                           val delete: Boolean)

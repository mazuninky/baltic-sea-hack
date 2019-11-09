package sea.hack.club.graphql.types.tag

/*
type ReturnTagType {
    create: TagType
    update: Boolean
    delete: Boolean
}
 */
data class ReturnTagType(val create: TagType?, val update: Boolean, val delete: Boolean)

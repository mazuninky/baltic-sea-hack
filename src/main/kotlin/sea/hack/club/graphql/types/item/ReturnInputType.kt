package sea.hack.club.graphql.types.item

/*
type ReturnItemType {
    create: ItemType
    update: Boolean
    delete: Boolean
}
 */
data class ReturnInputType(val create: ItemType?, val update: Boolean, val delete: Boolean)

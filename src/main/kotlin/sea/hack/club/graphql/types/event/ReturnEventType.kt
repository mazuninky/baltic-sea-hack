package sea.hack.club.graphql.types.event

/*
type ReturnEventType {
    create: EventType
    update: Boolean
    delete: Boolean
}
 */

data class ReturnEventType(val create: EventType?, val update: Boolean, val delete: Boolean)

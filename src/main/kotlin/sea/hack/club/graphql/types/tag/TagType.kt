package sea.hack.club.graphql.types.tag

import sea.hack.club.entity.Skill

data class TagType(val id: Int)

fun Skill.toGraphType(): TagType {
    val id = checkNotNull(this.id)
    return TagType(id.toInt())
}

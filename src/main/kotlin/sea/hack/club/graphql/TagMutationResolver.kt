package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.item.*
import sea.hack.club.graphql.types.tag.*
import sea.hack.club.service.SectionService
import sea.hack.club.service.SkillService

@Component
class TagMutationResolver(private val skillService: SkillService) : GraphQLMutationResolver {
    // tag(create: InputCreateTagType, update: InputUpdateTagType, delete: [Int]): ReturnTagType
    fun tag(create: InputCreateTagType?, update: InputUpdateTagType?, delete: List<Int>): ReturnTagType {
        val created: TagType? = inputCreate(create)
        val updated = inputUpdate(update)
        val deleted = inputDelete(delete)

        return ReturnTagType(created, updated, deleted)
    }

    private fun inputCreate(create: InputCreateTagType?): TagType? {
        if (create == null) {
            return null
        }

        return skillService.create(create.title).toGraphType()
    }


    private fun inputUpdate(update: InputUpdateTagType?): Boolean {
        if (update == null) {
            return false
        }

        return skillService.update(update.id, update.title)
    }

    private fun inputDelete(delete: List<Int>): Boolean {
        if (delete.isEmpty()) {
            return false
        }

        return skillService.delete(delete)
    }
}

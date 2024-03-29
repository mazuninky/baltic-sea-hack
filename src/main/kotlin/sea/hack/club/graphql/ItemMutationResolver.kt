package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.item.*
import sea.hack.club.service.SectionService

@Component
class ItemMutationResolver(private val sectionService: SectionService) : GraphQLMutationResolver {
    //item(create: InputCreateItemType, update: InputUpdateItemType, delete: [Int]): ReturnItemType
    fun item(create: InputCreateItemType?, update: InputUpdateItemType?, delete: List<Int>): ReturnInputType {
        val created: ItemType? = inputCreate(create)
        val updated = inputUpdate(update)
        val deleted = inputDelete(delete)

        return ReturnInputType(created, updated, deleted)
    }

    private fun inputCreate(create: InputCreateItemType?): ItemType? {
        if (create == null) {
            return null
        }

        return sectionService.create(create.title, create.tags.map { it.id }.map { it.toLong() }).toGraphType()
    }


    private fun inputUpdate(update: InputUpdateItemType?): Boolean {
        if (update == null) {
            return false
        }

        return sectionService.update(update)
    }

    private fun inputDelete(delete: List<Int>): Boolean {
        if (delete.isEmpty()) {
            return false
        }

        return sectionService.delete(delete)
    }
}

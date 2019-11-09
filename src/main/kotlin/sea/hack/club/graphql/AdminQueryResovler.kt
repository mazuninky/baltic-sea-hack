package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sea.hack.club.graphql.types.AdminType


@Component
class AdminQueryResovler : GraphQLQueryResolver {

    fun admin(adminId: Int): AdminType? {
        return null
    }
}

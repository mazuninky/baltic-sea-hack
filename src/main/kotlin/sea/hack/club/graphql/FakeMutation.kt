package sea.hack.club.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class FakeMutation : GraphQLMutationResolver {
    fun fakeMutation(): Boolean {
        return true
    }
}

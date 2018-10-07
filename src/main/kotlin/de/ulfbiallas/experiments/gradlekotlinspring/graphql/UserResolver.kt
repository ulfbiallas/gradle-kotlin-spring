package de.ulfbiallas.experiments.gradlekotlinspring.graphql

import com.coxautodev.graphql.tools.GraphQLResolver
import de.ulfbiallas.experiments.gradlekotlinspring.UserResponse
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class UserResolver: GraphQLResolver<UserResponse> {

    fun getLengthOfName(user: UserResponse): Int {
        logger.info { "Resolve length of name for user $user" }
        return user.name.length
    }

}

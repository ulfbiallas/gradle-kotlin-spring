package de.ulfbiallas.experiments.gradlekotlinspring.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import de.ulfbiallas.experiments.gradlekotlinspring.UserRequest
import de.ulfbiallas.experiments.gradlekotlinspring.UserResponse
import de.ulfbiallas.experiments.gradlekotlinspring.UserService
import org.springframework.stereotype.Component

@Component
class RootMutationResolver(
    val userService: UserService
): GraphQLMutationResolver {

    fun newUser(name: String, email: String): UserResponse {
        val request = UserRequest(email, name)
        return userService.createUser(request)
    }

}

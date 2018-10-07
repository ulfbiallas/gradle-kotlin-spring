package de.ulfbiallas.experiments.gradlekotlinspring.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import de.ulfbiallas.experiments.gradlekotlinspring.UserService
import org.springframework.stereotype.Component

@Component
class RootResolver(
    val userService: UserService
) : GraphQLQueryResolver {

    fun getUsers() = userService.getUsers()

    fun getUsernames() = userService.getUsers().map { u -> u.name }
}

package de.ulfbiallas.experiments.gradlekotlinspring

import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

private val logger = KotlinLogging.logger {}

@Component
class UserServiceImpl(
    val userRepository: UserRepository
): UserService {

    override fun getUsers(): List<UserResponse> =
            userRepository.findAll().map { UserEntity.toUserResponse(it) }

    override fun createUser(user: UserRequest): UserResponse {
        val id = UUID.randomUUID().toString()
        var userEntity: UserEntity = UserEntity(id, user.email, user.name)
        userEntity = userRepository.save(userEntity)
        logger.info { "Created user $userEntity" }
        return UserEntity.toUserResponse(userEntity)
    }
}

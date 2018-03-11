package de.ulfbiallas.experiments.gradlekotlinspring

data class UserRequest(
    val email: String,
    val name: String
)

data class UserResponse(
    val id: String,
    val email: String,
    val name: String
)

interface UserService {

    fun getUsers(): List<UserResponse>

    fun createUser(user: UserRequest): UserResponse

}

package de.ulfbiallas.experiments.gradlekotlinspring

data class UserRequest(
    val name: String,
    val email: String
)

data class UserResponse(
    val id: String,
    val name: String,
    val email: String
)

interface UserService {

    fun getUsers(): List<UserResponse>

    fun createUser(user: UserRequest): UserResponse

}

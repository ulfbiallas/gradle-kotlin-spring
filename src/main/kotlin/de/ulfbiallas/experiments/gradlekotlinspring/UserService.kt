package de.ulfbiallas.experiments.gradlekotlinspring

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
    @field:JsonProperty("username")
    val name: String,
    val email: String
);

interface UserService {

    fun getUsers(): List<User>

}

package de.ulfbiallas.experiments.gradlekotlinspring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val userService: UserService
) {

    @GetMapping("/users")
    fun getUsers(): List<UserResponse> = userService.getUsers()

    @GetMapping("/usernames")
    fun getUsernames(): List<String> {
        val users = userService.getUsers();
        return users.map { it.name }
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user:UserRequest): UserResponse {
        return userService.createUser(user)
    }

}

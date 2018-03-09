package de.ulfbiallas.experiments.gradlekotlinspring

import org.springframework.stereotype.Component

@Component
class UserServiceImpl: UserService {

    override fun getUsers(): List<User> = listOf(
        User("User1", "user1@users.test"),
        User("User2", "user2@users.test"),
        User("User3", "user3@users.test")
    );

}

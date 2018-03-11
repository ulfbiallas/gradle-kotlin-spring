package de.ulfbiallas.experiments.gradlekotlinspring

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="user")
data class UserEntity(

    @Id
    val id: String,

    val email: String,

    val name: String

) {
    companion object {
        fun toUserResponse(user: UserEntity): UserResponse {
            return UserResponse(user.id, user.email, user.name)
        }
    }
}

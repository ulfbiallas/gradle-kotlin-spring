package de.ulfbiallas.experiments.gradlekotlinspring

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito

class UserServiceImplTest {

    @Test
    fun `test get users`() {
        val userRepository: UserRepository = mock()
        Mockito.`when`(userRepository.findAll()).thenReturn(createMockUserEntities())

        val userService = UserServiceImpl(userRepository)
        val users = userService.getUsers()

        assertThat(users).hasSize(2)
        assertThat(users.get(0).id).isEqualTo("test-id-1")
        assertThat(users.get(0).email).isEqualTo("user1@email.test")
        assertThat(users.get(0).name).isEqualTo("test-user-1")
        assertThat(users.get(1).id).isEqualTo("test-id-2")
        assertThat(users.get(1).email).isEqualTo("user2@email.test")
        assertThat(users.get(1).name).isEqualTo("test-user-2")
    }

    @Test
    fun `test create user`() {
        val userRepository: UserRepository = mock()
        val captor = argumentCaptor<UserEntity>()
        Mockito.`when`(userRepository.save(captor.capture())).thenReturn(createMockUserEntities().get(0))

        val userRequest = UserRequest("user@email.test", "test-user");
        val userService = UserServiceImpl(userRepository)
        val user = userService.createUser(userRequest)

        val userEntity = captor.firstValue
        assertThat(userEntity.id.length).isEqualTo(36)
        assertThat(userEntity.email).isEqualTo("user@email.test")
        assertThat(userEntity.name).isEqualTo("test-user")
        assertThat(user.id).isEqualTo("test-id-1")
        assertThat(user.email).isEqualTo("user1@email.test")
        assertThat(user.name).isEqualTo("test-user-1")
    }

    private fun createMockUserEntities(): List<UserEntity> = listOf(
        UserEntity("test-id-1", "user1@email.test", "test-user-1"),
        UserEntity("test-id-2", "user2@email.test", "test-user-2")
    )
}

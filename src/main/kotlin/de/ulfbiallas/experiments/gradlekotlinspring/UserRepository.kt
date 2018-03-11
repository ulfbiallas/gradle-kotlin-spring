package de.ulfbiallas.experiments.gradlekotlinspring

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, String>

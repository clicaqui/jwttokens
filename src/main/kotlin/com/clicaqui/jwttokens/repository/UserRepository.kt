package com.clicaqui.jwttokens.repository

import com.clicaqui.jwttokens.model.Role
import com.clicaqui.jwttokens.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(
    private val encoder: PasswordEncoder
) {

    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            email = "user1@test.com",
            password = encoder.encode("user1"),
            role = Role.USER
        ),
        User(
            id = UUID.randomUUID(),
            email = "user2@test.com",
            password = encoder.encode("user2"),
            role = Role.ADMIN
        ),
        User(
            id = UUID.randomUUID(),
            email = "user3@test.com",
            password = encoder.encode("user3"),
            role = Role.USER
        ),
    )

    fun save(user: User): Boolean {

        val updated = user.copy(password = encoder.encode(user.password))
        return users.add(updated)
    }

    fun findByEmail(email: String): User? =
        users.firstOrNull { it.email == email }

    fun findAll(): List<User> =
        users

    fun findByUUID(uuid: UUID): User? =
        users.firstOrNull { it.id == uuid }

    fun deleteByUUID(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)

        return foundUser?.let {
            users.remove(it)
        } ?: false
    }
}
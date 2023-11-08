package com.userservice.domain.repository

import com.userservice.domain.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository : CoroutineCrudRepository<User, Long> {

    suspend fun findByEmail(email : String) : User?

}
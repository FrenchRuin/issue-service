package com.userservice.service

import com.userservice.domain.entity.User
import com.userservice.domain.repository.UserRepository
import com.userservice.exception.UserExistsException
import com.userservice.model.SignUpRequest
import com.userservice.utils.BCryptUtils
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(email)?.let {
                throw UserExistsException()
            }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )
            userRepository.save(user)
        }
    }
}
package com.userservice.utils

import com.auth0.jwt.interfaces.DecodedJWT
import com.userservice.config.JWTProperties
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.log

class JWTUtilsTest {


    private val logger = KotlinLogging.logger {}


    @Test
    fun createTokenTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gmail.com",
            profileUrl = "profile.jpg",
            username = "개발자"
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret"
        )


        val token = JWTUtils.createToken(jwtClaim,properties)
        assertNotNull(token)

        logger.info { "token : $token" }
    }


    // JWT 인증 확인 테스트
    @Test
    fun decodeTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gmail.com",
            profileUrl = "profile.jpg",
            username = "개발자"
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret"
        )

        val token = JWTUtils.createToken(jwtClaim,properties)

        val decodeJwt : DecodedJWT = JWTUtils.decode(token, properties.secret, properties.issuer)

        with(decodeJwt) {
            logger.info { "claims : $claims" }

            val userId = claims["userId"]!!.asLong()
            assertEquals(userId, jwtClaim.userId)

            val email = claims["email"]!!.asString()
            assertEquals(email, jwtClaim.email)

            val profileUrl = claims["profileUrl"]!!.asString()
            assertEquals(profileUrl, jwtClaim.profileUrl)

            val username = claims["username"]!!.asString()
            assertEquals(username, jwtClaim.username)
        }

    }
}
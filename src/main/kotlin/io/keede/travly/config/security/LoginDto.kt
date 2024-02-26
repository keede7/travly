package io.keede.travly.config.security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

/**
 * @author keede
 * Created on 2024/02/22
 */
data class LoginDto(
    private val email: String,
    private val password: String
) {
    fun toAuthenticationToken(): AbstractAuthenticationToken =
        UsernamePasswordAuthenticationToken(
            this.email,
            this.password
        )
}

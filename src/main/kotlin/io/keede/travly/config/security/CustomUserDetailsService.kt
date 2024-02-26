package io.keede.travly.config.security

import io.keede.travly.domains.user.service.adapter.UserReader
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

/**
 * @author keede
 * Created on 2024/02/22
 */
@Service
class CustomUserDetailsService(
    private val userReader: UserReader
) : UserDetailsService {

    override fun loadUserByUsername(
        email: String
    ): UserDetails {
        println(String.format("email : %s", email))

        return this.userReader.findAuthenticationByEmail(email)
    }
}
package io.keede.travly.config.security

import io.keede.travly.domains.user.service.adapter.UserReader
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * @author keede
 * Created on 2024/02/22
 */
class CustomUserDetailsService(
    private val userReader: UserReader
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails? {
        println(String.format("email : %s", email))

        this.userReader.findByEmail(email)

        return null
    }
}
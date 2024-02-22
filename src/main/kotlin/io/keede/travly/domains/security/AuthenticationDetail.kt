package io.keede.travly.domains.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 * @author keede
 * Created on 2024/02/22
 */
data class AuthenticationDetail(
    private val email: String,
    private val password: String,
    private val authorities: MutableCollection<out GrantedAuthority>?
) : User(email, password, authorities) {


}
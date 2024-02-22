package io.keede.travly.domains.user.entity

import io.keede.travly.config.entity.BaseEntity
import io.keede.travly.domains.security.AuthenticationDetail
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.security.core.authority.SimpleGrantedAuthority

/**
 * @author keede
 * Created on 2024/02/20
 */
@Entity
@Table(name = "user_t")
@AttributeOverride(name = "id", column = Column(name = "user_id"))
class User(
    @Column(name = "email", nullable = false, length = 50)
    private val email: String,
    @Column(name = "password", nullable = false)
    private val password: String
) : BaseEntity() {
    fun toAuthenticationDetail(): AuthenticationDetail {
        return AuthenticationDetail(
            this.email,
            this.password,
            listOf("ROLE_MEMBER").stream()
                .map { role -> SimpleGrantedAuthority(role) }
                .toList()
        )
    }
}

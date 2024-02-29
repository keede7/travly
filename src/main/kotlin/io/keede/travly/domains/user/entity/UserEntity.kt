package io.keede.travly.domains.user.entity

import io.keede.travly.config.entity.BaseEntity
import io.keede.travly.domains.security.AuthenticationDetail
import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority

/**
 * @author keede
 * Created on 2024/02/20
 */
@Entity
@Table(
    name = "user_t"
)
@AttributeOverride(
    name = "id",
    column = Column(name = "user_id")
)
class UserEntity(
    @Column(name = "email", nullable = false, length = 50)
    private val email: String,
    @Column(name = "password", nullable = false)
    private val password: String,
    @Enumerated(EnumType.STRING)
    private val role: UserRole,
) : BaseEntity() {

    constructor(
        email: String,
        password: String,
    ): this(
        email,
        password,
        UserRole.MEMBER,
    )

    fun toAuthenticationDetail(): AuthenticationDetail {
        return AuthenticationDetail(
            this.email,
            this.password,
            listOf(this.role.typeName)
                .stream()
                .map(::SimpleGrantedAuthority)
                .toList(),
        )
    }
}

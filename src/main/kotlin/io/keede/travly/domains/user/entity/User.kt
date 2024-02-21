package io.keede.travly.domains.user.entity

import io.keede.travly.config.entity.BaseEntity
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user_t")
@AttributeOverride(name = "id", column = Column(name = "user_id"))
class User(
    @Column(name = "email", nullable = false, length = 50)
    private val email: String,
    @Column(name = "password", nullable = false)
    private val password: String
) : BaseEntity()

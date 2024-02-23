package io.keede.travly.domains.user.entity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

/**
 * @author keede
 * Created on 2024/02/20
 */
interface UserRepository : JpaRepository<UserEntity, Long> {

    @Query(
        "SELECT user " +
        "FROM UserEntity user " +
        "WHERE user.isDelete = false " +
        "AND user.email = :email"
    )
    fun findByEmail(email: String): Optional<UserEntity>
}
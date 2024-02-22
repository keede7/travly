package io.keede.travly.domains.user.entity

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * @author keede
 * Created on 2024/02/20
 */
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}
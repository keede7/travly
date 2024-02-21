package io.keede.travly.domains.user.entity

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author keede
 * Created on 2024/02/20
 */
interface UserRepository : JpaRepository<User, Long>
package io.keede.travly.domains.user.service

import io.keede.travly.domains.user.entity.UserEntity
import io.keede.travly.domains.user.service.adapter.UserReader
import org.springframework.stereotype.Service

/**
 * @author keede
 * Created on 2024/02/20
 */
@Service
class UserQueryService(
    private val userReader: UserReader
) {
    fun getById(userId: Long): UserEntity = userReader.findById(userId)
}
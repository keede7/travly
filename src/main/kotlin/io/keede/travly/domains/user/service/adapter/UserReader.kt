package io.keede.travly.domains.user.service.adapter

import io.keede.travly.domains.user.entity.User
import io.keede.travly.domains.user.entity.UserRepository
import io.keede.travly.exception.service.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author keede
 * Created on 2024/02/20
 */
@Service
@Transactional(readOnly = true)
class UserReader(
    private val userRepository: UserRepository
) {

    fun findById(userId: Long): User {
        return userRepository.findById(userId)
            .orElseThrow { BusinessException() }
    }

}


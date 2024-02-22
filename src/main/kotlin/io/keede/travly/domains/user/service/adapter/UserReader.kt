package io.keede.travly.domains.user.service.adapter

import io.keede.travly.domains.user.entity.User
import io.keede.travly.domains.user.entity.UserRepository
import io.keede.travly.exception.service.BusinessException
import org.springframework.security.core.userdetails.UsernameNotFoundException
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
        return this.userRepository.findById(userId)
            .orElseThrow { BusinessException() }
    }

    fun findByEmail(email: String) {
        val userEntity: User = this.userRepository.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("등록한 정보를 찾을 수 없습니다.") }


    }

}


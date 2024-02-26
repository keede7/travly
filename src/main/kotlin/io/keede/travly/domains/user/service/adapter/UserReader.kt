package io.keede.travly.domains.user.service.adapter

import io.keede.travly.domains.security.AuthenticationDetail
import io.keede.travly.domains.user.entity.UserEntity
import io.keede.travly.domains.user.entity.UserRepository
import io.keede.travly.exception.service.BusinessException
import jakarta.annotation.PostConstruct
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author keede
 * Created on 2024/02/20
 */
@Service
@Transactional(readOnly = true)
class UserReader(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    fun findById(
        userId: Long
    ): UserEntity =
        this.userRepository.findById(userId)
            .orElseThrow { BusinessException() }


    fun findAuthenticationByEmail(
        email: String
    ): AuthenticationDetail =
        this.userRepository.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("등록한 정보를 찾을 수 없습니다.") }
            .toAuthenticationDetail()

    @PostConstruct
    @Transactional
    fun init() : Unit {
        this.userRepository.save(
            UserEntity(
                "test",
                this.passwordEncoder.encode("1212")
            )
        )
    }

}


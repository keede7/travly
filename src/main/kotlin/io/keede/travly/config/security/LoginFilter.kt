package io.keede.travly.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.context.DelegatingSecurityContextRepository
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository

/**
 * @author keede
 * Created on 2024/02/22
 */
class LoginFilter(
    private val objectMapper: ObjectMapper,
    private val authenticationManager: AuthenticationManager
) : AbstractAuthenticationProcessingFilter(
    "/api/login",
    authenticationManager
) {

    init {
        setSecurityContextRepository(
            DelegatingSecurityContextRepository(
                listOf(
                    HttpSessionSecurityContextRepository(),
                    RequestAttributeSecurityContextRepository()
                )
            )
        )
    }

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): Authentication {

        if (request.method.equals(HttpMethod.POST)) {
            throw AuthenticationServiceException("지원하지 않는 로그인 요청형식.");
        }

        val loginDto: LoginDto = this.objectMapper.readValue(request.inputStream, LoginDto::class.java)

        return this.authenticationManager.authenticate(
            loginDto.toAuthenticationToken()
        )
    }
}
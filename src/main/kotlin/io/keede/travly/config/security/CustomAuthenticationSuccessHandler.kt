package io.keede.travly.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import io.keede.travly.exception.ApiResponse
import io.keede.travly.exception.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

/**
 * @author kyh
 * Created on 2024/02/26
 */
class CustomAuthenticationSuccessHandler(
    private val objectMapper: ObjectMapper,
): AuthenticationSuccessHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {

        println("로그인 성공")

        response.status = HttpServletResponse.SC_OK
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "utf-8"

        response.writer.write(
            this.objectMapper.writeValueAsString(
                ErrorResponse.SUCCESS
            )
        )
    }
}
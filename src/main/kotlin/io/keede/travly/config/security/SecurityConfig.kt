package io.keede.travly.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


/**
 * @author keede
 * Created on 2024/02/21
 */
@Configuration
class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        val authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)

        authenticationManagerBuilder.userDetailsService(this.userDetailsService)
        val authenticationManager = authenticationManagerBuilder
            .build()

        http
            .authenticationManager(authenticationManager)

        http
            .formLogin { formLogin ->
                formLogin.disable()
            }
            .csrf { csrf ->
                csrf.disable()
            }
            .authorizeHttpRequests { authorizeRequest ->
                authorizeRequest
                    .requestMatchers("/api/**").authenticated()
                    .requestMatchers("/h2-console/**").permitAll()
                    .anyRequest()
                    .permitAll()
            }
            .addFilterAt(
                this.loginFilter(authenticationManager),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .headers { header ->
                header.frameOptions { frameOption ->
                    frameOption.sameOrigin()
                }
            }

        return http.build();
    }

    fun loginFilter(
        authenticationManager: AuthenticationManager
    ): LoginFilter =
        LoginFilter(
            this.objectMapper,
            authenticationManager,
            CustomAuthenticationSuccessHandler(
                this.objectMapper
            )
        )


}
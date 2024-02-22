package io.keede.travly.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain


/**
 * @author keede
 * Created on 2024/02/21
 */
@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        val authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder::class.java)

        val authenticationManager = authenticationManagerBuilder.build();
        http.authenticationManager(authenticationManager)

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
            .headers { header ->
                header.frameOptions { frameOption ->
                    frameOption.sameOrigin()
                }
            }

        return http.build();
    }
}
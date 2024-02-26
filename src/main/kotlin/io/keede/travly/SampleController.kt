package io.keede.travly

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController {

    @GetMapping("/authentication")
    fun authentication(
        httpServletRequest:HttpServletRequest
    ) : Unit {
        println("httpServletRequest.session = ${httpServletRequest.session}")
        println("SecurityContextHolder.getContext().authentication = ${SecurityContextHolder.getContext().authentication}")
    }

    @GetMapping("/api/test")
    fun test(): Unit {
        println("인증완료.")
        println("SecurityContextHolder.getContext().authentication = ${SecurityContextHolder.getContext().authentication}")
    }


}
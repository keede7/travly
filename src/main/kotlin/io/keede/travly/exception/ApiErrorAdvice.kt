package io.keede.travly.exception

import io.keede.travly.exception.service.BusinessException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author keede
 * Created on 2024/02/20
 */
@RestControllerAdvice
class ApiErrorAdvice {

    @ExceptionHandler( BusinessException::class )
    fun handleServiceException(
        exception: BusinessException
    ) = exception.toApiResponse()

}
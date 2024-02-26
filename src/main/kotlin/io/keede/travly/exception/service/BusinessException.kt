package io.keede.travly.exception.service

import io.keede.travly.exception.ApiResponse
import io.keede.travly.exception.ErrorResponse

/**
 * @author keede
 * Created on 2024/02/20
 */
class BusinessException : RuntimeException {

    private val errorResponse: ErrorResponse

    constructor() : super(ErrorResponse.COMMON.message) {
        this.errorResponse = ErrorResponse.COMMON
    }

    constructor(
        errorResponse: ErrorResponse
    ) : super(
        errorResponse.message
    ) {
        this.errorResponse = errorResponse
    }

    constructor(
        errorResponse: ErrorResponse,
        message: String?
    ) : super(
        errorResponse.message
    ) {
        this.errorResponse = errorResponse
        println(message)
    }

    fun toApiResponse(): ApiResponse<ErrorResponse> =
        ApiResponse(
            this.errorResponse
        )
}
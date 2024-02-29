package io.keede.travly.exception.service

import io.keede.travly.exception.ApiResponse
import io.keede.travly.exception.DetailResponse

/**
 * @author keede
 * Created on 2024/02/20
 */
class BusinessException : RuntimeException {

    private val detailResponse: DetailResponse

    constructor(

    ) : super(
        DetailResponse.COMMON.message
    ) {
        this.detailResponse = DetailResponse.COMMON
    }

    constructor(
        detailResponse: DetailResponse
    ) : super(
        detailResponse.message
    ) {
        this.detailResponse = detailResponse
    }

    constructor(
        detailResponse: DetailResponse,
        message: String
    ) : super(
        detailResponse.message
    ) {
        this.detailResponse = detailResponse
        println(message)
    }

    fun toApiResponse(): ApiResponse<DetailResponse> =
        ApiResponse(
            this.detailResponse
        )
}
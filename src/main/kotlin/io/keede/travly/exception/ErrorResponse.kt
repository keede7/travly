package io.keede.travly.exception

/**
 * @author kyh
 * Created on 2024/02/20
 */
enum class ErrorResponse(
    val code: Int,
    val message: String
) {

    COMMON(1000, "요청에 실패 했습니다.")

}
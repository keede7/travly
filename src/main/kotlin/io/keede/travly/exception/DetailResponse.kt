package io.keede.travly.exception

/**
 * @author kyh
 * Created on 2024/02/20
 */
enum class DetailResponse(
    val code: Int,
    val message: String
) {

    SUCCESS(200,"요청 성공"),
    COMMON(1000, "요청에 실패 했습니다.")

}
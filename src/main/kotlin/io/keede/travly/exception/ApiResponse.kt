package io.keede.travly.exception


/**
 * @author keede
 * Created on 2024/02/20
 */
class ApiResponse<T : ErrorResponse>(
    errors: T
) {

    private val code: Int
    private val message: String

    init {
        this.code = errors.code
        this.message = errors.message
    }
}


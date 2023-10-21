package devissueservice.issueservice.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)


// NotFound 에러 커스텀 처리
data class NotFoundException(
    override val message: String,
) : ServerException(404, message)

// 인증 정보 관련 에러 커스텀 처리
data class UnauthorizedException(
    override val message: String = "인증 정보가 잘못되었습니다",
) : ServerException(401, message)
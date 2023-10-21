package devissueservice.issueservice.domain.enums

enum class IssueStatus {
    // 업무상태
    TODO,   // 해야할일
    IN_PROGRESS,    // 진행중
    RESOLVED; // 해결됨

    companion object {
        operator fun invoke(status: String) = valueOf(status.uppercase())
    }

}

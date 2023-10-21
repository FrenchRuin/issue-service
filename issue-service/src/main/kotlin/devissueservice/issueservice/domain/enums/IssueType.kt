package devissueservice.issueservice.domain.enums

enum class IssueType {
    // 업무타입
    BUG,    // 버그
    TASK;   // 일

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }

}

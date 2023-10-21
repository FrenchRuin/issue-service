package devissueservice.issueservice.domain.enums

enum class IssuePriority {
    // 중요도
    LOW,  //낮음
    MEDIUM,  // 중간
    HIGH;   //높음


    companion object {
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }

}

package devissueservice.issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import devissueservice.issueservice.domain.Issue
import devissueservice.issueservice.domain.enums.IssuePriority
import devissueservice.issueservice.domain.enums.IssueStatus
import devissueservice.issueservice.domain.enums.IssueType
import java.time.LocalDateTime

// 이슈 엔티티 request
data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

// 이슈 엔티티 response
data class IssueResponse(
    val id: Long,
    val summary: String,
    val description: String,
    val userId: Long,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
) {
    companion object {
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = id!!,
                    summary = summary,
                    description = description,
                    userId = userId,
                    type = type,
                    priority = priority,
                    status = status,
                    createdAt = createdAt,
                    updatedAt = updatedAt,
                )
            }
    }
}


package devissueservice.issueservice.service

import devissueservice.issueservice.domain.Issue
import devissueservice.issueservice.domain.IssueRepository
import devissueservice.issueservice.model.IssueRequest
import devissueservice.issueservice.model.IssueResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class IssueService(
    private val issueRepository: IssueRepository

) {

    @Transactional
    fun create(userId: Long, request: IssueRequest) : IssueResponse {

        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )

        return IssueResponse(issueRepository.save(issue))
    }

}
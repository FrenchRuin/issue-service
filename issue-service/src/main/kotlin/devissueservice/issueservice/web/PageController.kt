package devissueservice.issueservice.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController {

    @GetMapping(value = ["/", "/index"])
    fun index() = "index"

    @GetMapping("/issueapp")
    fun issueapp() = "issueapp"

    @GetMapping("/signup")
    fun signup() = "signup"
}
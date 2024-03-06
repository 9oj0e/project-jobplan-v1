package shop.mtcoding.projectjobplan.apply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projectjobplan.user.User;

@RequiredArgsConstructor
@Controller
public class ApplyController {
    private final HttpSession session;
    private final ApplyRepository applyRepository;

    // 지원자 합격/불합격 처리
    @PostMapping("/apply/update")
    public String update(Integer status, Integer resumeId, Integer boardId) {
        User user = (User) session.getAttribute("sessionUser");
        applyRepository.update(status, resumeId, boardId);

        return "redirect:/user/" + user.getId();
    }
}

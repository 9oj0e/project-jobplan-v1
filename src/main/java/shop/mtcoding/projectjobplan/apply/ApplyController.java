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
    @PostMapping("/apply/{applyId}/update")
    public String update(ApplyRequest.UpdateDTO requestDTO) {

        User user = (User) session.getAttribute("sessionUser");
        System.out.println("영향 받은 행 : " + applyRepository.update(requestDTO));

        return "redirect:/board/" + user.getId();
    }
}

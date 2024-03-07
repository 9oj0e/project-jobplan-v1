package shop.mtcoding.projectjobplan.subscribe;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projectjobplan.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SubscribeController {
    private final HttpSession session;
    private final SubscribeRepository subscribeRepository;

    @GetMapping("/user/{sessionUserId}/subscription")
    public String subscription( // 구독 목록
                                @PathVariable int sessionUserId,
                                HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        if (user.getIsEmployer() == true) { // 기업 유저 (이력서 목록)
            List<SubscribeResponse.ToUserDTO> subscribeList = subscribeRepository.findByUserId(sessionUserId);
            request.setAttribute("subscribeList", subscribeList);
        } else { // 개인 유저 (공고 목록)
            List<SubscribeResponse.ToEmployerDTO> subscribeList = subscribeRepository.findByEmployerId(sessionUserId);
            request.setAttribute("subscribeList", subscribeList);
        }

        return "/user/subscription"; // view 만들기
    }

    @PostMapping("/board/{boardId}/subscribe")
    public String subscribeBoard( // 공고 구독
                                  @PathVariable int boardId,
                                  SubscribeRequest.UploadByBoardIdDTO requestDTO) {
        subscribeRepository.uploadByBoardId(boardId, requestDTO);

        return "redirect:/board/" + boardId;
    }

    @PostMapping("/resume/{resumeId}/subscribe")
    public String subscribeResume( // 이력서 구독
                                   @PathVariable int resumeId,
                                   SubscribeRequest.UploadByResumeIdDTO requestDTO) {
        subscribeRepository.uploadByResumeId(resumeId, requestDTO);

        return "redirect:/resume/" + resumeId;
    }

    @PostMapping("/board/{boardId}/unsubscribe")
    public String unsubscribeBoard( // 공고 구독 취소
                                    @PathVariable int boardId) {
        subscribeRepository.deleteByBoardId(boardId);

        return "";
    }

    @PostMapping("/resume/{resumeId}/unsubscribe")
    public String unsubscribeResume( // 이력서 구독 취소
                                     @PathVariable int resumeId) {
        subscribeRepository.deleteByResumeId(resumeId);

        return "";
    }
}

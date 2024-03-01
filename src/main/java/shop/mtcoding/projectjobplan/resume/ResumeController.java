package shop.mtcoding.projectjobplan.resume;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.projectjobplan.board.BoardResponse;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ResumeController {
    private final ResumeRepository resumeRepository;


    @GetMapping("/resume/main")
    public String main() {
        return "/resume/main";
    }
    @GetMapping("/resume/listings")
    public String listings(HttpServletRequest request) {
        // 기업 메인 페이지
        List<ResumeResponse.ResumeAndUserDTO> responseDTO = resumeRepository.findByResumeAndUser();

        List<ResumeResponse.ResumeAndUserDTO> resumeList = new ArrayList<>();

        for (ResumeResponse.ResumeAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                resumeList.add(dto);
            }
        }
        request.setAttribute("resumeList", resumeList);

        return "/resume/listings";
    }
    @GetMapping("/resume/uploadForm")
    public String uploadForm() {
        return "/resume/uploadForm";
    }
    @GetMapping("/resume/1/updateForm")
    public String updateForm() {
        return "/resume/updateForm";
    }
    @GetMapping("/resume/1")
    public String detail() {
        return "/resume/detail";
    }
}

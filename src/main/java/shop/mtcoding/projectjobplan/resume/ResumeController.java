package shop.mtcoding.projectjobplan.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
    @GetMapping("/resume/main")
    public String main() {
        return "/resume/main";
    }
    @GetMapping("/resume/listings")
    public String listings() { // 기업 메인 페이지
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

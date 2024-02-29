package shop.mtcoding.projectjobplan.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user/joinSelection")
    public String joinSelection() {
        return "/user/joinSelection";
    }
    @GetMapping("/user/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }
    @GetMapping("/user/employer/joinForm")
    public String employerJoinForm() {
        return "/user/employer/joinForm";
    }
    @GetMapping("/user/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }
    @GetMapping("/user/1")
    public String profile() {
        return "/user/profile";
    }
    @GetMapping("/user/employer/profile")
    public String employerProfile() {
        return "/user/profile";
    }
    @GetMapping("/user/1/updateForm")
    public String updateForm() {
        return "/user/updateForm";
    }
    @GetMapping("/user/employer/1/updateForm")
    public String employerUpdateForm() {
        return "/user/employer/updateForm";
    }
}

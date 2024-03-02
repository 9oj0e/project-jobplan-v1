package shop.mtcoding.projectjobplan.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final HttpSession session;

    @GetMapping("/user/joinSelection")
    public String joinSelection() {
        return "/user/joinSelection";
    }

    @GetMapping("/user/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/employer/joinForm")
    public String employerJoinForm() {
        return "/employer/joinForm";
    }

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        System.out.println(requestDTO);
        // todo 유효성 검사 (아이디 중복) 필요

        userRepository.save(requestDTO);
        return "redirect:/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        System.out.println(requestDTO);

        User user = userRepository.findByUsernameAndPassword(requestDTO); // 암호화 안됨
        if (user == null)
            return "401";
        else
            session.setAttribute("sessionUser", user);
        return "redirect:/";
    }

    @GetMapping("/user/1")
    public String profile() {
        return "/user/profile";
    }

    @GetMapping("/employer/1")
    public String employerProfile() {
        return "/employer/profile";
    }

    @GetMapping("/user/1/updateForm")
    public String updateForm() {
        return "/user/updateForm";
    }

    @GetMapping("/employer/1/updateForm")
    public String employerUpdateForm() {
        return "/employer/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

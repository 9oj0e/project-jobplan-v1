package shop.mtcoding.projectjobplan.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final ResumeRepository resumeRepository;
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

    @GetMapping("/user/{id}")
    public String profile(HttpServletRequest request, @PathVariable int id) {
        User user = userRepository.findById(id);
        request.setAttribute("user", user);

        Resume resume = resumeRepository.findById(id);
        request.setAttribute("resume", resume);

        // 기업 회원 인지..
        if (user.getIsEmployer())
            return "/employer/profile";
        else
            return "/user/profile";
    }

    @GetMapping("/user/{id}/updateForm")
    public String updateForm(HttpServletRequest request, @PathVariable int id) {
        User user = userRepository.findById(id);
        request.setAttribute("user", user);

        // 기업 회원인지..
        if (user.getIsEmployer())
            return "/employer/updateForm";
        else
            return "/user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

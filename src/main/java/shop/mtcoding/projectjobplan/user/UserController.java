package shop.mtcoding.projectjobplan.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projectjobplan.board.Board;
import shop.mtcoding.projectjobplan.board.BoardRepository;
import shop.mtcoding.projectjobplan.pic.Pic;
import shop.mtcoding.projectjobplan.pic.PicRepository;
import shop.mtcoding.projectjobplan.pic.PicRequest;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final ResumeRepository resumeRepository;
    private final BoardRepository boardRepository;
    private final HttpSession session;
    private final PicRepository picRepository;

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
    public String join(HttpServletRequest request, UserRequest.JoinDTO requestDTO) {
        System.out.println(requestDTO);
        // 1. 유효성 검사

        // 2. 동일 username 체크
        User user = userRepository.findByUsername(requestDTO.getUsername());
        if (user == null){
            // 3. model에 위임하기
            userRepository.save(requestDTO);
            return "redirect:/loginForm";
        } else {
            request.setAttribute("status", "400");
            request.setAttribute("msg", "중복된 아이디입니다.");
            return "error";
        }
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, UserRequest.LoginDTO requestDTO) {
        System.out.println(requestDTO);

        User user = userRepository.findByUsernameAndPassword(requestDTO); // 암호화 안됨
        if (user == null) {
            request.setAttribute("status", 401);
            request.setAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다.");
            return "error";
        }
        else {
            session.setAttribute("sessionUser", user);
        }
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String profile(HttpServletRequest request, @PathVariable int id) {
        User user = userRepository.findById(id);
        request.setAttribute("user", user);


        // board 조회

        // 기업 회원 인지..
        if (user.getIsEmployer()) {
            List<Board> boardList = boardRepository.findByUserId(user.getId());
            request.setAttribute("boardList", boardList);
            return "/employer/profile";
        }
        else {
            List<Resume> resumeList = resumeRepository.findByUserId(user.getId());
            request.setAttribute( "resumeList", resumeList);
            return "/user/profile";
        }


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

    @PostMapping("/user/{id}/update")
    public String update(@PathVariable int id, UserRequest.UpdateDTO requestDTO, HttpServletRequest request) {
        request.setAttribute("user", userRepository.updateById(requestDTO, id));
        return "redirect:/user/"+id;
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

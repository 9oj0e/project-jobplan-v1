package shop.mtcoding.projectjobplan.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projectjobplan.apply.ApplyRepository;
import shop.mtcoding.projectjobplan.apply.ApplyResponse;
import shop.mtcoding.projectjobplan.board.Board;
import shop.mtcoding.projectjobplan.board.BoardRepository;
import shop.mtcoding.projectjobplan.pic.Pic;
import shop.mtcoding.projectjobplan.pic.PicRepository;
import shop.mtcoding.projectjobplan.pic.PicRequest;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.skill.Skill;
import shop.mtcoding.projectjobplan.skill.SkillRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserRepository userRepository;
    private final ResumeRepository resumeRepository;
    private final BoardRepository boardRepository;
    private final ApplyRepository applyRepository;
    private final HttpSession session;
    private final PicRepository picRepository;
    private final SkillRepository skillRepository;

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
        if (user == null) {
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
        } else {
            session.setAttribute("sessionUser", user);
        }


        try {
            if (picRepository.findImg() != null) {
                String imgFilename = picRepository.findImg();
                request.getSession().setAttribute("userPic2", imgFilename);
                return "redirect:/";
            }

        } catch (Exception e) {
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping({"/user/{sessionUserId}", "/user/{sessionUserId}/{boardId}"})
    public String profile(HttpServletRequest request,
                          @PathVariable int sessionUserId,
                          @PathVariable(required = false) Integer boardId) {
        User user = userRepository.findById(sessionUserId);

        request.setAttribute("user", user);

        // 지원 삭제 (개인, 지원 취소)

        // 기업 회원 인지..
        if (user.getIsEmployer()) {
            // 내가 쓴 공고 조회
            List<Board> boardList = boardRepository.findByEmployerId(user.getId());
            request.setAttribute("boardList", boardList);
            if (boardId == null) {
                // 지원자 현황 조회
                List<ApplyResponse.ToEmployerDTO> applicationList = applyRepository.findByEmployerId(sessionUserId);
                request.setAttribute("applicationList", applicationList);
            } else {
                // 지원자 현황 조회
                List<ApplyResponse.ToEmployerDTO> applicationList = applyRepository.findByBoardId(boardId);
                request.setAttribute("applicationList", applicationList);
            }

            return "/employer/profile";
        } else {
            // 지원 현황 조회
            List<Resume> resumeList = resumeRepository.findByUserId(user.getId());
            request.setAttribute("resumeList", resumeList);
            List<ApplyResponse.ToUserDTO> applyList = applyRepository.findByUserId(sessionUserId);
            request.setAttribute("applyList", applyList);

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

    @PostMapping("/user/{sessionUserId}/update")
    public String update(@PathVariable int sessionUserId, UserRequest.UpdateDTO requestDTO, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");

        if (user.getIsEmployer() == true) {
            skillRepository.uploadByEmployerId(requestDTO.getSkill(), sessionUserId);
        } else {
            skillRepository.uploadByUserId(requestDTO.getSkill(), sessionUserId);
        }
        request.setAttribute("user", userRepository.updateById(requestDTO, sessionUserId));

        return "redirect:/user/" + sessionUserId;
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

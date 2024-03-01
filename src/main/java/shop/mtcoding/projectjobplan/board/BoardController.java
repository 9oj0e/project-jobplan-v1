package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final UserRepository userRepository;

    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
        List<User> userList = userRepository.findAll();
        request.setAttribute("userList", userList);

        List<User> employerList = new ArrayList<>();

        for (User user : userList) {
            if (user.isEmployer()) {
                employerList.add(user);
            }
        }
        request.setAttribute("userList", employerList);

        return "/index";
}
    @GetMapping("/board/listings")
    public String listings() {
        return "/board/listings";
    }
    @GetMapping("/board/main")
    public String main() {
        return "/board/main";
    }
    @GetMapping("/board/1")
    public String detail() {
        // 1번 조회
        // 1번 상자담고
        // 1번 view에 뿌리기
        return "/board/detail";
    }
    @GetMapping("/board/uploadForm")
    public String uploadForm() {
        return "/board/uploadForm";
    }
    @GetMapping("/board/1/updateForm")
    public String updateForm() {
        return "/board/updateForm";
    }
}

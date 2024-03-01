package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final UserRepository userRepository;

    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
        List<User> userList = userRepository.findAll();
        request.setAttribute("userList", userList);

//        try {
//            if (userList.get(0).isEmployer()) {
//                request.setAttribute("userList", userList);
//            }
//            // else 절이 없어도 됩니다. 첫 번째 사용자가 고용주가 아닐 경우에는 아무런 처리를 하지 않고, 아래의 "/index"를 리턴하게 됩니다.
//        } catch (Exception e) {
//            return null;
//        }
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

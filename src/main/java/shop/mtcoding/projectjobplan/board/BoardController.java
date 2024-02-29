package shop.mtcoding.projectjobplan.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"/", "/board"})
    public String index() {
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
        // 1번 추력
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

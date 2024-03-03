package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projectjobplan._core.PagingUtil;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardRepository boardRepository;
    private final HttpSession session;

    @PostMapping("/board/{id}/upload")
    public String upload(@PathVariable int id, BoardRequest.SaveDTO requestDTO) {
        boardRepository.save(requestDTO, id);

        return "/employer/" + id;
    }

    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
        List<BoardResponse.boardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb();

        List<BoardResponse.boardAndUserDTO> employerList = new ArrayList<>();

        for (BoardResponse.boardAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                employerList.add(dto);
            }
        }
        request.setAttribute("employerList", employerList);

        return "/index";
    }

    @GetMapping("/board/listings")
    public String listings(HttpServletRequest request, @RequestParam(defaultValue = "0") int page) {
        List<Board> boardList = boardRepository.findAll(page);
        request.setAttribute("boardList", boardList);
        request.setAttribute("nextPage", page + 1);
        request.setAttribute("prevPage", page - 1);
        int totalPage = boardRepository.count();
        request.setAttribute("isFirst", PagingUtil.isFirst(page));
        request.setAttribute("isLast", PagingUtil.isLast(page, totalPage));
        request.setAttribute("pageList", PagingUtil.getPageList(PagingUtil.getTotalPageCount(totalPage)));

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

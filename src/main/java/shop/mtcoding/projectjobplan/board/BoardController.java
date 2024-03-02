package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class BoardController {


    private final BoardRepository boardRepository ;

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
    public String listings(HttpServletRequest request,@RequestParam(defaultValue = "1")int page) {
        List<BoardResponse.boardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb(page);
        List<BoardResponse.boardAndUserDTO> employerList = new ArrayList<>();
        for (BoardResponse.boardAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                employerList.add(dto);
            }
        }
        request.setAttribute("employerList", employerList);


        int currentPage = page;
        int nextPage = currentPage + 1;
        int prevPage = currentPage - 1;

        request.setAttribute("nextPage", nextPage);
        request.setAttribute("prevPage", prevPage);


        boolean first = (currentPage == 1 ? true : false);
        request.setAttribute("first", first);

        int totalPage = boardRepository.countIsEmployerTrue();

        int totalCount = (totalPage % 10 == 0) ? (totalPage / 10) : (totalPage / 10 + 1);
        boolean last = (currentPage == totalCount);
        List<Integer> numberList = new ArrayList<>();
        int allPage;
        if (totalPage % 10 == 0) {
            allPage = totalCount - 1;
            for (int i = 1; i <= allPage; i++) {
                numberList.add(i);
                request.setAttribute("numberList", numberList);
            }
        } else if (totalPage % 10 != 0) {
            allPage = totalCount;
            for (int i = 1; i <= allPage; i++) {
                numberList.add(i);
                request.setAttribute("numberList", numberList);
            }

        }
        request.setAttribute("last", last);
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

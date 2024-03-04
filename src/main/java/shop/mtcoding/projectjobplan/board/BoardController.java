package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan._core.PagingUtil;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardRepository boardRepository ;
    private final HttpSession session;

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.UpdateDTO requestDTO){
        // todo 유효성 검사, 권한 검사
        boardRepository.updateById(requestDTO, id);

        return "redirect:/board/" + id;
    }

    @PostMapping("/board/{id}/upload")
    public String upload(@PathVariable int id, BoardRequest.SaveDTO requestDTO){
        // todo 유효성 검사, 권한 검사
        boardRepository.save(requestDTO, id);

        return "redirect:/board/" + id;
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
    public String listings(HttpServletRequest request,@RequestParam(defaultValue = "1")int page) {
        List<BoardResponse.boardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb(page);
        List<BoardResponse.boardAndUserDTO> employerList = new ArrayList<>();
        for (BoardResponse.boardAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                employerList.add(dto);
            }
        }
        request.setAttribute("employerList", employerList);
        // 페이지네이션
        int totalPage = boardRepository.countIsEmployerTrue();
        PagingUtil paginationHelper = new PagingUtil(totalPage, page);

        request.setAttribute("nextPage", paginationHelper.getNextPage());
        request.setAttribute("prevPage", paginationHelper.getPrevPage());
        request.setAttribute("first", paginationHelper.isFirst());
        request.setAttribute("last", paginationHelper.isLast());
        request.setAttribute("numberList", paginationHelper.getNumberList());

        return "/board/listings";
        }

    @GetMapping("/board/main")
    public String main() {
        return "/board/main";
    }
    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        BoardResponse.BoardDetailDTO boardDetailDTO= boardRepository.detail(id);
        boardDetailDTO.isBoardOwner(sessionUser);

        request.setAttribute("boardDetail", boardDetailDTO);

        return "/board/detail";
    }
    @GetMapping("/board/uploadForm")
    public String uploadForm() {
        return "/board/uploadForm";
    }
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, HttpServletRequest request) {
        Board board = boardRepository.findById(id);
        request.setAttribute("board", board);

        return "/board/updateForm";
    }
}

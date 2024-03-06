package shop.mtcoding.projectjobplan.board;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan._core.PagingUtil;
import shop.mtcoding.projectjobplan.apply.ApplyRepository;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.skill.SkillRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardRepository boardRepository;
    private final SkillRepository skillRepository;
    private final HttpSession session;
  
    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
        List<BoardResponse.BoardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb();
        List<BoardResponse.BoardAndUserDTO> employerList = new ArrayList<>();

        for (BoardResponse.BoardAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                employerList.add(dto);
            }
        }
        request.setAttribute("employerList", employerList);

        return "/index";
    }

    @GetMapping("/board/main")
    public String main() {
        return "/board/main";
    }

    @GetMapping("/board/listings")
    public String listings(HttpServletRequest request, @RequestParam(defaultValue = "1") int page) {
        List<BoardResponse.BoardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb(page);
        List<BoardResponse.BoardAndUserDTO> employerList = new ArrayList<>();
        for (BoardResponse.BoardAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()) {
                employerList.add(dto);
            }
        }
        request.setAttribute("employerList", employerList);
        // 페이지네이션 모듈
        int totalPage = boardRepository.countIsEmployerTrue();
        PagingUtil paginationHelper = new PagingUtil(totalPage, page);

        request.setAttribute("nextPage", paginationHelper.getNextPage());
        request.setAttribute("prevPage", paginationHelper.getPrevPage());
        request.setAttribute("first", paginationHelper.isFirst());
        request.setAttribute("last", paginationHelper.isLast());
        request.setAttribute("numberList", paginationHelper.getNumberList());

        return "/board/listings";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        BoardResponse.BoardDetailDTO boardDetailDTO = boardRepository.detail(id);
        boardDetailDTO.isBoardOwner(sessionUser);

        request.setAttribute("boardDetail", boardDetailDTO);

        return "/board/detail";
    }

    @PostMapping("/board/upload")
    public String upload(BoardRequest.SaveDTO requestDTO){

        User sessionUser = (User) session.getAttribute("sessionUser");

        // todo 유효성 검사, 권한 검사
        int boardId = boardRepository.save(requestDTO, sessionUser.getId());

        for (String skill : requestDTO.getSkill()){
            skillRepository.saveBoard(skill, boardId);
        }

        return "redirect:/user/" + sessionUser.getId();
    }
  
    @GetMapping("/board/uploadForm")
    public String uploadForm() {
        return "/board/uploadForm";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.UpdateDTO requestDTO) {
        boardRepository.updateById(requestDTO, id);

        return "redirect:/board/" + id;
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, HttpServletRequest request) {
        Board board = boardRepository.findById(id);
        request.setAttribute("board", board);

        return "/board/updateForm";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable int id, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        Board board = boardRepository.findById(id);
        if (board == null) {
            request.setAttribute("msg", "해당 아이디를 찾을 수 없습니다.");
            request.setAttribute("status", "404");
            return "/error";
        } else {
            boardRepository.deleteById(id);
            return "redirect:/user/" + user.getId();
        }
    }
}

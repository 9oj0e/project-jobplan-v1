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
import shop.mtcoding.projectjobplan.skill.Skill;
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
    public String listings(HttpServletRequest request, @RequestParam(defaultValue = "1") int page,@RequestParam(value = "keyword", required = false) String keyword) {

            if(keyword!=null){
            List<BoardResponse.BoardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb(page,keyword);
            List<BoardResponse.BoardAndUserDTO> employerList = new ArrayList<>();
            for (BoardResponse.BoardAndUserDTO dto : responseDTO) {
                if (dto.isEmployer()) {
                    employerList.add(dto);
                }
                request.setAttribute("employerList", employerList);

            }
            // 페이지네이션 모듈
            int totalPage = boardRepository.countIsEmployerTrue();
            PagingUtil paginationHelper = new PagingUtil(totalPage, page);

            request.setAttribute("nextPage", paginationHelper.getNextPage());
            request.setAttribute("prevPage", paginationHelper.getPrevPage());
            request.setAttribute("first", paginationHelper.isFirst());
            request.setAttribute("last", paginationHelper.isLast());
            request.setAttribute("numberList", paginationHelper.getNumberList());

            return "/board/listings";
        }else {
            List<BoardResponse.BoardAndUserDTO> responseDTO = boardRepository.findByBoardtbAndUsertb(page);
            List<BoardResponse.BoardAndUserDTO> employerList = new ArrayList<>();
            for (BoardResponse.BoardAndUserDTO dto : responseDTO) {
                if (dto.isEmployer()) {
                    employerList.add(dto);
                }
                request.setAttribute("employerList", employerList);

            }
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


    }

    @GetMapping("/board/{boardId}")
    public String detail(@PathVariable int boardId, HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        BoardResponse.BoardDetailDTO boardDetailDTO = boardRepository.detail(boardId);
        boardDetailDTO.isBoardOwner(sessionUser);
        List<Skill> skillBoardList = skillRepository.findByBoardId(id);

        request.setAttribute("boardDetail", boardDetailDTO);
        request.setAttribute("skillBoardList",skillBoardList);
        return "/board/detail";
    }

    @PostMapping("/board/upload")
    public String upload(BoardRequest.SaveDTO requestDTO){
        User sessionUser = (User) session.getAttribute("sessionUser");
         Integer boardId = boardRepository.save(requestDTO, sessionUser.getId());

       List<String> skills = requestDTO.getSkill();
       for(String skill : skills){
           skillRepository.saveByEmployerId(skill,sessionUser.getId(),boardId);
       }


        return "redirect:/user/" + sessionUser.getId();
    }
  
    @GetMapping("/board/uploadForm")
    public String uploadForm() {
        return "/board/uploadForm";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.UpdateDTO requestDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        boardRepository.updateById(requestDTO, id);

        skillRepository.updateSkillByBoardId(requestDTO.getSkill(),id,sessionUser.getId());


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

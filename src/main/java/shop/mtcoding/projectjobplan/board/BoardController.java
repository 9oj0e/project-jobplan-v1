package shop.mtcoding.projectjobplan.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan._core.PagingUtil;
import shop.mtcoding.projectjobplan.apply.ApplyRepository;
import shop.mtcoding.projectjobplan.rating.RatingRepository;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.skill.Skill;
import shop.mtcoding.projectjobplan.skill.SkillRepository;
import shop.mtcoding.projectjobplan.subscribe.Subscribe;
import shop.mtcoding.projectjobplan.subscribe.SubscribeRepository;
import shop.mtcoding.projectjobplan.user.User;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final HttpSession session;
    private final BoardRepository boardRepository;
    private final SkillRepository skillRepository;
    private final RatingRepository ratingRepository;
    private final SubscribeRepository subscribeRepository;

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
        request.setAttribute("boardDetail", boardDetailDTO);

        Double avgRate = ratingRepository.findAvgRateBySubjectId(boardDetailDTO.getEmployerId()); // cyj-030809
        request.setAttribute("avgRate", avgRate);

        if (sessionUser != null) {
            Subscribe subscribe = subscribeRepository.findAllByUserIdBoardId(sessionUser.getId(), boardId);
            if (subscribe != null) {
                request.setAttribute("subscribe", subscribe);
            }
        }
        List<Skill> skillBoardList = skillRepository.findByBoardId(boardId); // todo : boardSkillList로 바꾸기

        request.setAttribute("boardDetail", boardDetailDTO);
        request.setAttribute("skillBoardList",skillBoardList);
      
        return "/board/detail";
    }

    @PostMapping("/board/upload")
    public String upload(BoardRequest.UploadDTO requestDTO){
       User sessionUser = (User) session.getAttribute("sessionUser");
       Integer boardId = boardRepository.upload(requestDTO, sessionUser.getId());
       List<String> skills = requestDTO.getSkill();
      
       for(String skill : skills){
           skillRepository.uploadByEmployerId(skill,sessionUser.getId(),boardId);
       }
        return "redirect:/user/" + sessionUser.getId();
    }
  
    @GetMapping("/board/uploadForm")
    public String uploadForm() {
      
        return "/board/uploadForm";
    }

    @PostMapping("/board/{boardId}/update")
    public String update(@PathVariable int boardId, BoardRequest.UpdateDTO requestDTO) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        boardRepository.updateById(requestDTO, boardId);
        skillRepository.updateByBoardId(requestDTO.getSkill(),boardId,sessionUser.getId());

        return "redirect:/board/" + boardId;
    }

    @GetMapping("/board/{boardId}/updateForm")
    public String updateForm(@PathVariable int boardId, HttpServletRequest request) {
        Board board = boardRepository.findById(boardId);
        request.setAttribute("board", board);

        return "/board/updateForm";
    }

    @PostMapping("/board/{boardId}/delete")
    public String delete(@PathVariable int boardId, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        Board board = boardRepository.findById(boardId);
      
        if (board == null) {
            request.setAttribute("msg", "해당 아이디를 찾을 수 없습니다.");
            request.setAttribute("status", "404");
          
            return "/error";
        } else {
            boardRepository.deleteById(boardId);
          
            return "redirect:/user/" + user.getId();
        }
    }
}

package shop.mtcoding.projectjobplan.resume;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projectjobplan.board.BoardResponse;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ResumeController {
    private final ResumeRepository resumeRepository;



    @GetMapping("/resume/main")
    public String main() {
        return "/resume/main";
    }
    @GetMapping("/resume/listings")
    public String listings(HttpServletRequest request, @RequestParam(defaultValue = "1")int page) {
        // 기업 메인 페이지
        List<ResumeResponse.ResumeAndUserDTO> responseDTO = resumeRepository.findByResumeAndUser(page);
        List<ResumeResponse.ResumeAndUserDTO> resumeList = new ArrayList<>();
        for (ResumeResponse.ResumeAndUserDTO dto : responseDTO) {
            if (dto.isEmployer()==false) {
                resumeList.add(dto);
            }
        }
        request.setAttribute("resumeList", resumeList);

        int currentPage = page;
        int nextPage = currentPage + 1;
        int prevPage = currentPage - 1;

        request.setAttribute("nextPage", nextPage);
        request.setAttribute("prevPage", prevPage);


        boolean first = (currentPage == 1 ? true : false);
        request.setAttribute("first", first);

        int totalPage = resumeRepository.countIsEmployerFalse();

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



        return "/resume/listings";
    }
    @GetMapping("/resume/uploadForm")
    public String uploadForm() {
        return "/resume/uploadForm";
    }
    @GetMapping("/resume/1/updateForm")
    public String updateForm() {
        return "/resume/updateForm";
    }
    @GetMapping("/resume/1")
    public String detail() {
        return "/resume/detail";
    }
}

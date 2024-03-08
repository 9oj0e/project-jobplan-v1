package shop.mtcoding.projectjobplan.resume;

import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan._core.PagingUtil;
import shop.mtcoding.projectjobplan.board.BoardResponse;
import shop.mtcoding.projectjobplan.pic.Pic;
import shop.mtcoding.projectjobplan.pic.PicRepository;
import shop.mtcoding.projectjobplan.pic.PicRequest;
import shop.mtcoding.projectjobplan.rating.Rating;
import shop.mtcoding.projectjobplan.rating.RatingRepository;
import shop.mtcoding.projectjobplan.skill.Skill;
import shop.mtcoding.projectjobplan.skill.SkillRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRequest;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ResumeController {
    private final ResumeRepository resumeRepository;
    private final SkillRepository skillRepository;
    private final HttpSession session;
    private final PicRepository picRepository;
    private final RatingRepository ratingRepository;

    @PostMapping("resume/{id}/update")
    public String update(@PathVariable int id, ResumeRequest.UpdateDTO requestDTO){
        // todo 유효성 검사, 권한 검사
        resumeRepository.updateById(requestDTO, id);
        User user = (User) session.getAttribute("sessionUser");

        return "redirect:/user/" + user.getId();
    }

    @PostMapping("/resume/upload")
    public String upload(ResumeRequest.SaveDTO requestDTO){

        User sessionUser = (User) session.getAttribute("sessionUser");

        // todo 유효성 검사, 권한 검사
         resumeRepository.save(requestDTO, sessionUser.getId());

        return "redirect:/user/" + sessionUser.getId();
    }

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

        // 페이지네이션 모듈
        int totalPage = resumeRepository.countIsEmployerFalse();;
        PagingUtil paginationHelper = new PagingUtil(totalPage, page);

        request.setAttribute("nextPage", paginationHelper.getNextPage());
        request.setAttribute("prevPage", paginationHelper.getPrevPage());
        request.setAttribute("first", paginationHelper.isFirst());
        request.setAttribute("last", paginationHelper.isLast());
        request.setAttribute("numberList", paginationHelper.getNumberList());

        return "/resume/listings";
    }

    @GetMapping("/resume/{id}")
    @PostMapping("/resume/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request, Model model) {
        model.addAttribute("resumeList", resumeRepository.findResumeId(id));
        ResumeResponse.ResumeDetailDTO resumeDetailDTO = resumeRepository.detail(id);
        request.setAttribute("detail", resumeDetailDTO);

        Resume resume = resumeRepository.findById(id);
        Double avgRate = ratingRepository.findAvgRateBySubjectId(resume.getUserId());
        model.addAttribute("avgRate", avgRate);

        return "/resume/detail";
    }

//    @PostMapping("/resume/{id}")
//    public String detail(Model model, @PathVariable int id) {
//        Resume resume = resumeRepository.findById(id);
//        Double avgRate = ratingRepository.findAvgRateBySubjectId(resume.getUserId());
//        model.addAttribute("avgRate", avgRate);
//
//        return "/resume/detail";
//    }


    @GetMapping("/resume/uploadForm")
    public String uploadForm() {
        return "/resume/uploadForm";
    }
    @GetMapping("/resume/{id}/updateForm")
    public String updateForm(@PathVariable int id, HttpServletRequest request) {
        Resume resume = resumeRepository.findById(id);
        request.setAttribute("resume", resume);

        return "/resume/updateForm";
    }

    @PostMapping("/resume/{id}/delete")
    public String delete(@PathVariable int id, HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        Resume resume = resumeRepository.findById(id);
        if (resume == null) {
            request.setAttribute("msg", "해당 아이디를 찾을 수 없습니다.");
            request.setAttribute("status", "404");
            return "/error";
        } else {
            resumeRepository.deleteById(id);
            return "redirect:/user/" + user.getId();
        }
    }
}

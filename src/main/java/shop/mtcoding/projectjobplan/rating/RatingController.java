package shop.mtcoding.projectjobplan.rating;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan.board.Board;
import shop.mtcoding.projectjobplan.board.BoardRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;
import shop.mtcoding.projectjobplan.user.UserRequest;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;

@Controller
@RequiredArgsConstructor
public class RatingController {
    private final HttpSession session;
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final BoardRepository boardRepository;
    private final ResumeRepository resumeRepository;

    @PostMapping("/rating/score/{boardId}") // todo : "/board/{boardId}/rate"
    public String rateBoard(@RequestParam("rating") int score, @PathVariable int boardId, HttpServletRequest request, RatingRequest.RatingDTO requestDTO, Model model) {
        User user = (User) session.getAttribute("sessionUser");
        int raterId = user.getId(); // 평가자 ID 불러오기
        //int rate = requestDTO.getRate(); // 점수 불러오기
        model.addAttribute("score", score);

        // 보드 id로 기업 id 불러오기
        Board board = boardRepository.findById(boardId);
        int subjectId = board.getEmployerId();

        // 평가자, 피평가자, 점수 insert
        ratingRepository.upload(raterId, subjectId, score);

        return "redirect:/board/" + id;
    }
    @PostMapping("/rating/score/{resumeId}") // "todo : /resume/{resumeId}/rate"
    public String rateResume(@RequestParam("rate") int rate, @PathVariable int resumeId, Model model) {
        System.out.println(resumeId+"⭐");
        User user = (User) session.getAttribute("sessionUser");
        Integer raterId = user.getId();
        System.out.println(raterId+"⭐⭐");

        if (raterId != null) {
            int subjectId = resumeRepository.findById(resumeId).getUserId();
            System.out.println(subjectId+"⭐⭐⭐");
            ratingRepository.upload(raterId, subjectId, rate);
            System.out.println(rate+"⭐⭐⭐⭐");
            Resume resume = resumeRepository.findById(resumeId);
            System.out.println(resume+"⭐⭐⭐⭐⭐⭐");
            Double avgRate = ratingRepository.findAvgRateBySubjectId(resume.getUserId());
            System.out.println(avgRate+"⭐⭐⭐⭐⭐⭐⭐");
            model.addAttribute("avgRate", avgRate);
            return "redirect:/resume/"+resumeId;
        } else {
            return "redirect:/login";
        }
    }
}

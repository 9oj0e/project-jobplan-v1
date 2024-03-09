package shop.mtcoding.projectjobplan.rating;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projectjobplan.resume.Resume;
import shop.mtcoding.projectjobplan.resume.ResumeRepository;
import shop.mtcoding.projectjobplan.user.User;

@Controller
@RequiredArgsConstructor
public class RatingController {
    private final RatingRepository ratingRepository;
    private final ResumeRepository resumeRepository;
    private final HttpSession session;

    @PostMapping("/rating/score/{resumeId}")
    public String uploadRate(@PathVariable int resumeId, @RequestParam("rate") int rate, Model model) {
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

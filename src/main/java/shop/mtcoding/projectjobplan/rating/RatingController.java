package shop.mtcoding.projectjobplan.rating;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projectjobplan.board.Board;
import shop.mtcoding.projectjobplan.board.BoardRepository;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;
import shop.mtcoding.projectjobplan.user.UserRequest;

@RequiredArgsConstructor
@Controller
public class RatingController {

    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final BoardRepository boardRepository;
    private final HttpSession session;

    @PostMapping("/rating/score/{id}") // 보드아이디임
    public String ratingScore(@RequestParam("rating") int score, @PathVariable int id, HttpServletRequest request, RatingRequest.RatingDTO requestDTO, Model model) {
//        User user = userRepository.findByUsernameAndPassword(loginRequestDTO);
//        int userId = user.getId();

        User user = (User) session.getAttribute("sessionUser");
        int userId = user.getId(); // 평가자 ID 불러오기
        //int rate = requestDTO.getRate(); // 점수 불러오기
        System.out.println(userId); // user1 -> 6
        System.out.println(score); // 점수 적용 완료
        model.addAttribute("score", score);

        // 보드 id로 기업 id 불러오기
        System.out.println(id); // 18
        Board board = boardRepository.findEmpIdById(id);
        int employerId = board.getEmployerId();
        System.out.println(employerId);

        // 평가자, 피평가자, 점수 insert
        ratingRepository.insertRating(userId, employerId, score);



        return "redirect:/board/" + id;
    }
}

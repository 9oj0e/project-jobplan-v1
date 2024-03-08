package shop.mtcoding.projectjobplan.rating;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class RatingController {

    @GetMapping("/rating/score/{id}")
    public String ratingScore() {
        return null;
    }
}

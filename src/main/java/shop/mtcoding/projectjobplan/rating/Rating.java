package shop.mtcoding.projectjobplan.rating;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rating_tb")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer raterId; // 평가자 ID
    private Integer subjectId; // 피평가자 ID
    private Double rate; // 점수
}

package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Column(nullable = false)
    private String title;
    private String preference;
    private String task;
    private String salary; // annual salary
    private String benefit; // fringe benefit
    private String hiringProcess;
    private String hiringPosition;
    private String field; // recruitment field
    private String position;
    private String positionDetail;
    private Timestamp openingDate; // 게시일
    private Timestamp closingDate; // 마감일
    // closingDate == null -> "상시채용"
    private Timestamp createdAt; // 생성일
}

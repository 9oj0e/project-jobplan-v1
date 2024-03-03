package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId; // 게시자 id
    private String businessName; // 게시자 회사명
    // @Column(nullable = false)
    private String title; // 제목
    private String content; // 내용
    private String address; // 지역
    private String field; // 채용 분야
    private String position; // 포지션
    private String salary; // 연봉
    // 날짜

    private Timestamp openingDate; // 게시일
    private Timestamp closingDate; // 마감일
    // closingDate == null -> "상시채용"
    private Timestamp createdAt; // 생성일
}

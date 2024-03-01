package shop.mtcoding.projectjobplan.resume;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "resume_tb")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId; // writtenBy
    private String title;
    private String content; // cv, cover letter 자기소개서
    private String schoolName;
    private String major;
    private String educationLevel; // 고졸/초대졸/대졸
    // 경력 career_tb로 분리 회사명, 경력..
    private String career; // 회사명+경력
    private Timestamp createdAt;
}

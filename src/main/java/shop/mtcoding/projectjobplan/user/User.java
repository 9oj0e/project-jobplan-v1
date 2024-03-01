package shop.mtcoding.projectjobplan.user;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Timestamp birthdate;
    private char gender; // 'M' or 'F'
    private Integer phoneNumber;
    private String address;
    private String email;

    private List<Skill> skills = new ArrayList<>();
    public void addSkill(Skill skill){
        skills.add(skill);
    }

    // employer, 사업자 항목 nullable
    private boolean isEmployer; // 사업자인지
    private Integer employerIdNumber; // 사업자번호
    private String businessName; // 기업이름
    private Timestamp createdAt;
}

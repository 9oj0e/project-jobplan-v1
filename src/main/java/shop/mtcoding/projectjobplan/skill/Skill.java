package shop.mtcoding.projectjobplan.skill;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "skill_tb")
public class Skill { // Tech Stack
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer resumeId; // null 허용  -> 5
    private Integer boardId; // 1          -> null

    private String name;
}
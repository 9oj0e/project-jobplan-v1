package shop.mtcoding.projectjobplan.subscribe;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "subscribe_tb")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer boardId;
    private Integer boardUserId;
    private Integer resumeId;
    private Integer resumeUserId;
    private Timestamp createdAt;

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdAt.toLocalDateTime().format(formatter);
    }
}

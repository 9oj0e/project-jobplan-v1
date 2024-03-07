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
    private int id;
    private int userId;
    private int boardId;
    private int boardUserId;
    private int resumeId;
    private int resumeUserId;
    private Timestamp createdAt;

    public String getCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return createdAt.toLocalDateTime().format(formatter);
    }
}

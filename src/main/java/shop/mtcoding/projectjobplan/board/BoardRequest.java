package shop.mtcoding.projectjobplan.board;

import lombok.Data;

import java.sql.Timestamp;

public class BoardRequest {
    @Data
    public class SaveDTO {
        // (user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
        private int userId;
        private String title;
        private String content;
        private String field;
        private String position;
        private String salary;
        private String openingDate;
        private String closingDate;
    }

    @Data
    public class UpdateDTO {
        // 수정시 userId(작성자)는 변할 수 없다.
        private String title;
        private String content;
        private String field;
        private String position;
        private String salary;
        private String openingDate;
        private String closingDate;
    }
}

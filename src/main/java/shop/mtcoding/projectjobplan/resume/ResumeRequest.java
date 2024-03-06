package shop.mtcoding.projectjobplan.resume;

import lombok.Data;

import java.util.List;

public class ResumeRequest {
    @Data
    public class SaveDTO {
        // title, cv, schoolName, major, educationLevel, career
        private String title;
        private String content;
        private String schoolName;
        private String major;
        private String educationLevel;
        private String career;

        private List<String> skill; // checkbox 5개 -> name 을 통일 skills
    }

    @Data
    public class UpdateDTO {

        private String title;
        private String content;
        private String schoolName;
        private String major;
        private String educationLevel;
        private String career;
    }
}

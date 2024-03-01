package shop.mtcoding.projectjobplan.resume;

import lombok.Data;

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

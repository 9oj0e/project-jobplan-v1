package shop.mtcoding.projectjobplan.resume;

import lombok.Data;

import java.sql.Timestamp;

public class ResumeResponse {
    @Data
    public static class ResumeAndUserDTO{
        private Integer id;
        private Integer userId; // writtenBy
        private String title;
        private String content; // cv, cover letter 자기소개서
        private String career; // 회사명+경력

        private String address;

        // employer, 사업자 항목 nullable
        private boolean isEmployer; // 사업자인지
        private String name ;
    }

    @Data
    public static class ResumeDetailDTO{
        private Integer id;
        private String name;
        private String address;
        private String phoneNumber;
        private String email;

        private Integer userId;
        private String title;
        private String educationLevel;
        private String major;
        private String schoolName;
        private String content;
        // ID NAME ADDRESS PHONE_NUMBER EMAIL USER_ID
        // TITLE EDUCATION_LEVEL MAJOR SCHOOL_NAME CONTENT
    }

}




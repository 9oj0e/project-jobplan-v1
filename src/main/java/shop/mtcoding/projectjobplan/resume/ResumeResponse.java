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
    }



    }




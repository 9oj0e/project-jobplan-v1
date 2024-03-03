package shop.mtcoding.projectjobplan.board;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class BoardResponse {

    @Data
    public static class boardAndUserDTO{
        private Integer id;
        private Integer userId;
        private String title; // 제목
        private String content; // 내용
        private String field; // 채용 분야
        private String position; // 포지션
        private String salary; // 연봉

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Timestamp openingDate; // 게시일

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Timestamp closingDate; // 마감일

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Timestamp createdAt; // 생성일

        private String username;
        private String address;
        private boolean isEmployer; // 사업자인지
        private String businessName;

    }

}

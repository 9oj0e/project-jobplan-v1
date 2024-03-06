package shop.mtcoding.projectjobplan.apply;

import lombok.Data;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class ApplyResponse {
    @Data
    public static class ToEmployerDTO{ // 지원자 현황 (기업)
        private String boardTitle;
        private Integer boardId;
        private String applicantName;
        private String resumeTitle;
        private Integer resumeId;
        private Timestamp appliedAt; // 지원 날짜

        public String getBoardTitle(){
            String input = this.boardTitle; // 입력받은 문자열
            int maxLength = 8; // 최대 길이

            String output;
            if (input.length() > maxLength) {
                output = input.substring(0, maxLength) + "...";
            } else {
                output = input;
            }

            return output;
        }
        public String getResumeTitle(){
            String input = this.resumeTitle; // 입력받은 문자열
            int maxLength = 8; // 최대 길이

            String output;
            if (input.length() > maxLength) {
                output = input.substring(0, maxLength) + "...";
            } else {
                output = input;
            }

            return output;
        }
        public String getAppliedAt(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return appliedAt.toLocalDateTime().format(formatter);
        }
        private Boolean status;
    }
    @Data
    public static class ToUserDTO{ // 지원 현황 (개인)
        private String resumeTitle;
        private Integer resumeId;
        private String businessName; // 회사명
        private String boardTitle;
        private Integer boardId;
        private Timestamp appliedAt; // 지원 날짜

        public String getAppliedAt(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return appliedAt.toLocalDateTime().format(formatter);
        }
        private Boolean status;
    }
}

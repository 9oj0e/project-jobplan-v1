package shop.mtcoding.projectjobplan.apply;

import lombok.Data;

public class ApplyResponse {
    @Data
    public class ToEmployerDTO{ // 지원자 현황 (기업)
        private String boardTitle;
        private String applicantName;
        private String applicationTitle;
        private String appliedAt; // 지원 날짜
        private Boolean status;
    }
    @Data
    public class ToUserDTO{ // 지원 현황 (개인)
        private String applicationTitle;
        private String businessName;
        private String boardTitle;
        private String appliedAt; // 지원 날짜
        private Boolean status;
    }
}

package shop.mtcoding.projectjobplan.apply;

import lombok.Data;

public class ApplyResponse {
    @Data
    public class ForEmployerDTO{
        private String boardTitle;
        private String applicantName;
        private String applicationTitle;
        private String appliedAt; // 지원 날짜
    }
    @Data
    public class ForUserDTO{
        private String applicationTitle;
        private String businessName;
        private String boardTitle;
        private String appliedAt; // 지원 날짜
    }
}

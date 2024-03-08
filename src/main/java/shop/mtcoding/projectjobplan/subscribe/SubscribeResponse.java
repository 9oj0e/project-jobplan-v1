package shop.mtcoding.projectjobplan.subscribe;

import lombok.Data;

public class SubscribeResponse {

    @Data
    public class ToUserDTO {
    }

    @Data
    public static class ToEmployerDTO {
        private Integer resumeId;
        private String resumeUsername;
        private String title;
    }
}

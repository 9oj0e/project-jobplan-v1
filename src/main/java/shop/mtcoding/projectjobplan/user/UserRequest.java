package shop.mtcoding.projectjobplan.user;

import lombok.Data;

import java.sql.Timestamp;

public class UserRequest {
    @Data
    public class SaveDTO {
        private String username;
        private String password;
        private String name;
        private Timestamp birthdate;
        private Character gender;
        private Integer phoneNumber;
        private Integer address;
        private Integer email;
        // emp
        private Boolean isEmployer;
        private Integer employerIdNumber;
        private String businessName;
    }

    @Data
    public class UpdateDTO {
        private String username;
        private String password;
        private String name;
        private Timestamp birthdate;
        private Character gender;
        private Integer phoneNumber;
        private Integer address;
        private Integer email;
        // emp
        private Boolean isEmployer;
        private Integer employerIdNumber;
        private String businessName;
    }
}

package shop.mtcoding.projectjobplan.user;

import lombok.Data;

public class UserResponse {
    @Data
    public static class infoDTO {
        private String username;
        private String password;
        private String name;
        private String birthdate;
        private char gender; // 'M' or 'F'
        private String phoneNumber;
        private String address;
        private String email;
    }
}

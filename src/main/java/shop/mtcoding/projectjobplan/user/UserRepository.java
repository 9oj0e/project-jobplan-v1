package shop.mtcoding.projectjobplan.user;

import com.sun.tools.javac.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager entityManager;

    @Transactional
    public UserResponse.infoDTO info() {
        Query query = entityManager.createNativeQuery("""
            select name, username, password, birthdate, gender, phone_number, address, email
            from user_tb
            where id = 1
            """);
        Object[] row = (Object[]) query.getSingleResult();
        String name = (String) row[0];
        String username = (String) row[1];
        String password = (String) row[2];
        String birthdate = (String) row[3];
        Character gender = (Character) row[4];
        String phoneNumber = (String) row[5];
        String address = (String) row[6];
        String email = (String) row[7];

        UserResponse.infoDTO infoDTO = new UserResponse.infoDTO();
        infoDTO.setName(name);
        infoDTO.setUsername(username);
        infoDTO.setPassword(password);
        infoDTO.setBirthdate(birthdate);
        infoDTO.setGender(gender);
        infoDTO.setPhoneNumber(phoneNumber);
        infoDTO.setAddress(address);
        infoDTO.setEmail(email);
        return infoDTO;
    }

    @Transactional
    public Integer save(UserRequest.SaveDTO requestDTO) {
        String q = """
                INSERT INTO user_tb
                (username, password, name, birthdate, gender, phone_number, address, email,
                 is_employer, employer_id_number, business_name, created_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?,
                 ?, ?, ?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());
        query.setParameter(3, requestDTO.getName());
        query.setParameter(4, requestDTO.getBirthdate());
        query.setParameter(5, requestDTO.getGender());
        query.setParameter(6, requestDTO.getPhoneNumber());
        query.setParameter(7, requestDTO.getAddress());
        query.setParameter(8, requestDTO.getEmail());

        query.setParameter(9, requestDTO.getIsEmployer());
        query.setParameter(10, requestDTO.getEmployerIdNumber());
        query.setParameter(11, requestDTO.getBusinessName());

        return query.executeUpdate(); // 영향 받은 행
    }
    /* 모든 유저를 조회할 필요가..?
    public List<User> findAll() {
        String q = "select * from resume_tb order by id desc";
        Query query = entityManager.createNativeQuery(q, User.class);

        return (List<User>) query.getResultList();

    }
    */
    public List<User> findAll(){
        Query query = entityManager.createNativeQuery("select * from user_tb order by id desc;", User.class);

        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    public User findById(Integer id) {
        String q = "select * from resume_tb where id = ? order by id desc";
        Query query = entityManager.createNativeQuery(q, User.class);
        query.setParameter(1, id);

        return (User) query.getSingleResult();
    }

    @Transactional
    public Integer updateById(UserRequest.UpdateDTO requestDTO, Integer id) {
        String q = """
                UPDATE user_tb
                SET
                username = ?,
                password = ?,
                name = ?,
                birthdate = ?,
                gender = ?,
                phone_number = ?,
                address = ?,
                email = ?,
                is_employer = ?,
                employer_id_number = ?,
                business_name = ?
                WHERE id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, requestDTO.getUsername());
        query.setParameter(2, requestDTO.getPassword());
        query.setParameter(3, requestDTO.getName());
        query.setParameter(4, requestDTO.getBirthdate());
        query.setParameter(5, requestDTO.getGender());
        query.setParameter(6, requestDTO.getPhoneNumber());
        query.setParameter(7, requestDTO.getAddress());
        query.setParameter(8, requestDTO.getEmail());

        query.setParameter(9, requestDTO.getIsEmployer());
        query.setParameter(10, requestDTO.getEmployerIdNumber());
        query.setParameter(11, requestDTO.getBusinessName());

        return query.executeUpdate(); // 영향 받은 행
    }
    /* 계정 탈퇴
    @Transactional
    public Integer deleteById(Integer id) {
        String q = "DELETE FROM user_tb WHERE id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);

        return query.executeUpdate(); // 영향 받은 행
    }
    */
}

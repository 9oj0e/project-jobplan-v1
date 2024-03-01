package shop.mtcoding.projectjobplan.resume;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projectjobplan.board.BoardResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ResumeRepository {
    private final EntityManager entityManager;


    public List<ResumeResponse.ResumeAndUserDTO> findByResumeAndUser(){
        String q = """
                select r.id,r.user_id,r.title,r.content,r.career,u.address,u.is_employer,u.name  from resume_tb r inner join user_tb u on r.user_id = u.id ;
                """;
        Query query = entityManager.createNativeQuery(q);
        List<Object[]> results = query.getResultList();
        List<ResumeResponse.ResumeAndUserDTO> responseDTO = new ArrayList<>();

        for(Object[] result :results){

            ResumeResponse.ResumeAndUserDTO dto = new ResumeResponse.ResumeAndUserDTO();
            dto.setId((Integer) result[0]);
            dto.setUserId((Integer) result[1]);
            dto.setTitle((String) result[2]);
            dto.setContent((String) result[3]);
            dto.setCareer((String) result[4]);
            dto.setAddress((String) result[5]);
            dto.setEmployer((boolean) result[6]);
            dto.setName((String) result[7]);



            responseDTO.add(dto);
        }
        return responseDTO;

    }

    @Transactional
    public Integer save(ResumeRequest.SaveDTO requestDTO, Integer userId) {
        String q = """
                INSERT INTO resume_tb
                (user_id, title, content, school_name, major, education_level, career, created_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, userId);
        query.setParameter(2, requestDTO.getTitle());
        query.setParameter(3, requestDTO.getContent());
        query.setParameter(4, requestDTO.getSchoolName());
        query.setParameter(5, requestDTO.getMajor());
        query.setParameter(6, requestDTO.getEducationLevel());
        query.setParameter(7, requestDTO.getCareer());

        return query.executeUpdate(); // 영향 받은 행
    }

    public List<Resume> findAll() {
        String q = "select * from resume_tb order by id desc";
        Query query = entityManager.createNativeQuery(q, Resume.class);

        return (List<Resume>) query.getResultList();

    }

    public Resume findById(Integer id) {
        String q = "select * from resume_tb where id = ? order by id desc";
        Query query = entityManager.createNativeQuery(q, Resume.class);
        query.setParameter(1, id);

        return (Resume) query.getSingleResult();
    }

    @Transactional
    public Integer updateById(ResumeRequest.UpdateDTO requestDTO, Integer id) {
        String q = """
                UPDATE resume_tb
                SET
                title = ?,
                content = ?,
                school_name = ?,
                major = ?,
                education_level = ?,
                career = ?
                WHERE id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, requestDTO.getTitle());
        query.setParameter(2, requestDTO.getContent());
        query.setParameter(3, requestDTO.getSchoolName());
        query.setParameter(4, requestDTO.getMajor());
        query.setParameter(5, requestDTO.getEducationLevel());
        query.setParameter(6, requestDTO.getCareer());
        query.setParameter(7, id);

        return query.executeUpdate(); // 영향 받은 행
    }

    @Transactional
    public Integer deleteById(Integer id) {
        String q = "DELETE FROM resume_tb WHERE id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);

        return query.executeUpdate(); // 영향 받은 행
    }
}

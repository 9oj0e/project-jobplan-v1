package shop.mtcoding.projectjobplan.apply;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ApplyRepository {
    private final EntityManager entityManager;

    @Transactional
    public int upload(ApplyRequest.UploadDTO requestDTO){
        return 0;
    }
    public List<ApplyResponse.ToEmployerDTO> findByEmployerId(Integer sessionUserId){
        String q = """
                SELECT b.title, b.id, u.name, r.title, r.id, a.created_at, a.status
                FROM apply_tb AS a
                JOIN board_tb AS b ON a.board_user_id = b.employer_id
                JOIN user_tb AS u ON a.resume_user_id = u.id
                JOIN resume_tb AS r ON a.resume_id = r.id
                WHERE a.board_user_id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, sessionUserId);
        List<Object[]> rawResultList = query.getResultList();
        List<ApplyResponse.ToEmployerDTO> responseDTO = new ArrayList<>();
        for (Object[] r : rawResultList ) {
            ApplyResponse.ToEmployerDTO dto = new ApplyResponse.ToEmployerDTO();
            dto.setBoardTitle((String) r[0]);
            dto.setBoardId((Integer) r[1]);
            dto.setApplicantName((String) r[2]);
            dto.setResumeTitle((String) r[3]);
            dto.setResumeId((Integer) r[4]);
            dto.setAppliedAt((Timestamp) r[5]);

            responseDTO.add(dto);
        }

        return responseDTO;
    }
    public List<ApplyResponse.ToUserDTO> findByUserId(Integer sessionUser){
        String q = """
                SELECT 
                  r.title AS resume_title,
                  a.resume_id,
                  u.business_name,
                  b.title AS board_title,
                  b.id,
                  a.created_at
               FROM apply_tb a
               JOIN resume_tb r ON a.resume_id = r.id
               JOIN board_tb b ON a.board_id = b.id
               JOIN user_tb u ON a.board_user_id = u.id
               WHERE a.resume_user_id = ?;
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, sessionUser);
        List<Object[]> rawResultList = query.getResultList();
        List<ApplyResponse.ToUserDTO> responseDTO = new ArrayList<>();
        for (Object[] r : rawResultList){
            ApplyResponse.ToUserDTO dto = new ApplyResponse.ToUserDTO();
            dto.setResumeTitle((String) r[0]);
            dto.setResumeId((Integer) r[1]);
            dto.setBusinessName((String) r[2]);
            dto.setBoardTitle((String) r[3]);
            dto.setBoardId((Integer) r[4]);
            dto.setAppliedAt((Timestamp) r[5]);
            responseDTO.add(dto);
        }

        return responseDTO;
    }
    @Transactional
    public int update(ApplyRequest.UpdateDTO requestDTO){
        return 0;
    }
    @Transactional
    public int deleteByEmployerId(){
        return 0;
    }
    @Transactional
    public int deleteByUserId(){
        return 0;
    }
}
